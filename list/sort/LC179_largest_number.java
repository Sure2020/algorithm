/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC179_largest_number
 * Date Created : 2024-03-31
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-31       Admin     xxx
 * --------------------------------------------------------------------
 */

package sort;

import java.util.Arrays;

/**
 * @program: sort
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-31
 **/
public class LC179_largest_number {
    //剽窃的思路，看情况再练一次吧。
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] numsToString = new String[n];
            for(int i=0;i<n;i++){
                numsToString[i]=String.valueOf(nums[i]);
            }
            Arrays.sort(numsToString, (a, b)->{
                //这里写成(a+b).compareTo(b+a);就不行，暂时没深入研究
                return (b+a).compareTo(a+b);
            });
            if(numsToString[0]=="0"){
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(numsToString[i]);
            }
            return sb.toString();
        }
    }
}