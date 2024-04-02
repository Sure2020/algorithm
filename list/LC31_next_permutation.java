/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC31_next_permutation
 * Date Created : 2024-04-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-03       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-03
 **/
public class LC31_next_permutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            // int size = nums.length;
            // if(size==1){
            //     return;
            // }
            // //int last = nums[size-1];
            // for(int i=size-1;i>0;i--){
            //     if(nums[i-1]<nums[i]){
            //         int temp = nums[i-1];
            //         nums[i-1]=nums[i];
            //         nums[i]=temp;
            //         // nums[size-1]=nums[i];
            //         // nums[i]=last;
            //         System.out.println(i+"###"+(size-1));
            //         Arrays.sort(nums, i-1+1, size);
            //         return;
            //     }
            // }
            // Arrays.sort(nums);
            //下面这思路算是认输了，比如[4,2,0,2,3,2,0]，期望输出[4,2,0,3,0,2,2]，实际输出[4,2,2,0,0,2,3]
            //所以思路还得是从右往左寻找第一处降序的组合
            // int size = nums.length;
            // if(size==1){
            //     return;
            // }
            // for(int i=size-1;i>0;i--){
            //     for(int j=i;j>=0;j--){
            //         if(nums[j]<nums[i]){
            //             System.out.println(j+"###"+i);
            //             swap(nums, i, j);
            //             Arrays.sort(nums, j+1, size);
            //             return;
            //         }
            //     }
            // }
            // Arrays.sort(nums);
            // 单纯地找从右往左寻找第一处降序的组合，还不够。。。例[1,3,2]，期望[2,1,3]，实际[3,1,2]
            // int size = nums.length;
            // if(size==1){
            //     return;
            // }
            // for(int i=size-1;i>0;i--){
            //     if(nums[i-1]<nums[i]){
            //         swap(nums, i-1, i);
            //         Arrays.sort(nums, i, size);
            //         return;
            //     }
            // }
            // Arrays.sort(nums);
            //https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
            //剽窃上面链接的这个题解。其中“这时 [j,end) 必然是降序”着实让人想不到。总之，这不是正常的人脑能想到的思路，只能记一下了
            int size = nums.length;
            if(size==1){
                return;
            }
            for(int i=size-1;i>0;i--){
                if(nums[i-1]<nums[i]){
                    for(int j=size-1;j>=i;j--){
                        if(nums[j]>nums[i-1]){
                            swap(nums, i-1, j);
                            //Arrays.sort(nums, i, size);
                            reverse(nums, i, size-1);
                            return;
                        }
                    }
                }
            }
            //Arrays.sort(nums);
            reverse(nums, 0, size-1);
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void reverse(int[] nums, int i, int j){
            while(i<j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }
}