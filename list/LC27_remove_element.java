/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC27_remove_element
 * Date Created : 2023-10-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-24       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-24
 **/
public class LC27_remove_element {
    public static void main(String[] args) {
        System.out.println("case1, out=2");
        int[] nums1 = new int[]{3, 2,2,3};
        System.out.println(removeElement_labuladong(nums1, 3));
        System.out.println("case1, out=5");
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement_labuladong(nums2, 2));
        System.out.println("case3, out=1");
        int[] nums3 = new int[]{2};
        System.out.println(removeElement_labuladong(nums3, 3));
    }

    public static int removeElement_labuladong(int[] nums, int val) {
        int slowerIndex = 0;
        int fasterIndex = 0;
        while(fasterIndex<nums.length){
            if (nums[fasterIndex]!=val){
                nums[slowerIndex]=nums[fasterIndex];
                slowerIndex++;
            }
            fasterIndex++;
        }

        return slowerIndex;
    }
    public static int removeElement(int[] nums, int val) {
        int slowerIndex = 0;
        int fasterIndex = 0;
        while(fasterIndex<nums.length){

            if (nums[slowerIndex] != val){
                slowerIndex++;
            }else if (nums[fasterIndex]!=val){
                int temp = nums[slowerIndex];
                nums[slowerIndex]=nums[fasterIndex];
                nums[fasterIndex] = temp;
                slowerIndex++;
            }

            fasterIndex++;
        }

        return slowerIndex;
    }

    class Solution20241203 {
        public int removeElement(int[] nums, int val) {
            int length = nums.length;
            if(length==0){
                return 0;
            }
            int fast=0,slow=0;
            while(fast<length){
                if(nums[fast]!=val){
                    nums[slow]=nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
//labuladong: 如果遇到需要跳过的，就告诉slow，记录下来并让slow跳过
//slow所指的位置，要么是原来的值，要么是等于val，可以被覆盖的值。
}