/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC_plus_1099_two_sum_less_than_k
 * Date Created : 2024-01-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-15       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-15
 **/
public class LC_plus_1099_two_sum_less_than_k {
    /**
     * 22  33
     * 24  35
     * 33  22
     * 35  24
     * @param args
     */
    public static void main(String[] args) {
        //int[] nums = new int[]{647,918,961,511,701,599,889,137,936,526,728,43,834,965,204,180,213,126,648,542,995,486,112,833,100,20,926,967,971,639,337,198,433,285,9,297,721,845,916,671,834,342,28,763,849,981,143,418,980,171};
        int[] nums = new int[]{254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
        System.out.println(twoSumLessThanK2(nums, 200));
    }
    public static int twoSumLessThanK(int[] nums, int k) {
        //Array.sort(nums);
        int sum = -1;
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == 397){
                    System.out.println(i + " " + j);
                }
                if(nums[i]+nums[j]<k){
                    int tempSum = nums[i]+nums[j];
                    sum = sum> tempSum?sum:tempSum;

                }
            }
        }
        return sum;
    }
    public static int twoSumLessThanK2(int[] nums, int k) {
        Arrays.sort(nums);
        int index1=0,index2=nums.length-1;
        int result = -1;
        while(index1<index2){
            int tempSum = nums[index1]+nums[index2];
            if(tempSum>=k){
                index2--;
            }else if(tempSum<k){

                result = result>tempSum?result:tempSum;
                index1++;
            }
        }
        return result;
    }
}