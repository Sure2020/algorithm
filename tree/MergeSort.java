/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MergeSort
 * Date Created : 2023-11-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-14       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-14
 **/
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return; // 如果数组长度小于 2，则无需排序
        }

        // 计算中间索引
        int middle = length / 2;

        // 创建左右子数组
        int[] leftArray = Arrays.copyOfRange(array, 0, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, length);

        // 递归对左右子数组进行归并排序
        mergeSort(leftArray);
        mergeSort(rightArray);

        // 合并左右子数组
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0, j = 0, k = 0;

        // 合并左右子数组
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 将左子数组中剩余的元素复制到合并后的数组中
        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // 将右子数组中剩余的元素复制到合并后的数组中
        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
