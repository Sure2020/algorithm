/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC567_permutation_in_string
 * Date Created : 2024-04-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-08       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-08
 **/
public class LC567_permutation_in_string {
    //还行，较短时间独立写出来了，且只调试了个位数次（当然我承认是通过单步调试去调的）
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> target = new HashMap<>();
            //错把s1写成了s2
            for(int i=0;i<s1.length();i++){
                char c = s1.charAt(i);
                target.put(c, target.getOrDefault(c, 0) + 1);
            }
            int left=0,right=0;
            int count = 0;
            while(right<s2.length()){
                char c = s2.charAt(right);
                if(target.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) +1);
                    if(window.get(c).equals(target.get(c))){
                        count ++;
                    }
                }

                right ++;
                while(count == target.size()){
                    //这里错写成了right-left与target.size进行比较
                    if((right-left)==s1.length()){
                        return true;
                    }
                    char d = s2.charAt(left);
                    if(target.containsKey(d)){

                        if(window.get(d).equals(target.get(d))){
                            count --;
                        }
                        window.put(d, window.get(d) -1);
                    }
                    //把++写成--我也是服了你了，写双指针写出惯性思维来了吧
                    left ++;
                }

            }
            return false;
        }
    }
}