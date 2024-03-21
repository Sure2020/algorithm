/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC151_reverse_words_in_a_string
 * Date Created : 2024-03-21
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-21       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-21
 **/
public class LC151_reverse_words_in_a_string {
    //这题可以让我吹一波了，自己独立写出来的，而且调试的次数也不多，思路也清晰，写着写着自然而然想到了递归，我真厉害啊
    class Solution {
        StringBuilder resultStringBuilder = new StringBuilder();
        public String reverseWords(String s) {
            // for(int i=0;i<result.size();i++){
            //     String currentString = result.get(i);
            // }
            recurse(s,0);
            //需注意substring的右区间是开区间
            return resultStringBuilder.substring(0, resultStringBuilder.length()-1);
        }
        public void recurse(String s, int index){
            //去掉前导空格
            int i=index;
            int n = s.length();
            while (i<n && s.charAt(i)==' ') {
                i++;
            }
            if(i==n){
                return ;
            }
            StringBuilder sb = new StringBuilder();
            // while(i<n &&
            // (s.charAt(i)>='A' || s.charAt(i)<='Z') &&
            // (s.charAt(i)>='a'||s.charAt(i)<='z') &&
            // (s.charAt(i)>='1'||s.charAt(i)<='9')){
            //     sb.append(s.charAt(i));
            //     i++;
            // }
            while (i<n&&s.charAt(i)!=' ') {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(' ');

            // if(i==n){
            //     result.add(sb.toString());
            //     return sb.toString();
            // }
            // resultStringBuilder.add(sb.toString());
            // sb.delete(0, sb.length()-1);
            // sb.setLength(0);

            recurse(s, i);
            //System.out.println(sb.toString() + "###");
            resultStringBuilder.append(sb.toString());

            //去掉后导空格
            // while (i<n && s.charAt(i)==' ') {
            //     i++;
            // }
        }
    }

    //基于上面的解法，只是把杂乱的调试痕迹去掉
    class SolutionClean {
        StringBuilder resultStringBuilder = new StringBuilder();
        public String reverseWords(String s) {
            recurse(s,0);
            //需注意substring的右区间是开区间
            return resultStringBuilder.substring(0, resultStringBuilder.length()-1);
        }
        public void recurse(String s, int index){
            //去掉前导空格
            int i=index;
            int n = s.length();
            while (i<n && s.charAt(i)==' ') {
                i++;
            }
            if(i==n){
                return ;
            }
            StringBuilder sb = new StringBuilder();
            while (i<n&&s.charAt(i)!=' ') {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(' ');

            recurse(s, i);
            resultStringBuilder.append(sb.toString());
        }
    }
}