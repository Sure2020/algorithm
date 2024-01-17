/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR173_que_shi_de_shu_zi_lcof
 * Date Created : 2024-01-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-17       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-17
 **/
public class LCR173_que_shi_de_shu_zi_lcof {
    public int takeAttendance(int[] records) {
        if(records.length==1){
            if(records[0]==0){
                return 1;
            }else if(records[0]==1){
                return 0;
            }
        }
        int left = 0, right = records.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else if (records[mid] > mid) {
                right = mid;
            }
        }
        // if (left>=records.length){
        //     return records[left]+1;
        // }
        if(left-1<0){
            return 0;
        }
        return records[left-1]+1;

    }
    //left <=right
    public int takeAttendance2(int[] records) {
        int left = 0,right=records.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(records[mid]==mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    // left < right;
    public int takeAttendance3(int[] records) {
        int left = 0, right = records.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else if (records[mid] > mid) {
                right = mid;
            }
        }
        return left;
    }
}