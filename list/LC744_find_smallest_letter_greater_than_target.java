/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC744_find_smallest_letter_greater_than_target
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

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-15
 **/
public class LC744_find_smallest_letter_greater_than_target {
    public char nextGreatestLetter(char[] letters, char target) {
        // for(int i = 0;i<letters.length;i++){
        //     if(letters[i]>target){
        //         return letters[i];
        //     }
        // }
        // return letters[0];
        if(letters[letters.length-1]<=target){
            return letters[0];
        }
        int left = 0,right=letters.length-1,mid = 0;
        while(left<right){
            mid = left+(right-left)/2;
            if(letters[mid]<target){
                left = mid+1;
            }else if(letters[mid]==target){
                left=mid+1;
            }else if(letters[mid]>target){
                right=mid;
            }
        }
        return letters[right];
    }
}