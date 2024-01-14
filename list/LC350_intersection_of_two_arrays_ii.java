/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC350_intersection_of_two_arrays_ii
 * Date Created : 2024-01-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-15       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: the first time commited one time and passed!
 * @author: Admin
 * @create: 2024-01-15
 **/
public class LC350_intersection_of_two_arrays_ii {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null){
            return null;
        }
        if(nums1.length==0||nums2.length==0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0,index2=0, index3=0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums3 = new int[length1+length2];
        while(index1<length1&&index2<length2){
            if(nums1[index1] == nums2[index2]){
                nums3[index3] = nums1[index1];
                index1++;
                index2++;
                index3++;
            } else if(nums1[index1]>nums2[index2]){
                index2++;
            } else if(nums1[index1]<nums2[index2]){
                index1++;
            }
        }
        return Arrays.copyOfRange(nums3,0,index3);
    }
}