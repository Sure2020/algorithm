/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC162_find_peak_element
 * Date Created : 2024-02-20
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-20       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-20
 **/
public class LC162_find_peak_element {
    //自己独立实现的慢方法，时间复杂度o(n)
    class SolutionSelf {
        public int findPeakElement(int[] nums) {
            if(nums.length==1){
                return 0;
            }
            int slow = 0,fast=1;
            int length = nums.length-1;
            while(fast<=nums.length-1){
                if(nums[fast]>nums[slow]){
                    fast++;
                    if(fast<=nums.length-1 && nums[fast]<nums[fast-1]){
                        return fast-1;
                    }
                }else{
                    slow++;
                    fast = slow +1;
                }

            }
            if(nums[length]>nums[length-1]){
                return length;
            }
            return 0;
        }
    }
    class Solution {
        //我看了这位仁兄的解释才顿悟的：
    /*
    1、二分的边界，l = 0, r = nums.size() - 1。
2、如果nums[mid] > nums[mid + 1]，那么在[l, mid]这个区间内一定存在一个峰值。因为[l,mid]这一段如果是单调递减的话，那么nums[l]就是峰值，否则第一个出现上升的点就是峰值。
3、如果nums[mid] < nums[mid + 1]，那么在[mid+1, r]这个区间内一定存在一个峰值。因为[mid+1,r]这一段如果是单调递增的话，那么nums[r]就是峰值，否则第一个出现下降的点就是峰值。

作者：林小鹿
链接：https://leetcode.cn/problems/find-peak-element/solutions/916742/er-fen-cha-zhao-zui-jian-jie-yi-dong-de-cvn1f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
        //其实不用太纠结于每次while的细节，只要理解大方向就是每次都锁定必定有峰值的区间，继续找，即可


        public int findPeakElement(int[] nums) {
            int left=0,right=nums.length-1,mid=0;
            while(left<right){
                mid = left+(right-left)/2;
                //因为左边界是负无穷，所以此时[left,mid]之间肯定有峰值
                if(nums[mid]>nums[mid+1]){
                    right=mid;
                }
                //因为右边界是负无穷，所以此时[mid+1,right]之间肯定有峰值
                else if(nums[mid]<nums[mid+1]){
                    left =mid+1;
                }
            }
            return left;
        }
    }
}