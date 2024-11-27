/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC232_implement_queue_using_stacks
 * Date Created : 2024-03-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-06       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 我这就有点牛批了，看了一遍labuladong的思路，竟然独立一次通过，但stack的一些方法还不熟，需要再次练习
 * @author: Admin
 * @create: 2024-03-06
 **/
public class LC232_implement_queue_using_stacks {
    class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if(!s2.empty()){
                return s2.pop();
            }
            while(!s1.empty()){
                Integer tempInteget = s1.pop();
                s2.push(tempInteget);
            }
            return s2.pop();
        }

        public int peek() {
            if(!s2.empty()){
                return s2.peek();
            }
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyQueue20241127 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue20241127() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
//主要是pop和peek稍微麻烦一点，关键是先将元素从s1压入s2，s2再出栈，增提就是先进先出了
//注意初始化stack时指定类型 privste Stack<Integer> s1
}