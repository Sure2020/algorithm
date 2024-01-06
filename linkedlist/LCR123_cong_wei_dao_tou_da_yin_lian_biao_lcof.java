/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR123_cong_wei_dao_tou_da_yin_lian_biao_lcof
 * Date Created : 2024-01-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-06
 **/
public class LCR123_cong_wei_dao_tou_da_yin_lian_biao_lcof {
    public static void main(String[] args) {
        System.out.println("test");
        ListNode sourceList1 = Tools.listNodeCreater(new int[]{1,2,3,4,5});
        System.out.println(reverseBookList(sourceList1).length);
    }
    static int[] result = null;
    static  int length = 0;
    static int index = 0;
    public static int[] reverseBookList(ListNode head) {
        if(head ==null){
            return  new int[]{};
        }
        reverse(head);
        return result;
    }
    public static void reverse(ListNode head) {
        if(head==null){
            result = new int[length];
            return;
        }
        length++;
        reverse(head.next);
        result[index] = head.val;
        index ++;

    }
}