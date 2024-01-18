/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR_172_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof
 * Date Created : 2024-01-18
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-18       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-18
 **/
public class LCR_172_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8};
        //System.out.println(countTarget(nums,4));
    }
    public int countTarget(int[] scores, int target) {
        // int left=0,right=scores.length-1,count = 0;
        // int mid = -1;
        // while(left<=right){
        //     mid = left+(right-left)/2;
        //     if(scores[mid]>target){
        //         right = mid-1;
        //     }else if(scores[mid]<target){
        //         left = mid+1;
        //     }else if (scores[mid]==target){
        //         count++;
        //         break;
        //     }
        // }
        // if(mid!=0){
        //     left=mid-1;
        //     while(left>=0&&scores[left]==target){
        //         left--;
        //         count++;
        //     }
        // }
        // if(mid!=scores.length-1){
        //     right=mid+1;
        //     while (right<=scores.length-1&&scores[right]==target){
        //         right++;
        //         count++;
        //     }
        // }

        // return count;
        int left = left_bound(scores,target);
        if(left==-1){
            return 0;
        }
        return right_bound(scores,target)-left_bound(scores,target)+1;
    }
    public int left_bound(int[] nums, int target){
        int left =0,right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                right = mid-1;
            }
        }
        if(left>=nums.length||nums[left]!=target){
            return -1;
        }
        return left;
    }
    public int right_bound(int[] nums, int target){
        int left =0,right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                left = mid+1;
            }
        }
        if(right<0||nums[right]!=target){
            return -1;
        }
        return right;
    }
}