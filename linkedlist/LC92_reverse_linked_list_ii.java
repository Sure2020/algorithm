/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC_reverse_linked_list_ii
 * Date Created : 2024-03-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-03       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 有很强的技巧性，需要记忆
 * @author: Admin
 * @create: 2024-03-03
 **/
public class LC92_reverse_linked_list_ii {
    class SolutionSelfWrong {
        ListNode successor = null;
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode p = head;
            int count=1;
            while(p!=null){
                if(count<left-1){
                    p = p.next;
                    count++;
                }else{
                    break;
                }
            }


            p.next=reverse(p.next, 1, right);
            while(p!=null){
                if(count<right+1){
                    p=p.next;
                    count++;
                }else{
                    break;
                }
            }
            successor = p;
            return head;
        }
        public ListNode reverse(ListNode head, int count,int right){
            if(head==null||head.next==null){
                return head;
            }
            ListNode last = reverse(head.next,count+1, right);
            if(count==right){
                return head;
            }
            head.next.next=head;
            head.next=successor;
            return last;
        }
    }
    class SolutionLabuladong {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==1){
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left-1,right-1);
            return head;
        }

        ListNode successor = null;
        public ListNode reverseN(ListNode head, int n){
            if(n==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n-1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }

    class Solution20240309 {
        //此次的感受是，不知道base case时如何处理，就带入只有一个节点的链表来感受一下即可明了。
        //仍然不能独立写出，还要再练练。
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //这里，先前进到第left个节点，那么后面的节点就可以按翻转前n个节点来处理
            if(left==1){
                //此时相当于翻转前n个节点，开始按reverseN的方法处理本节点以及后面的节点即可
                return reverseN(head, right);
            }
            //left之前的节点，还是原样拼起来，所以用head.next来承接
            head.next= reverseBetween(head.next, left-1, right-1);
            return head;
        }

        //翻转前n个节点，先找到第n+1个节点并记下来，记为successor，并返回当前节点，也就是到此节点为止，后面的节点不管
        //再按翻转全部链表的方法，最后head.next不再指向null，而是指向第n+1个节点即可
        ListNode successor = null;
        public ListNode reverseN (ListNode head, int n){
            if(head==null||head.next==null){
                return head;
            }
            if(n==1){
                successor=head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n-1);
            head.next.next=head;
            head.next=successor;
            return last;
        }
    }
}