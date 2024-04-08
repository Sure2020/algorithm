/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC438_find_all_anagrams_in_a_string
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-08
 **/
public class LC438_find_all_anagrams_in_a_string {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> target = new HashMap<>();
            int left=0,right=0;
            int start = left;
            int count = 0;
            for(int i=0;i<p.length();i++){
                char c = p.charAt(i);
                target.put(c, target.getOrDefault(c, 0) + 1);
            }
            while(right<s.length()){
                char c = s.charAt(right);
                if(target.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(target.get(c).equals(window.get(c))){
                        count ++;
                    }
                }
                right ++;
                while(count == target.size()){
                    if(right-left==p.length()){
                        result.add(left);
                        //break;
                    }
                    char d = s.charAt(left);
                    //由于上一题自己体会到了窗口扩大和收缩时的一些操作是对称的，于是下面直接复制了扩大时的逻辑，
                    //但好几处变量忘了改（比如由c改为d）,给自己埋了坑！调试了好几次！浪费了宝贵的时间！后来改掉了，立马通过！真是聪明反被聪明误啊！
                    if(target.containsKey(d)){
                        if(target.get(d).equals(window.get(d))){
                            count --;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                    left ++;
                }
            }
            return result;
        }
    }
}