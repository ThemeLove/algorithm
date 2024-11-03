## 动态规划
### 动态规划解题 五步曲
1.dp数组的定义以及下标的含义
2.递推公式
3.dp数组如何初始化
4.遍历顺序
5.打印dp数组帮助debug

### 01背包问题（一件物品只能使用一次）
帮助理解视频：https://www.bilibili.com/video/BV1pY4y1J7na/?spm_id_from=333.337.search-card.all.click&vd_source=b859174ae70e495ba11b3c433be2a7ee

#### 常见场景和递推公式
##### 1.纯01背包的问题：背包容量(体积或重量)限制，问背包能装的最大价值。
        KamaCoder 46题：https://kamacoder.com/problempage.php?pid=1046

        具体场景：
            背包最大重量为bagSize(4)。
            物品为：
                    重量    价值
            物品0	1	    15
            物品1	3	    20
            物品2	4	    30
        物品重量数组：weights = {1, 3, 4}
        物品价值数组：values = {15, 20, 30}

        求解：背包最大能装的最大价值

```
二维数组解法
        // dp数组的定义：dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[weights.length][bagSize+1];
        // init 初始化 dp[0][j]行，只有物品0的重量<=背包重量的时候，才可以放入背包
        for(int j = weights[0]; j < bagSize; j++) {
            dp[0][j] = values[0];
        }

        // 精简版 先遍历物品，再遍历背包，顺序可以调整
        for (int i = 1; i < weights.length; i++) { // 遍历物品
            for (int j = weights[i]; j <= bagSize; j++) { // 遍历背包
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }
        return dp[weights.length-1][bagSize];

```
```
一维数组解法
        // dp数组的定义：dp[j]为 容量为j的背包所背的最大价值
        int[] dp = new int[bagSize+1];
        // init
        dp[0] = 0;

        // 精简版， 先遍历物品再倒序遍历背包，顺序不可颠倒
        for (int i = 0; i < weights.length; i++) { // 遍历物品
            for (int j = bagSize; j >= weights[i]; j--) { // 倒序遍历背包
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }
        return dp[bagSize];
```        

##### 2.能否正好装满背包问题：背包容量(体积或重量)限制，问能否正好装满背包，能(return true), 不能(return false)。
        a.LeetCode416->分割等和子集。即判断dp[i][bagSize] == bagSize

##### 3.正好装满背包有多少种方法：背包容量(体积或重量)限制，问正好装满背包有多少中方法。
        a.LeetCode494->目标和
```
一维数组解法（核心代码）
        // dp 数组的定义为：从0->i的物品中任意选取，正好装满容量为j的背包的组合数
        int[] dp = new int[targetSum+1];
        // 如果物品0 == 0， 则初始化为2，如果不等于0，则初始化为1
        // 物品0 == 0时，有不放和放2种方案
        dp[0] = nums[0] == 0 ? 2 : 1;
        // init
        for (int j = 1; j <= targetSum; j++) {
            if (nums[0] == j){
                dp[j] = 1;
            }else {
                dp[j] = 0;
            }
        }
        // 精简版 先遍历物品，再倒序遍历背包
        for (int i = 1; i < nums.length; i++) {
            for (int j = targetSum; j >= nums[i]; j--) {
                //当前物品装的下的话，当前物品可选 可 不选 2种情况，dp[i] 为其总和
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[targetSum];
```
##### 4.背包容量分2个维度，对应物品的2个维度：
        a.LeetCode474->一零和
```shell
        // dp 数组的定义：从物品strs中任选物品，装满m个0，n个1的背包，最多选几个物品
        int[][] dp = new int[m+1][n+1];
        // init,dp[0][0]表示装满0个0，0个1的背包最多放几个物品为0
        dp[0][0] = 0;
        // 因为本题的解是求放物品个数的最大值，所以初始化一般初始化为0，正解的话会在给dp数组赋值的过程中覆盖初始值，一般是Math.max实现
        // 1->m个0，0个1 的初始化,初始化为0,因为二维数组元素值默认为0，无需额外操作
        // 0个0,1->n个1 的初始化，初始化为0,因为二维数组元素值默认为0，无需额外操作

        // loop
        for (int i = 0; i < strs.length; i++) {//遍历物品
            int zeroNum = 0;
            int oneNum = 0;
            String str = strs[i];
            for(char ch: str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            // 精简版 2个维度倒序遍历背包
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeroNum][k-oneNum] + 1);
                }
            }
        }
        return dp[m][n];
```



### 完全背包问题（一件物品可以重复使用）


