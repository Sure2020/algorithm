/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC14_longest_common_prefix
 * Date Created : 2024-03-22
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-22       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-22
 **/
public class LC14_longest_common_prefix {
    //这题做的还行奥，其实可以用第一个元素为基准，循环遍历剩下的元素，再循环比对每个字符位。但奈何按捺不住自己躁动的小脑筋，写着写着就发现可以递归，于是用递归写了，时间复杂度仍然是O(mn),m是第一个元素长度，n是元素个数
    class Solution {
        String result = "";
        public String longestCommonPrefix(String[] strs) {
            if(strs==null || strs.length==0){
                return "";
            }
            if(strs.length==1){
                return String.valueOf(strs[0]);
            }
            result=findMaxPre(strs[0], strs[1]);
            maxPre(strs, 2);
            return result;
        }
        public void maxPre(String[] strs, int start){
            //System.out.println("maxPre: " + start);
            if(start>=strs.length){
                return;
            }
            result = findMaxPre(result, strs[start]);
            //一开始忘了下面这个，让它进去递归，总以为上面这个函数是递归，其实只是一个普通的功能函数，是自己为了简洁给写成了一个函数，没想到给自己挖了坑。
            maxPre(strs, start+1);
        }
        public String findMaxPre(String s1, String s2){
            //System.out.println(s1+"#findMaxPre##"+s2);
            int i=0, j=0;
            StringBuilder sb = new StringBuilder();
            while(i<s1.length()&&j<s2.length()){
                char c1=s1.charAt(i);
                char c2=s2.charAt(j);
                if(c1==c2){
                    sb.append(c1);
                }else{
                    break;
                }
                i++;
                j++;
            }
            //System.out.println("findMaxPre result: " + sb.toString());
            return sb.toString();
        }
    }
}