/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC_plus_1064_fixed_point
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
public class LC_plus_1064_fixed_point {
    public int fixedPoint(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]-i>0){
                return -1;
            } else if(arr[i]==i){
                return i;
            }else if(arr[i]-i<0){
                continue;
            }
        }
        return -1;
    }
}