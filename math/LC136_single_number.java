/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC136_single_number
 * Date Created : 2024-04-02
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-02       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-02
 **/
public class LC136_single_number {
    class Solution {
        public int singleNumber(int[] nums) {
            //长度可以是1
            if(nums==null /*|| nums.length==1*/){
                return -30001;
            }
            int result = nums[0];
            for(int i=1;i<nums.length;i++){
                result = result ^ nums[i];
            }
            return result;
        }
    }
}