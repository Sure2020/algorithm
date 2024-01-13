/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC349_intersection_of_two_arrays
 * Date Created : 2024-01-13
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-13       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-13
 **/
public class LC349_intersection_of_two_arrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null||nums2 == null){
            return null;
        }
        if (nums1.length == 0|| nums2.length == 0) {
            return new int[] {};
        }
        Set<Integer> resultSet = new HashSet<>();
        //int[] result = new int[nums1.length+nums2.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int index3=0;
        while (index1<nums1.length && index2<nums2.length){
            if (nums1[index1]<nums2[index2]){
                index1++;
            }else if (nums1[index1]==nums2[index2]){
                /*if (index3==0 || (result[index3-1]!=nums1[index1])){

                    result[index3] = nums1[index1];
                    index3++;
                }*/
                resultSet.add(nums1[index1]);
                index1++;
                index2++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }

        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        for (int i = 0; i < resultSet.size(); i++){
            result[i] = it.next();
        }
        return result;
    }
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}