/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR006_kLl5u1
 * Date Created : 2024-01-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-19       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-19
 **/
public class LCR006_kLl5u1 {
    public int[] twoSum(int[] numbers, int target) {
        // int left =0,right=numbers.length-1;
        // int[] result = new int[]{};
        // while(left<=right){
        //     int mid = left+(right-left)/2;
        //     if(numbers[left]+numbers[right]>target){
        //         right--;
        //     }else if (numbers[left]+numbers[right]<target){
        //         left++;
        //     }else if (numbers[left]+numbers[right]==target){
        //         result = new int[]{left,right};
        //         break;
        //     }
        // }
        // return result;

        int[] result = new int[]{-1,-1};
        for(int i = 0;i<numbers.length;i++){
            int newTarget = target-numbers[i];

            int left=i+1,right=numbers.length-1;

            while(left<=right){
                int mid = left+(right-left)/2;
                if(numbers[mid]>newTarget){
                    right = mid-1;
                }else if (numbers[mid]<newTarget){
                    left = mid+1;
                }else if(numbers[mid]==newTarget){

                    result = new int[]{i, mid};
                    break;
                }
            }
        }
        return result;
    }
}