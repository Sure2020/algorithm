/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC225_implement_stack_using_queues
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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这个也要再练一下，注意top的技巧以及从队列中拿出来再放进去的技巧
 * @author: Admin
 * @create: 2024-03-06
 **/
public class LC225_implement_stack_using_queues {
    class MyStack {
        Queue<Integer> queue;
        Integer temp_top;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            temp_top = x;
        }

        public int pop() {
            int size=queue.size();
            while(size>2){
                queue.offer(queue.poll());
                size --;
            }
            temp_top = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return temp_top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


    class MyStack20250525 {
        Queue<Integer> queue = new LinkedList<>();
        int temp_top;

        public MyStack20250525() {

        }

        public void push(int x) {
            queue.offer(x);
            //把这个忘了
            temp_top=x;
        }

        public int pop() {
            int count = queue.size();
            while(count>2){
                queue.offer(queue.poll());
                count--;
            }
            temp_top=queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return temp_top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}