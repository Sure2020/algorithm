/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR179_he_wei_sde_liang_ge_shu_zi_lcof
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
public class LCR179_he_wei_sde_liang_ge_shu_zi_lcof {
    public int[] twoSum(int[] price, int target) {
        int left = 0,right = price.length-1;
        while(left<right){
            int tempSum = price[left]+price[right];
            if(tempSum<target){
                left++;
            }else if(tempSum>target){
                right--;
            }else if(tempSum==target){
                break;
            }
        }
        return new int[]{price[left],price[right]};
    }
}