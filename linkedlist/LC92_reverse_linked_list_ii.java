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
 * 更新了用迭代的方式实现，空间复杂度有优势，为o(1)，注意一步一步来，理清思路，也没那么难，哈哈哈哈哈！！！
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

    //迭代的方式，注意一步一步来，理清思路，也没那么难，哈哈哈哈哈！！！
    class Solution20240309Iterative {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null || head.next==null || left==right){
                return head;
            }
            //因为left可能是第一个节点，那么就搞个dummy节点当做前驱节点precurssor
            ListNode dummy = new ListNode(-1);
            dummy.next=head;

            //找到待截取的左节点的前一个节点，和右节点
            ListNode precurssor=null, successor=null;
            ListNode leftNode = null, rightNode=null;
            ListNode p=dummy;
            //这里纠结了半天，要从0开始，因为dummy的序号是0
            for(int i=0;i<=right;i++){
                if(i==left-1){
                    precurssor=p;
                }else if(i==right){
                    rightNode=p;
                    break;
                }
                p=p.next;
            }
            leftNode=precurssor.next;
            successor=rightNode.next;
            //System.out.println("##"+leftNode.val+"##"+rightNode.val);
            //断开
            precurssor.next=null;
            rightNode.next=null;
            //翻转
            reverse(leftNode);
            //拼接
            //precurssor.next=leftNode;
            //successor.next=rightNode.next;
            precurssor.next=rightNode;
            leftNode.next=successor;
            return dummy.next;
        }
        public void reverse(ListNode head){
            if(head==null || head.next == null){
                return;
            }
            ListNode precurssor=null,current=head,next=head;
            while(current!=null){
                next=current.next;
                current.next=precurssor;
                precurssor=current;
                current=next;
            }
            //return precurssor;
        }
    }

    class Solution20240515 {
        ListNode successor = null;
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==1){
                return reverseN(head, right);
            }
            ListNode last = reverseBetween(head.next, left-1, right-1);
            head.next = last;
            return head;
        }
        public ListNode reverseN(ListNode head, int m){
            if(m==1){
                successor = head.next;
                // 注意1，忘了return
                return head;
            }
            ListNode last = reverseN(head.next, m-1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
    class Solution202405152247 {
        ListNode successor = null;
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==1){
                return reverseN(head,right);
            }
            head.next=reverseBetween(head.next, left-1,right-1);
            return head;
        }
        public ListNode reverseN(ListNode head, int m){

            if(m==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, m-1);
            head.next.next=head;
            head.next=successor;
            return last;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution20240516 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // if(head==null || head.next==null){
            //     return head;
            // }
            // ListNode p = head;
            // for(int i=0;i<left;i++){
            //     p=p.next;
            // }
            // p.next = reverseN(p.next,right-left);
            // return head;
            //注意2，前进到left节点不是上面这么前进的，递归先想清楚base case，这是关键
            if(left==1){
                return reverseN(head, right);
            }
            //注意3，主要思路是想清楚：对于head，是翻转left->right,那对于head.next，就是翻转left-1,right-1,直到left-n=1触发base case开始真正翻转。
            //在未到达base case之前，相当于head.next=head.next.next,就是原样拼接了一遍
            head.next = reverseBetween(head.next, left-1,right-1);
            return head;

        }
        ListNode successor=null;
        public ListNode reverseN(ListNode head, int m){
            if(head==null || head.next==null){
                return head;
            }
            if(m==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, m-1);
            head.next.next=head;
            //注意1，这里要和后继节点接上，不能思维定势地在后面接null
            head.next=successor;
            return last;

        }
    }

    //先理一下思路：先实现翻转前m个节点，再将head慢慢移动到第left个
    class Solution202405161518 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //base case
            if(left==1){
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left-1,right-1);
            return head;
        }
        ListNode successor = null;
        public ListNode reverseN(ListNode head, int m){
            //base case
            if(m==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, m-1);
            head.next.next=head;
            head.next=successor;
            return last;
        }
    }
}