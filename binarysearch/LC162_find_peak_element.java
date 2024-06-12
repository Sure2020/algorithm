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
    class Solution20240329 {
        public int findPeakElement(int[] nums) {
            // if(nums==null || nums.length<3){
            //     return -1;
            // }
            // int left =0,right=nums.length-1;
            // int mid=0;
            // while(left<=right){
            //     mid = left+(right-left)/2;
            //     if(mid==0||mid==nums.length-1){
            //         return -1;
            //     }
            //     else if(nums[mid]>nums[mid-1]){
            //         if(nums[mid]<nums[mid+1]){
            //             return mid;
            //         }else{
            //             left=mid;
            //         }

            //     }else if(nums[mid]<nums[mid-1]){
            //         right=mid-1;
            //     }
            // }
            // return -1;
            //唉思路真的厉害，不能抠细节（反例在上面），要有大局观，具体看第二次的提交
            int left=0,right=nums.length-1;
            int mid=0;
            while(left<right){
                mid = left+(right-left)/2;
                if(nums[mid]>nums[mid+1]){
                    right=mid;
                }else{
                    left=mid+1;
                }

            }
            //return left;
            //因为结束条件是left=right，所以返回谁都行
            return right;
        }
    }

    //我自己想的思路是：二分查找，判断mid大于Left大于right，则...
//mid大于Left，小于right，则mid---right之间肯定有峰值，收缩左区间
//mid小于left，大于right，则left---mid之间。。。。
//mid小于left，小于right，则收缩哪边都可以
// class Solution {
//     public int findPeakElement(int[] nums) {
//         int left = 0,right=nums.length-1;mid=-1;
//         while(left<=right){
//             mid=left+(right-left)/2;
//             if(nums[mid]>nums[left]){
//                 if(nums[mid]>nums[right]){
//                     return mid;
//                 }
//             }else if(nums[mid] == nums[left]){

//             }else if(nums[mid] < nums[left]){

    //             }
//         }
//     }
// }
//判断mid和left，right的大小关系太复杂，上面就是反例，关键思路是换个角度，判断mid和mid+1的大小关系
//mid大于mid+1,峰值肯定在mid左边或者就是mid，收缩右边界
//mid等于mid+1,不用考虑，因为题目说了没有重复元素
//mid小于mid+1,峰值肯定在mid右边，收缩左边界
    class Solution20240612 {
        public int findPeakElement(int[] nums) {
            // if(nums.length==1){
            //     return 0;
            // }
            int left = 0,right=nums.length-1,mid=-1;
            while(left<=right){
                mid = left+(right-left)/2;
                if(mid+1>nums.length-1){
                    break;
                }
                if(nums[mid]>nums[mid+1]){
                    right = mid-1;
                }else if(nums[mid]<nums[mid+1]){
                    left = mid+1;
                }
            }
            return left;
        }
    }
}