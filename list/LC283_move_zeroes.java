/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC283_move_zeroes
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
public class LC283_move_zeroes {
    public static void main(String[] args) {
        System.out.println("case1");
        int[] nums1 = new int[]{0,1,0,3,12};
        moveZeroes(nums1);
        Tools.listPriter(nums1);

        System.out.println("case2");
        int[] nums2 = new int[]{0};
        moveZeroes(nums1);
        Tools.listPriter(nums2);
    }

    public static void moveZeroes(int[] nums) {
        int index = removeElement_labuladong(nums, 0);
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static int removeElement_labuladong(int[] nums, int val) {
        int slowerIndex = 0;
        int fasterIndex = 0;
        while (fasterIndex < nums.length) {
            if (nums[fasterIndex] != val) {
                nums[slowerIndex] = nums[fasterIndex];
                slowerIndex++;
            }
            fasterIndex++;
        }

        return slowerIndex;
    }
}