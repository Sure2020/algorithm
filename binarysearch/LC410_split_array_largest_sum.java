/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC410_split_array_largest_sum
 * Date Created : 2024-02-22
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-22       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-22
 **/
public class LC410_split_array_largest_sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(solution.f(nums, 15));
        System.out.println(solution.splitArray(nums, 2));
    }
    static class Solution {
        public int splitArray(int[] nums, int k) {
            int left=0,right=0,mid=0;
            for(int i=0;i<nums.length;i++){
                left=Math.max(left, nums[i]);
                right+=nums[i];
            }
            System.out.println(left+"#$##"+right);
            while(left<=right){
                mid=left+(right-left)/2;
                //System.out.println(left+"###"+right+"###"+mid);
                if(f(nums, mid)>k){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            return left;
        }
        public int f(int[] nums, int x){
            int sums=0;
            //以后这个地方别写for了，因为会顺手把后面的i++写上，这次把自己坑了一把。以后写while吧！
            //for(int i=0;i<nums.length;i++){
            int i=0;
            while(i<nums.length){
                int cap = x;
                while(i<nums.length){
                    if(nums[i]>cap){
                        break;
                    }else{
                        cap-=nums[i];
                        i++;
                    }
                }
                sums++;
            }
            //System.out.println(sums+"### return ");
            return sums;
        }
    }
}