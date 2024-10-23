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

    public static void printArr(int[] intArr) {
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

    public static void printArr(char[] charArr) {
        if (charArr == null) {
            System.out.println("target arr is null.");
            return;
        }
        if (charArr.length == 0) {
            System.out.println("target arr is empty.");
            return;
        }

        System.out.print("target arr = [");

        for (int i = 0; i < charArr.length; i++) {
            if (i != charArr.length - 1) {
                System.out.print(charArr[i] + ",");
            } else {
                System.out.print(charArr[i]);
            }
        }
        System.out.println("]");
    }


    public static void printArr(byte[] arr) {
        if (arr == null) {
            System.out.println("target arr is null.");
            return;
        }
        if (arr.length == 0) {
            System.out.println("target arr is empty.");
            return;
        }

        System.out.print("target arr = [");

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
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

    public static void printMetrix(char[][] metrix) {
        int length = metrix.length;
        for (int i = 0; i < length; i++) {
            printArr(metrix[i]);
        }
    }

}
