/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC344_reverse_string
 * Date Created : 2023-10-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-24       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-24
 **/
public class LC344_reverse_string {
    public static void main(String[] args) {
        System.out.println("case1，输出：[\"o\",\"l\",\"l\",\"e\",\"h\"]");
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        Tools.listPriter(s1);
        System.out.println("case1，输出：[\"h\",\"a\",\"n\",\"n\",\"a\",\"H\"]");
        char[] s2 = new char[]{'h', 'a', 'n', 'n', 'a', 'H'};
        reverseString(s2);
        Tools.listPriter(s2);

    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}