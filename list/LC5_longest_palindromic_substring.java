/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC5_longest_palindromic_substring
 * Date Created : 2023-10-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-24       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-24
 **/
public class LC5_longest_palindromic_substring {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("babad", 0, 2));

        System.out.println("case1,out=bab  or aba");
        String s1 = "babad";
        System.out.println("cast1 result:");
        System.out.println(longestPalindrome(s1));

        System.out.println("case2,out=bb");
        String s2 = "cbbd";
        System.out.println("cast2 result:");
        System.out.println(longestPalindrome(s2));

        System.out.println("case3,out=a");
        String s3 = "a";
        System.out.println("cast3 result:");
        System.out.println(longestPalindrome(s3));
    }

    public static String longestPalindrome(String s) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) == s.charAt(right)) {
                    String tempSubString = isPalindrome(s, left, right);
                    result = result.length() >= tempSubString.length() ? result : tempSubString;
                }
                right--;
            }
        }
        return result;
    }

    public static String isPalindrome(String s, int left, int right) {
        if (right-left<=1){
            return s.substring(left, right + 1);
        }
        int tempLeft = left + 1;
        int tempRight = right - 1;
        while (tempLeft < tempRight) {
            if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                return "";
            }
            tempLeft++;
            tempRight--;
        }
        return s.substring(left, right + 1);
    }

    class Solution20240617 {
        public String longestPalindrome(String s) {
            String res = "";
            for(int i=0;i<s.length();i++){
                String s1 = palindrome(s,i,i);
                String s2 = palindrome(s,i,i+1);
                res = res.length()>s1.length()?res:s1;
                res = res.length()>s2.length()?res:s2;
            }
            return res;
        }
        public String palindrome(String s, int l, int r){
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            return s.substring(l+1,r);
        }
    }
//没思路，直接看labuladong
//只要记住一点，从中间向两边扩散，后面的思路就很自然了

    class Solution20240619 {
        public String longestPalindrome(String s) {
            int left = 0,right=0;
            String result = "";
            for(int i=0;i<s.length();i++){
                String temp1 = find(s,i,i);
                String temp2 = find(s,i,i+1);
                if(temp1.length()>result.length()){
                    result = temp1;
                }
                if(temp2.length()>result.length()){
                    result = temp2;
                }
            }
            return result;
        }
        private String find(String s, int l, int r){
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r) ){
                l--;
                r++;
            }
            return s.substring(l+1,r);
        }
    }
//这个刚做不久，印象挺深，双指针，关键是从中间向两边查找
}