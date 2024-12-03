/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC26_remove_duplicates_from_sorted_array
 * Date Created : 2023-10-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-23       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-23
 **/
public class LC26_remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        System.out.println(nums1[1]);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int slowerIndex = 0;
        int fasterIndex = 1;
        while (fasterIndex < nums.length) {
            if (nums[slowerIndex] != nums[fasterIndex]) {
                slowerIndex++;
                nums[slowerIndex] = nums[fasterIndex];
                fasterIndex++;
            } else {
                fasterIndex++;
            }
        }
        return slowerIndex + 1;
    }

    class Solution20241203 {
        public int removeDuplicates(int[] nums) {
            if(nums.length==0){
                return 0;
            }
            int fast=0,slow=0;
            while(fast<nums.length){
                while(fast<nums.length && nums[slow]==nums[fast]){
                    fast++;
                }
                slow++;
                if(fast<nums.length){
                    nums[slow]=nums[fast];
                }
            }
            return slow;
        }
    }
//为了保持和链表删除重复节点的思路一致
}