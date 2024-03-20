/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC227_basic_calculator_ii
 * Date Created : 2024-03-20
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-20       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 提交了这题只是证明我曾经看过，但不打算掌握它了，有点复杂，很多细节需要处理
 * @author: Admin
 * @create: 2024-03-20
 **/
public class LC227_basic_calculator_ii {
    class Solution {
        public int calculate(String s) {
            Queue<Character> queue = new LinkedList<>();
            for(int i=0;i<s.length();i++){
                queue.offer(s.charAt(i));
            }
            return helper(queue);
        }
        public int helper(Queue<Character> queue){
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            int num=0;
            while (!queue.isEmpty()){
                char currentChar = queue.poll();
                //是数字，就执行计算
                if(Character.isDigit(currentChar)){
                    num = 10*num+Character.getNumericValue(currentChar);
                }
                //遇到左括号开始递归计算
                if(currentChar=='('){
                    num = helper(queue);
                }
                if((!Character.isDigit(currentChar) && currentChar!=' ') || queue.isEmpty()){
                    if(sign=='+'){
                        stack.push(num);
                    }else if(sign=='-'){
                        stack.push(-num);
                    }else if(sign=='*'){
                        stack.push(stack.pop()*num);
                    }else if(sign=='/'){
                        stack.push(stack.pop()/num);
                    }

                    num=0;
                    sign=currentChar;
                }
                //遇到右括号结束递归
                if(currentChar==')'){
                    break;
                }
            }
            int res = 0;
            for(int i:stack){
                res+=i;
            }
            return res;
        }
    }
}