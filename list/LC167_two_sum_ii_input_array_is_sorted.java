/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC167_two_sum_ii_input_array_is_sorted
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
public class LC167_two_sum_ii_input_array_is_sorted {
    public static void main(String[] args) {
        System.out.println("case1,target=9,out=[1,2]");
        int[] nums1 = new int[]{2,7,11,15};
        Tools.listPriter(twoSum(nums1,9));

        System.out.println("case2,target=6,out=[1,3]");
        int[] nums2 = new int[]{2,3,4};
        Tools.listPriter(twoSum(nums2,6));

        System.out.println("case3,target=-1,out=[1,2]");
        int[] nums3 = new int[]{-1,0};
        Tools.listPriter(twoSum(nums3,-1));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        int currentValue = 0;
        while(left<right){
            currentValue=numbers[left]+numbers[right];
            if (currentValue == target){
                return new int[]{left+1, right+1};
            }else if(currentValue<target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}