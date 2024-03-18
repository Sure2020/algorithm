/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR147_bao_han_minhan_shu_de_zhan_lcof
 * Date Created : 2024-03-18
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-18       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-18
 **/
public class LCR147_bao_han_minhan_shu_de_zhan_lcof {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();

        }

        public void push(int x) {
            stack.push(x);
            //System.out.println(x);
            if(minStack.isEmpty()|| x<=minStack.peek()){
                minStack.push(x);
            }
            //System.out.println(stack.size()+"###########"+minStack.size());

        }

        public void pop() {
            //System.out.println(stack.size()+"-------"+minStack.size());
            //唉我有点蠢，单凭记忆在写，但把stack.pop写在了minStack.pop的前面，出了问题！！！
            //stack.pop();
            //System.out.println(stack.peek()+"###"+minStack.peek());
            if(stack.peek().equals(minStack.peek())){
                minStack.pop();
            }
            stack.pop();
            //System.out.println(stack.size()+"-------"+minStack.size());
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
            //return 0;
        }
    }
}