/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC268_missing_number
 * Date Created : 2024-01-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-11
 **/
public class LC268_missing_number {
    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        int result=0;
        System.out.println(result^=4^4);
        System.out.println(result^=4);
        System.out.println(3^3^2^0^1^1^0^0);
        System.out.println(3^0^0^3^1^0^2^1);
        //missingNumber(nums);
    }
    public static int missingNumber1(int[] nums) {
        int[] flagList = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            flagList[nums[i]]=1;
        }
        int j = 0;
        for(j = 0; j<nums.length;j++){
            if(flagList[j]==0){
                break;
            }
        }
        return j;

    }
    public int missingNumber(int[] nums) {
        // int[] flagList = new int[nums.length+1];
        // for(int i=0;i<nums.length;i++){
        //     flagList[nums[i]]=1;
        // }
        // int j = 0;
        // for(j = 0; j<nums.length;j++){
        //     if(flagList[j]==0){
        //         break;
        //     }
        // }
        // return j;
        int n = nums.length;
        int result = 0;
        result ^= (n^0);
        for(int i=0;i<n;i++){
            result ^= (i^nums[i]);
        }
        return result;
    }
}