/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC43_multiply_strings
 * Date Created : 2024-03-21
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-21       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-21
 **/
public class LC43_multiply_strings {
    //这题技巧性很强，要练
    class Solution {
        //123 * 6 + 123*5*10+123*4*100
        public String multiply(String num1, String num2) {
            // int number1 = 0;
            // int number2 = 0;
            // for(int i=0;i<num1.length();i++){
            //     number1=number1*10+(num1.charAt(i)-'0');
            // }
            // for(int i=0;i<num2.length();i++){
            //     number2=number2*10+(num2.charAt(i)-'0');
            // }
            // int resultInt = number1*number2;
            // return String.valueOf(resultInt);
            int size1=num1.length();
            int size2=num2.length();
            int[] res = new int[size1+size2];
            for(int i=size1-1;i>=0;i--){
                for(int j=size2-1;j>=0;j--){
                    int mul=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                    int p1=i+j;
                    int p2 = i+j+1;
                    int sum = mul+res[p2];
                    res[p2]=sum%10;
                    res[p1]+=sum/10;
                }
            }
            int i=0;
            while (i<res.length && res[i]==0) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            for(;i<res.length;i++){
                sb.append(res[i]);
            }
            return sb.length()==0?"0":sb.toString();
        }
    }
}