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

    //还行，时隔一个月，短时间写出来了，调试了一小会儿。虽然和labuladong细节不太一样，（没用map）,但我这个思路比他快1ms！
    class Solution20240514 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left=0,right=0,len=Integer.MIN_VALUE;
            int l = s.length();
            // 注意1，也不算是坑，只需多加个判断
            if(l==0){
                return 0;
            }
            while(right<l){
                char c = s.charAt(right);
                if(!set.contains(c)){
                    set.add(c);
                    // 注意3，这里+1修正一下，写个例子就能明白
                    if(right-left+1 > len){
                        len = right-left+1;
                    }
                    right ++;
                }else {
                    //注意2，收缩窗口时，缩的是左边，所以要从左边开始删
                    char d = s.charAt(left);
                    //set.remove(c);
                    set.remove(d);
                    left ++;
                }
            }
            return len;
        }
    }

    class Solution202405142113 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left=0,right=0,len = 0;
            int l = s.length();
            if(l==0){
                return 0;
            }
            while(right<l){
                char c = s.charAt(right);
                if(!set.contains(c)){
                    set.add(c);
                    // 注意1，忘了right++;
                    //right ++;
                    if(right - left + 1 > len){
                        len = right - left +1;
                    }
                    // 注意2，用完right再++，写得太心急了，稳住
                    right ++;
                }else{
                    char d = s.charAt(left);
                    set.remove(d);
                    left ++;
                }
            }
            return len;
        }
    }

    class Solution20240515 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left=0,right=0,len=0;
            while(right<s.length()){
                char c  = s.charAt(right);
                if(!set.contains(c)){
                    set.add(c);
                    if(right-left+1>len){
                        len = right-left+1;
                    }
                    right++;
                }else{
                    char d = s.charAt(left);
                    set.remove(d);
                    left ++;
                }
            }
            return len;
        }
    }
}