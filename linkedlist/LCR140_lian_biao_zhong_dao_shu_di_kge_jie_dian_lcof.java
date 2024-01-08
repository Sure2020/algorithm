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

}