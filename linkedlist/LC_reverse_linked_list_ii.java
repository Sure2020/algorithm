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
public class LC_reverse_linked_list_ii {
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
}