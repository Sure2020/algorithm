/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC22_generate_parentheses
 * Date Created : 2024-04-12
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-12       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-12
 **/
public class LC22_generate_parentheses {
    //这个思路我反正是想不到，只能靠记忆了
    class Solution {
        List<String> res = new ArrayList<String>();
        //【优化】将track的类型由链表改为stringbuilder，整体运行速度由3ms降到2ms，因为最后链表需要join("",track)，而stringbuilder直接tostring即可
        //LinkedList<String> track = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        public List<String> generateParenthesis(int n) {
            backtrack(n,n);
            return res;
        }
        public void backtrack(int left, int right){
            //若剩下的左括号比右括号多，肯定不合法，这里误写反了，悲哀
            if(right<left){
                return;
            }
            if(left<0||right<0){
                return;
            }
            if(left==0 && right==0){
                // res.add(String.join("",track));
                res.add(track.toString());
            }

            //尝试放左括号
            //track.addLast("(");
            // 【优化】 保持使用deleteCharAt的前提下，这里用append(’(‘)相比用append("(")，总用时由1ms将为0ms，原因暂不明！
            track.append("(");
            backtrack(left-1, right);
            // track.removeLast();
            //track.deleteCharAt(track.length()-1);
            //【优化】 即使上面用append("(")，删除最后一个字符这里用setLength方法，总用时由1ms将为0ms，因为setLength方法不用像deleteCharAt方法那样需要遍历并挪动字符
            track.setLength(track.length()-1);
            //尝试放右括号
            // track.addLast(")");
            track.append(")");
            backtrack(left, right-1);
            // track.removeLast();
            //track.deleteCharAt(track.length()-1);
            track.setLength(track.length()-1);
        }
    }
}