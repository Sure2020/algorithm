/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC128_longest_consecutive_sequence
 * Date Created : 2024-02-29
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-29       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这个也有一定的技巧性，记一下
 * @author: Admin
 * @create: 2024-02-29
 **/
public class LC128_longest_consecutive_sequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for(int num:nums){
                set.add(num);
            }
            int res=0;
            for(int num:set){
                //当前数字不是连续序列开头的数字，直接跳过
                if(set.contains(num-1)){
                    continue;
                }
                //找到连续序列开头的数字，开始找下一个数字
                int currentLen=1;
                int nextNum=num+1;
                while(set.contains(nextNum)){
                    currentLen++;
                    nextNum++;
                }
                //找不到下一个了，就更新一下最长连续序列的长度，然后开启新一轮的循环
                res = Math.max(res,currentLen);
            }
            return res;
        }
    }
}