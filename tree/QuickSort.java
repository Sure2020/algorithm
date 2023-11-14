/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : QuickSort
 * Date Created : 2023-11-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-08       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-08
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            /****** 前序遍历位置 ******/
            // 通过交换元素构建分界点 p
            int p = partition(nums, lo, hi);
            /************************/

            quickSort(nums, lo, p - 1);
            quickSort(nums, p + 1, hi);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = array[high];

        // Index of the smaller element
        int i = low - 1;

        // Traverse the array and swap elements as needed
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (put the pivot in the correct position)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }
}