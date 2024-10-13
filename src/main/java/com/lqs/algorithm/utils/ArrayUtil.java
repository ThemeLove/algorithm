package com.lqs.algorithm.utils;

public class ArrayUtil {

    public static void  printArr(Object[] objArr) {
        if (objArr == null) {
            System.out.println("target arr is null.");
            return;
        }
        if (objArr.length == 0) {
            System.out.println("target arr is empty.");
            return;
        }

        System.out.print("target arr = [");

        for (int i = 0; i < objArr.length; i++) {
            if (i != objArr.length -1) {
                System.out.print(objArr[i].toString()+", ");
            } else {
                System.out.print(objArr[i].toString());
            }
        }
        System.out.println("]");
    }

    public static void  printArr(int[] intArr) {
        if (intArr == null) {
            System.out.println("target arr is null.");
            return;
        }
        if (intArr.length == 0) {
            System.out.println("target arr is empty.");
            return;
        }

        System.out.print("target arr = [");

        for (int i = 0; i < intArr.length; i++) {
            if (i != intArr.length - 1) {
                System.out.print(intArr[i] + ",");
            } else {
                System.out.print(intArr[i]);
            }
        }
        System.out.println("]");
    }

    public static void printMetrix(int[][] metrix) {

        int length = metrix.length;

        for (int i = 0; i < length; i++) {

            printArr(metrix[i]);
        }

    }

}
