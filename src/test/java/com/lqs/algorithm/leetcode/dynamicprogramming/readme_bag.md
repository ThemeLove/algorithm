## 动态规划(背包问题)
### 01背包问题（一件物品只能使用一次）
```bash
  有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
```
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
        LeetCode416->分割等和子集。即判断dp[i][bagSize] == bagSize

##### 3.正好装满背包有多少种方法：背包容量(体积或重量)限制，问正好装满背包有多少中方法。
        LeetCode494->目标和
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
        LeetCode474->一零和
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
```bash
  有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
  完全背包和01背包问题唯一不同的地方就是，每种物品有无限件
  
  完全背包公式推导：https://www.bilibili.com/video/BV1ta411e7jt/?spm_id_from=333.337.search-card.all.click&vd_source=e4ce9f685d3cd2277925371c4c55f27f
```

##### 1.纯完全背包问题

```bash
二维数组解法
        // dp 数组的定义: dp[i][j] 表示从下标为[0-i]的物品里任意取,同一物品可重复，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[weights.length][bagSize+1];

        // init
        for (int j = weights[0]; j <= bagSize; j++) {
            dp[0][j] = dp[0][j-weights[0]] + values[0];
        }

        // 简化版本，遍历顺序可以颠倒
        for (int i = 1; i < weights.length; i++) { // 先遍历物品
            for (int j = weights[i]; j <= bagSize; j++) { // 再遍历背包
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i]] + values[i]);
            }
        }
        return dp[weights.length-1][bagSize];
```

```bash
一维数组解法
        // dp 数组的定义: dp[j] 表示从所有物品里任意取,同一物品可重复，放进容量为j的背包，价值总和最大是多少
        int[] dp = new int[bagSize + 1];

        // init 第一行
        for (int j = weights[0]; j <= bagSize; j++) {
            dp[j] = dp[j-weights[0]] + values[0];
        }

        // 简化版， 先遍历物品再遍历背包(也可先遍历背包，再遍历物品)
        for (int i = 0; i < weights.length ; i++) { // 遍历物品
            for (int j = weights[i]; j <= bagSize ; j++) { // 遍历背包
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }
        return dp[bagSize];
```

##### 2.求组合数(一定要先遍历物品，再遍历背包)
      LeetCode518 零钱兑换II
```bash
        // 从coins中任选，可重复，正好装满amount的组合数
        int[] dp = new int[amount+1];

        //init, 1 < coins[i] < 5000, coins 如果有0的话初始化不一样，如果coins[0] = 0, 对于dp[0] 来说有放和不放两种，这里其实不用考虑这种情况
        dp[0] = coins[0] == 0 ? 2 : 1;

        // loop
        // 先遍历物品，再遍历背包，才是求的组合数
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amount];
```

##### 3.求排列数(一定要先遍历背包，再遍历物品)
      LeetCode377 组合总和IV
      KamaCode57 爬楼梯进阶版(https://kamacoder.com/problempage.php?pid=1067)
```shell
        // dp 数组的定义, 从nums任选，可重复，正好组成target的排列数
        int[] dp = new int[target+1];
        dp[0] = 1;
        // 求排列数一定要先遍历背包，再遍历物品
        for (int j = 0; j <= target ; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
```

##### 4.求组合最少元素个数
      LeetCode322 零钱兑换
```shell
        // dp[j] 数组的定义：从coins任取，可重复，装满j的背包的最少元素个数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        // 非0下标初始化，因为是求最小值，所以
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 由于是求最小个数，和排列组合无关，所以先遍历物品或者先遍历背包都可以
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount];
```

### 多重背包问题
参考解释：https://programmercarl.com/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80%E5%A4%9A%E9%87%8D%E8%83%8C%E5%8C%85.html#%E5%A4%9A%E9%87%8D%E8%83%8C%E5%8C%85
```shell
有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。

多重背包和01背包是非常像的， 为什么和01背包像呢？

每件物品最多有Mi件可用，把Mi件摊开，其实就是一个01背包问题了。

例如：

背包最大重量为10。

物品为：

重量	价值	数量
物品0	1	15	2
物品1	3	20	3
物品2	4	30	2
问背包能背的物品最大价值是多少？

和如下情况有区别么？

重量	价值	数量
物品0	1	15	1
物品0	1	15	1
物品1	3	20	1
物品1	3	20	1
物品1	3	20	1
物品2	4	30	1
物品2	4	30	1
毫无区别，这就转成了一个01背包问题了，且每个物品只用一次。
```
##### 1.纯多重背包问题
      KamaCode56:https://kamacoder.com/problempage.php?pid=1066
```shell
        // 转化为01背包的问题
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        // 平铺重量
        int[] allWeights = new int[total];
        int weightInx = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                allWeights[weightInx] = weights[i];
                weightInx++;
            }
        }

        // 平铺价值
        int[] allValues = new int[total];
        int valueInx = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                allValues[valueInx] = values[i];
                valueInx++;
            }
        }

        // 01 背包解法
        int[] dp = new int[bagSize+1];

        // init

        // loop
        for (int i = 0; i < allWeights.length; i++) { // 先遍历物品
            for (int j = bagSize; j >= allWeights[i]; j--) {// 再倒序遍历背包
                dp[j] = Math.max(dp[j], dp[j-allWeights[i]] + allValues[i]);
            }
        }
        return dp[bagSize];
```





