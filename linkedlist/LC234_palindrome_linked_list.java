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
 * @author: Admin
 * @create: 2024-01-05
 **/
public class LC234_palindrome_linked_list {
    ListNode curser = new ListNode();
    public boolean isPalindrome(ListNode head) {
        curser = head;
        return recurse(head);

    }
    public boolean recurse(ListNode head){
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