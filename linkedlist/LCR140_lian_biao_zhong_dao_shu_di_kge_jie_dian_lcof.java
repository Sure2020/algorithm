/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR140_lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof
 * Date Created : 2024-01-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-08
 **/
public class LCR140_lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof {
    /*static int count = 0;
    static ListNode result = null;
    public static void main(String[] args) {
        System.out.println("test");
        ListNode list1 = Tools.listNodeCreater(new int[]{10, 20, 30, 40, 50});
        System.out.println(trainingPlan(list1, 1).val);
    }
    public static ListNode trainingPlan(ListNode head, int cnt) {
        if (head==null){
            return null;
        }
        trainingPlan(head.next, cnt);
        count ++;
        System.out.println(count);
        if (cnt == count){
            System.out.println(head.val);
            result = head;
        }

        return result;
    }*/
    public static void main(String[] args) {
        System.out.println("testing");
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 3,5});
        Solution20240520 solution20240520 = new Solution20240520();
        System.out.println(solution20240520.trainingPlan(list1, 2).val);
    }
    public ListNode trainingPlan(ListNode head, int cnt) {
        if(head==null){
            return null;
        }
        ListNode fasterPoint = head, slowerPoint=head;
        while(cnt!=0){
            if(fasterPoint==null){
                return null;
            }
            fasterPoint = fasterPoint.next;
            cnt --;

        }
        while(fasterPoint!=null){
            fasterPoint = fasterPoint.next;
            slowerPoint = slowerPoint.next;
        }
        return slowerPoint;

    }

    // 单步调试了一下，事实证明相较于快慢指针，我更喜欢递归的方式
    // 但是！双指针的方法更快！0ms，递归则要2ms
    static class Solution20240520 {
        int count = 0;
        public ListNode trainingPlan(ListNode head, int cnt) {
            //base case
            if(head==null){
                return head;
            }
            ListNode cntNode = trainingPlan(head.next, cnt);
            count++;
            if(count==cnt){
                System.out.println(head.val);
                return head;
            }
            //这里return cntNode，会把count==cnt返回的那个目标节点一直返回到最外层调用
            return cntNode;
        }
    }
    class Solution20240520DublePointer {

        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode slow=head, fast=head;
            while(cnt!=0){
                fast=fast.next;
                cnt--;
            }
            while(fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }

    //递归
    //哈哈，地铁上没写出来，路上想了想，到公司立马写出来。注意诀窍是弄清楚递归函数的定义！
    class Solution20240529 {
        private int count=0;
        public ListNode trainingPlan(ListNode head, int cnt) {
            //base case
            if(head==null){
                return null;
            }
            ListNode result =  trainingPlan(head.next, cnt);
            count++;
            if(count == cnt){
                return head;
            }
            return result;
        }
    }

    class Solution20240704 {
        int count=0;
        ListNode result = new ListNode();
        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null){
                return null;
            }

            trainingPlan(head.next,cnt);
            count++;
            if(count==cnt){
                //result.val = head.val;
                result = head;
                // return head;
            }
            return result;
            //return null;
        }
    }
//递归
//递归的结果用ListNode result来承接，比较好理解

    class Solution20240801 {
        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode slow = head, fast=head;
            for(int i=1;i<cnt;i++){
                fast = fast.next;
            }
            while(fast.next!=null){
                slow = slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }
//特么的，差点没想起来，原来是快慢指针

    class Solution20241128 {
        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode slow=head,fast=head;
            for(int i=1;i<=cnt;i++){
                fast=fast.next;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
//快慢指针，快指针领先cnt步，当快指针走到头，慢指针位置即为所求

    class Solution20250513 {
        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null){
                return head;
            }
            ListNode fast = head;
            for(int i=1;i<=cnt;i++){
                fast = fast.next;
            }
            ListNode slow = head;
            while(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    class Solution20250525 {
        public ListNode trainingPlan(ListNode head, int cnt) {
            if(head==null){
                return null;
            }
            ListNode slow=head,fast=head;
            int count = 1;
            while(count<=cnt && fast!=null){
                fast=fast.next;
                count++;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
}