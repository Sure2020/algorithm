/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC155_min_stack
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
 * 技巧是用一个单独的栈保存当前最小的元素，还需要练一下
 * @author: Admin
 * @create: 2024-03-18
 **/
public class LC155_min_stack {
    class MinStack {
        Stack<Integer> stk;
        Stack<Integer> minStk;
        public MinStack() {
            //这里有点神奇，不加两个尖括号，运行速度竟然会慢1ms？！
            stk = new Stack<>();
            minStk = new Stack<>();
        }

        public void push(int val) {
            stk.push(val);
            //这里的等于号有讲究，不然getmin时会发生空栈异常
            if(minStk.isEmpty()|| val<= minStk.peek()){
                minStk.push(val);
            }
        }

        public void pop() {
            if(stk.peek().equals(minStk.peek())){
                minStk.pop();
            }
            stk.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return minStk.peek();
        }
    }

    class MinStack20241128 {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        public MinStack20241128() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if(minStack.isEmpty() || val<=minStack.peek()){
                minStack.push(val);
            }else{
                minStack.push(minStack.peek());
            }
            stack.push(val);
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
//关键是搞个stack专门存当前元素入栈后的最小值
}