/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1290_convert_binary_number_in_a_linked_list_to_integer
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
public class LC1290_convert_binary_number_in_a_linked_list_to_integer {
    int count;
    public int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }
        int result = getDecimalValue(head.next);
        int val = head.val;
        result = val * (int)Math.pow(2,count) + result;
        count ++;
        return result;
    }
}