/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC3_longest_substring_without_repeating_characters
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

import java.util.HashSet;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-08
 **/
public class LC3_longest_substring_without_repeating_characters {
    class SolutionSelf {
        public int lengthOfLongestSubstring(String s) {
            //还不错，地铁上理清思路后短时间写出来了，只调试了2次，总共20分钟吧。虽然性能不咋滴但值得鼓励
            //看了labuladong的思路，才意识到自己的思路其实就是暴力求解，时间复杂度o(n*n)，没啥值得骄傲的。。。尴尬了
            Set<Character> set = new HashSet<>();
            int maxLength = 0;
            int currentLength = 0;
            int slow = 0,fast = 0;
            while(fast<s.length()){
                char c = s.charAt(fast);
                //System.out.println(s.charAt(slow)+"##"+s.charAt(fast));
                if(!set.contains(c)){
                    currentLength++;
                    maxLength = Math.max(maxLength, currentLength);
                    set.add(c);
                    fast++;
                }else{
                    slow++;
                    fast=slow;
                    currentLength=0;
                    set.clear();
                    // continue;
                }

            }
            return maxLength;
        }
    }
    //还行，算是自己独立调出来的
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // Map<Character, Integer> window = new HashMap<>();
            Set<Character> set = new HashSet<>();
            int left=0,right=0;
            int maxLength = 0;
            while(right<s.length()){
                char c = s.charAt(right);
                if(set.contains(c)){
                    //窗口右边发现重复字符，只动窗口左边即可，因为有可能动了左边，就不重复了
                    //right++;
                    char d = s.charAt(left);
                    left++;
                    set.remove(d);
                }else{
                    maxLength = Math.max(maxLength, right-left+1);
                    set.add(c);
                    right++;
                }
            }
            return maxLength;
        }
    }
}