/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC131_palindrome_partitioning
 * Date Created : 2024-04-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-10       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-10
 **/
public class LC131_palindrome_partitioning {
    class Solution {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> track = new LinkedList<>();
        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return res;
        }
        public void backtrack(String s, int start){
            if(start==s.length()){
                //注意将LinkedList加到List<List<String>>中前要先new ArrayList
                res.add(new ArrayList<String>(track));
                //res.add(track);
                return;
            }
            for(int i=start; i<s.length();i++){
                if(!ishuiwen(s, start, i)){
                    continue;
                }
                track.addLast(s.substring(start, i+1));
                backtrack(s, i+1);
                track.removeLast();
            }
        }
        public boolean ishuiwen(String s, int start, int end){
            int left=start, right=end;
            while(left<right){
                if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}