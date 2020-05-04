package com.mashibing.designModelForTank.strategy;

/**
 * @author hulinqi
 * @date 2020/5/4 --  14:36
 * @purpuse
 */

//选择排序
public class Sorter {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            swop(arr, i, minPos);
        }
    }

        public static void sort(Cat[] arr){
            for (int i = 0; i < arr.length - 1; i++ ){
                int minPos = i;

                for (int j = i+1; j < arr.length; j++ ){
                    minPos = arr[j].comparerTo(arr[minPos])==-1 ? j : minPos;
                }

                swop(arr,i,minPos);
            }
        }

    private static void swop(int[] arr, int i, int j) {
            int tep = arr[i];
            arr[i] = arr[j];
            arr[j] = tep;
        }

    private static void swop(Cat[] arr, int i, int j) {
        Cat tep = arr[i];
        arr[i] = arr[j];
        arr[j] = tep;
    }
}
