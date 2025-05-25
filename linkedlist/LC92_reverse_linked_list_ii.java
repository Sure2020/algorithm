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

    //思路：先实现reverseN，也就是翻转前N个，再将head前进到left的位置，调用reverseN
    //不是最简洁的做法，但是早班地铁上半小时左右自己独立调出来的，在到站的前一秒AC，别提多有成就感了
    class Solution20240523 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //return reverseN(head, left);//证明reverseN函数写的没问题
            if(head==null || head.next==null){
                return head;
            }
            //先跳过前Left个节点
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p = dummy;
            for(int i=1;i<left;i++){
                p = p.next;
            }
            p.next = reverseN(p.next, right-left+1);
            return dummy.next;
        }
        //reverseN则是需要一个节点保存后继节点
        ListNode successor = new ListNode();
        public ListNode reverseN(ListNode head,int n){
            //base case
            if(n==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n-1);
            head.next.next=head;
            head.next = successor;
            return last;
        }
    }

    //思路：先实现reverseN，也就是翻转前N个，再将head前进到left的位置，调用reverseN
    //不是最简洁的做法，但是早班地铁上半小时左右自己独立调出来的，在到站的前一秒AC，别提多有成就感了
    class Solution20240524 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //return reverseN(head, left);//证明reverseN函数写的没问题
            if(head==null || head.next==null){
                return head;
            }
            //base case
            if(left==1){
                return reverseN(head,right);
            }

            //先跳过前Left个节点
        /*ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        for(int i=1;i<left;i++){
            p = p.next;
        }
        p.next = reverseN(p.next, right-left+1);
        return dummy.next;*/

            //前进到第left个节点的方式，值得记忆！
            head.next = reverseBetween(head.next, left-1,right-1);
            return head;
        }
        //reverseN则是需要一个节点保存后继节点
        ListNode successor = new ListNode();
        public ListNode reverseN(ListNode head,int n){
            //base case
            if(n==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n-1);
            head.next.next=head;
            head.next = successor;
            return last;
        }
    }

    class Solution20240625 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null || head.next==null){
                return head;
            }
            // return reverseN(head, 4);
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode previous=null,next=null,p1=dummy,p2=null;
            for(int i=1;i<left;i++){
                p1 = p1.next;
            }
            previous = p1;
            //System.out.println("privious: "+previous.val);
            p2 = p1;
            for(int i=left;i<right;i++){
                p2 = p2.next;
            }
            //System.out.println("previous: "+previous.val + "n: "+ (right-left+1));
            //return reverseN(previous, right -left+1);
            //return reverseN(previous.next, right -left+1);
            previous.next = reverseN(previous.next, right -left+1);
            return dummy.next;
        }
        public ListNode reverseN(ListNode head,int n){
            if(head==null || head.next==null){
                return head;
            }
            int count = 1;
            ListNode previous=null,current = head,next=null;
            while(count<=n){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                count ++;
            }
            head.next = next;
            return previous;
        }
    }
//1.先前进到left位置；2.再翻转left-right，利用迭代法；3.尾部指向processor
//利用翻转前N个节点的函数
//哎，调试了太久，估计共有一个小时。

    class Solution2024062501 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null || head.next==null){
                return head;
            }
            if(left==1){
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left-1,right-1);
            return head;
        }
        public ListNode reverseN(ListNode head,int n){
            if(head==null || head.next==null){
                return head;
            }
            int count = 1;
            ListNode previous=null,current = head,next=null;
            while(count<=n){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                count ++;
            }
            head.next = next;
            return previous;
        }
    }
//利用递归，将left递归到==1，再利用翻转前N个节点的函数

    class Solution20240731 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //return reverseK(head, right);
            if(head==null||head.next==null){
                return head;
            }
            //System.out.println("left: " + left + " right: " + right);
            //base case
            if(left==1){
                //head.next = reverseK(head.next, right);
                // return head;
                // 注意，这里想清楚要干嘛，如果left==1，那就是翻转前k个，肯定要从head开始翻转，而不是从head.next!
                return reverseK(head, right);
            }
            head.next = reverseBetween(head.next, left-1,right-1);

            return head;

        }
        public ListNode reverseK(ListNode head, int k){
            if(head==null || head.next==null){
                return head;
            }
            ListNode previous=null,current=head,next=null;
            while(k>=1){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                k--;
            }
            head.next = next;
            return previous;
        }
    }
//利用迭代的方式翻转
//翻转left到right，相当于。。。翻转1到right-left。先前进left步，我记得前进的方式有讲究，用递归的方式前进
//转换成翻转前k个节点

//事后：注意两点，1.搞清楚base case。2.翻转前N个节点的函数，记得拼接后面未翻转的.3.注意reverseK从head开始而不是从Head.next
//这题克我，做过很多遍，每次都纠结好久，练！


    class Solution20250518 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head == null || head.next == null){
                return head;
            }
            if(left==1){
                return reverseK(head,right);
            }
            head.next = reverseBetween(head.next,left-1,right-1);
            return head;
        }
        public ListNode reverseK(ListNode head, int k){
            if(head==null || head.next==null){
                return head;
            }
            ListNode previous=null,current=head,next=null;
            while(k>=1){
                next=current.next;
                current.next=previous;
                previous = current;
                current = next;
                k--;
            }
            // 将翻转后的链表和未翻转的链表连起来
            head.next=next;
            return previous;
        }
    }

    class Solution20250525 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null || head.next==null){
                return head;
            }
            if(left==1){
                return reverseK(head,right);
            }
            head.next = reverseBetween(head.next, left-1, right-1);
            return head;
        }
        public ListNode reverseK(ListNode head, int k){
            ListNode previous=null, current=head, next=null;
            while(k>=1){
                next=current.next;
                current.next=previous;
                previous=current;
                current=next;
                k--;
            }
            head.next=next;
            return previous;
        }
    }
}