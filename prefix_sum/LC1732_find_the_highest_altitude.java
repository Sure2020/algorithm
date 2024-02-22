/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1732_find_the_highest_altitude
 * Date Created : 2024-02-22
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-22       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 前缀和的第二题，独立、一次性通过！
 * @author: Admin
 * @create: 2024-02-22
 **/
public class LC1732_find_the_highest_altitude {
    class Solution {
        public int largestAltitude(int[] gain) {
            int maxHeigth=0;
            int[] preSum = new int[gain.length+1];
            for(int i=1;i<preSum.length;i++){
                preSum[i] = preSum[i-1]+gain[i-1];
                maxHeigth=Math.max(maxHeigth,preSum[i]);
            }
            return maxHeigth;
        }
    }
}