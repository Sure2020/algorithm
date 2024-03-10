/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC234_palindrome_linked_list
 * Date Created : 2024-01-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-05       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 第三次看这题，才意识到这个思路是从labuladong那里学来的，第二次看提交记录我以为是自己的思路。。。
 * @author: Admin
 * @create: 2024-01-05
 **/
public class LC234_palindrome_linked_list {
    public static void main(String[] args) {
        ListNode head = Tools.listNodeCreater(new int[]{1,2,2,1});
        System.out.println(isPalindrome(head));
    }
    static ListNode curser = new ListNode();
    static public boolean isPalindrome(ListNode head) {
        curser = head;
        return recurse(head);

    }
    static public boolean recurse(ListNode head){
        if(head==null){
            return false;
        }
        recurse(head.next);
        if(head.val != curser.val){
            return false;
        }

        curser = curser.next;
        if(curser==null){
            return true;
        }
        return false;

    }
}