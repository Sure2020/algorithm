/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC66_plus_one
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
public class LC66_plus_one {
    public int[] plusOne(int[] digits) {
        // int length = digits.length;
        // int last= digits[length-1];
        // if(last == 9){
        //     if(length==1){
        //         int[] result = new int[2];
        //         result[0]=1;
        //         result[1] = 0;
        //         return result;
        //     }
        //     else{
        //         digits[length-1]=0;
        //         digits[length-2]=digits[length-2]+1;

        //     }
        // }else{
        //     digits[length-1]=digits[length-1]+1;

        // }
        // return digits;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i] +=1;
                return digits;
            }
        }
        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }
}