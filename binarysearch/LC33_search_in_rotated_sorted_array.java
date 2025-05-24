/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC33_search_in_rotated_sorted_array
 * Date Created : 2024-03-29
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-29       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-29
 **/
public class LC33_search_in_rotated_sorted_array {
    class Solution {
        public int search(int[] nums, int target) {
            if(nums==null){
                return -1;
            }
            int left=0,right=nums.length-1;
            int mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                //mid在左边有序的部分
                else if(nums[mid]>=nums[left]){
                    //判断target是否在这个区间，不在就别搜索了，能节省时间。一开始只写了个if nums[mid]>target的条件
                    if(nums[mid]>target && nums[left]<=target){
                        right=mid-1;
                    }
                    //否则就去断崖的另一边去找了
                    else{
                        left=mid+1;
                    }
                }
                //mid在右边，就把区间锁定到右边一部分有序的区间
                else if(nums[mid]<nums[left]){
                    left=mid+1;
                }
            }
            return -1;
        }
    }

    //需要记住的一点是，可以通过判断mid和left对应的值的大小，判断target在断崖的哪边，然后思路就可以打开了
//还有两处细节要注意，详见两处注意
    class Solution20240611 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                //我真是服了，又忘了计算mid
                mid = (right-left)/2+left;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>=nums[left]){
                    //注意1，mid==left的条件放在这个case中，因为情况都是mid在断崖左边
                    //System.out.println(nums[mid] + " #### " + nums[left] + "####" + nums[right]);
                    //mid在断崖左边，left---mid之间肯定有序，
                    //如果target在left和mid之间，则按常规二分搜索，收缩右边界，否则收缩左边界
                    // if(target == nums[left]){
                    //     return left;
                    // }
                    //注意2
                    if(target>=nums[left] && target<nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else if(nums[mid]<nums[left]){
                    //System.out.println(nums[mid] + " # " + nums[left] + "#" + nums[right]);
                    //mid在断崖右边，mid---right之间肯定有序，
                    //如果target在mid和right之间，则按常规二分搜索，收缩左边界，否则收缩右边界
                    // if(target==nums[right]){
                    //     return right;
                    // }
                    //注意2，要考虑target==边界的情况
                    if(target>nums[mid] && target<=nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }

            }
            return -1;
        }
    }

    class Solution20240612 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=-1;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                // 太遗憾了。下面的文字明明分析清楚了，但这里写反了，还调试了好久
                // if(nums[left]>=nums[mid]){
                if(nums[mid]>=nums[left]){
                    if(nums[left]<=target && target<nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid + 1;
                    }
                }else if (nums[mid]<nums[left]){
                    if(nums[mid]<target && target<=nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }
//关键思路是通过比较mid和Left,确定mid在断崖的哪边
//mid大于left，mid在断崖左边，left---mid递增
//mid等于left，仍然可以认为left---mid递增
    //left<target<mid，大胆地收缩右边界，否则，收缩左边界，交由下次循环，再次判断mid与left的关系去处理
    //否则收缩左边界
//mid小于left，mid在断崖右边，mid---right递增
    //mid<target<right,收缩左边界
    //否则收缩右边界

    class Solution20240620 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=-1;
            while(left<=right){
                mid = left + (right-left)/2;
                //System.out.println("mid:  " + mid);
                if(nums[mid] == target){
                    return mid;
                }
                //这里mid>left和mid==left是归为一类的，想象一下断崖的图即可
                //哎太蠢了，这里将nums[left]写成了left，都怪在分析是偷懒也是这么写的
                if(nums[mid]>=nums[left]){
                    if(nums[left]<=target && target <= nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else if(nums[mid]<nums[left]){
                    //System.out.println("branch 2");
                    if(nums[mid]<=target && target<= nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }
//这种讲究技巧的题，是我所不齿的。。。
//先根据mid和left比较，判断断崖在哪边，
//mid>left,断崖在mid右边，left->mid递增，在此区间按二分查找。。。另一边丢给下一次循环
//mid<left,断崖在mid左边，mid->right递增，在此区间按二分查找。。。另一边丢给下一次循环

    class Solution20240726 {
        public int search(int[] nums, int target) {
            if(nums.length==1 &&target==nums[0]){
                return 0;
            }
            int left=0,right=nums.length-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                //System.out.println("left: " +left + " right: " + right + " mid: " + mid);
                if(nums[mid]==target){
                    return mid;
                }
                //断崖在mid右边，left-mid是单调递增
                else if(nums[mid]>=nums[left]){
                    //target在单调增区间，二分查找
                    if(nums[left]<=target && target<nums[mid]){
                        right = mid-1;
                    }

                    // else if(nums[left]==target){
                    //     return left;
                    // }
                    //target在有断层的那一部分，交给下次循环去处理
                    else/* if (nums[left]> target)*/{
                        left = mid+1;
                    }
                }
                //断崖在mid左边，mid-right是单调递增
                else if(nums[mid]<nums[left]){
                    //target在单调增区间，二分查找
                    if(nums[mid]<target && target<=nums[right]){
                        left=mid+1;
                    }
                    // else if(nums[mid]==target){
                    //     return mid;
                    // }
                    else/* if(nums[mid]>target)*/{
                        right = mid-1;
                    }
                }
                // else if(nums[mid]==nums[left]){
                //     left=mid+1;
                // }

            }
            return -1;
        }
    }
//搜索旋转数组。用mid与left比较，先确定断崖在哪边。
//如果找峰值，就要mid与mid+1做比较，找出趋势
//事后：主要是当判断target是否在left--mid或mid--right之间时，要严谨判断：nums[left]<=target<=nums[mid],nums[mid]<=target<=nums[right]
    class Solution20250517 {
        public int search(int[] nums, int target) {
            if(nums.length==0){
                return -1;
            }
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>=nums[left]){
                    if(nums[left]<=target && target<=nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else {
                    if(nums[mid]<=target && target<=nums[right]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
            return -1;
        }
    }

    class Solution20250524 {
        public int search(int[] nums, int target) {
            // right 忘了-1
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                //mid在断崖左边，left-mid递增
                if(nums[mid]>=nums[left]){
                    if(nums[left]<=target && target <=nums[mid]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }else{
                    if(nums[mid]<=target && target <=nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}