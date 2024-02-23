/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC724_find_pivot_index
 * Date Created : 2024-02-23
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-23       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * rightSum=total-leftSum-nums[i]，比较关键，将空间复杂度由2n降为1
 * @author: Admin
 * @create: 2024-02-23
 **/
public class LC724_find_pivot_index {
    class Solution {
        public int pivotIndex(int[] nums) {
            //经过实验，确实像宫水三叶所说，for循环(耗时0ms)算total确实比stream(耗时3ms)快，我自己写的三个for循环的版本，耗时1ms
            //int total = Arrays.stream(nums).sum();
            int total=0;
            for(int i=0;i<nums.length;i++){
                total+=nums[i];
            }
            int leftSum=0,rightSum=0;

            for(int i=0;i<nums.length;i++){
                rightSum = total-leftSum-nums[i];
                if(leftSum==rightSum){
                    return i;
                }
                leftSum+=nums[i];
            }
            return -1;
        }
    }
    class SolutionSelf {
        public int pivotIndex(int[] nums) {
            //printList(nums);
            int[] sumLeft = new int[nums.length+1];
            int[] sumRight = new int[nums.length+1];
            for(int i=1;i<=nums.length;i++){
                sumLeft[i]=sumLeft[i-1]+nums[i-1];
            }
            //printList(sumLeft);
            for(int j=nums.length-1;j>=1;j--){
                sumRight[j]=sumRight[j+1]+nums[j];
            }
            //printList(sumRight);
            for(int k=0;k<nums.length;k++){
                if(sumLeft[k]==sumRight[k+1]){
                    return k;
                }
            }
            return -1;
        }
        public void printList(int[] list){
            for(int i=0;i<list.length;i++){
                System.out.print(list[i]+",");
            }
            System.out.println("end");
        }
    }
}