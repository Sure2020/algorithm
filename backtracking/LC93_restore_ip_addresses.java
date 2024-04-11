/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC93_restore_ip_addresses
 * Date Created : 2024-04-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-11       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 调试了好久，主要原因是回溯的结束条件遗漏了count==4，且这里忘了count--
 * @author: Admin
 * @create: 2024-04-11
 **/
public class LC93_restore_ip_addresses {
    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }
    //想了想，难点是怎么分割成4部分
//看了labuladong思路，先分出1部分，再回溯后面的部分分成3部分，搞个变量记录part数量~
    static class Solution {
        List<String> res = new ArrayList<>();
        LinkedList<String> track = new LinkedList<>();
        int count = 0;
        public List<String> restoreIpAddresses(String s) {
            backtrack(s,0);
            return res;
        }
        public void backtrack(String s, int start){
            if(start == s.length() && count==4){
                //linkedlist转为string时可以利用join
                res.add(String.join(".", track));
                //res.add(track.toString());
                return;
            }
            if(count>=4 && start <=s.length()){
                return;
            }
            for(int i = start;i < s.length(); i++){
                if(!isValidIPPart(s,start,i)){
                    continue;
                }
                //这里糊里糊涂用了addFirst方法，要知道这是头插，但需要的是尾插啊大兄弟
                //track.addFirst(s.substring(start, i+1)+".");
                //每次拼接“.”的方式，最后还要想办法去掉最后一个“.”，不如用String.join(".",linkedlist)方便
                //track.addLast(s.substring(start, i+1)+".");
                track.addLast(s.substring(start, i+1));
                count ++;
                backtrack(s,i+1);
                track.removeLast();
                //这里忘了count--，唉防不胜防，调试了好久，主要原因是回溯的结束条件遗漏了count==4，且这里忘了count--
                count--;
            }
        }
        public boolean isValidIPPart(String s, int start, int end){
            //补充有前缀零的情况
            if(s.charAt(start)=='0' && start != end){
                return false;
            }
            int n = stringToInt(s,start,end);
            if(n>=0 && n<=255){
                return true;
            }
            return false;
        }
        public int stringToInt (String s, int start, int end){
            int res = 0;
            for(int i=start;i<=end;i++){
                char c = s.charAt(i);
                int n = c - '0';
                res = res *10 + n;
            }
            return res;
        }
    }
}