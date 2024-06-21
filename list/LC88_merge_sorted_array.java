/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC88_merge_sorted_array
 * Date Created : 2024-01-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题第二次做还是没想起来思路，记住这个从后往前填充的思路吧！
 * 好在看了思路，自己一遍过了
 * @author: Admin
 * @create: 2024-01-11
 **/
public class LC88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1,index2 = n-1,index3=m+n-1;
        // while(index3>=0){
        //     if(index1<0){
        //         nums1[index3]=nums2[index2];
        //         index2--;
        //     }else if(index2<0){
        //         break;
        //     }else if(nums1[index1]>=nums2[index2]){
        //         nums1[index3]=nums1[index1];
        //         index1--;
        //     }else {
        //         nums1[index3]=nums2[index2];
        //         index2--;
        //     }
        //     index3--;
        // }
        while(index1>=0&&index2>=0){
            if(nums1[index1]>=nums2[index2]){
                nums1[index3]=nums1[index1];
                index1--;
            }else{
                nums1[index3]=nums2[index2];
                index2--;
            }
            index3--;
        }
        while(index2>=0){
            nums1[index3]=nums2[index2];
            index2--;
            index3--;
        }
    }

    class Solution20240301 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1=m-1,index2=n-1,p=m+n-1;
            while(p>=0&&index1>=0&&index2>=0){
                if(nums1[index1]>=nums2[index2]){
                    nums1[p]=nums1[index1];
                    index1--;
                }else{
                    nums1[p]=nums2[index2];
                    index2--;

                }
                p--;
            }
            while(index2>=0){
                nums1[p]=nums2[index2];
                index2--;
                p--;
            }
        }
    }

    class Solution20240618 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1=m-1,p2=n-1,p3=m+n-1;
            int n1=0,n2=0;
            while(p1>=0&&p2>=0){
                n1 = nums1[p1];
                n2 = nums2[p2];
                if(n1>=n2){
                    nums1[p3]=n1;
                    p1--;
                }else{
                    nums1[p3]=n2;
                    p2--;
                }
                p3--;
            }
            while(p1>=0){
                nums1[p3]=nums1[p1];
                p1--;
                p3--;
            }
            while(p2>=0){
                nums1[p3]=nums2[p2];
                p2--;
                p3--;
            }
            // return nums1;
        }
    }
//双指针没跑了,nums1从尾部插入

    class Solution20240621 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1=m-1,p2=n-1,p3=nums1.length-1;
            while(p1>=0 && p2>=0){
                if(nums1[p1]<=nums2[p2]){
                    nums1[p3] = nums2[p2];
                    p2--;
                }else{
                    nums1[p3] = nums1[p1];
                    p1--;
                }
                p3--;
            }
            //优化：因为p1指针本身就在nums1上，所以只考虑nums2即可
            // while(p1>=0){
            //     nums1[p3]=nums1[p1];
            //     p1--;
            //     p3--;
            // }
            while(p2>=0){
                nums1[p3]=nums2[p2];
                p2--;
                p3--;
            }
        }
    }
//双指针，nums1从尾部写入
}