/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR128_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof
 * Date Created : 2024-01-16
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-16       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-16
 **/
public class LCR128_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof {
    public int stockManagement(int[] stock) {
        int left =0,right = stock.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(stock[mid]<stock[right]){
                right=mid;
            }else if (stock[mid]>stock[right]){
                left=mid+1;
            }else{
                right --;
            }
        }
        return stock[left];

    }
}