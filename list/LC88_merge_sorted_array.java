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
}