/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC415_add_strings
 * Date Created : 2024-03-20
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-20       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 自己写的不够精简，需要再练一次
 * @author: Admin
 * @create: 2024-03-20
 **/
public class LC415_add_strings {
    class Solution {
        public String addStrings(String num1, String num2) {
            // double number1 =0;
            // double number2=0;
            // for(int i=0;i<num1.length();i++){
            //     char c = num1.charAt(i);
            //     number1 = 10*number1+(c-'0');
            // }
            // for(int i=0;i<num2.length();i++){
            //     char c = num2.charAt(i);
            //     number2 = number2*10+(c-'0');
            // }
            // // System.out.println(number1);
            // // System.out.println(number2);
            // return String.valueOf(number1+number2);
            List<String> result = new ArrayList<>();
            // int longerLength = Math.max(num1.length(), num2.length());
            int i=num1.length()-1;
            int j=num2.length()-1;
            int extraValue=0;
            // int i=length1-1;
            // int j=length2-1;
            while(i>=0&&j>=0){
                char c1 = num1.charAt(i);
                int n1 = c1-'0';
                //System.out.println("n1:"+n1);
                char c2 = num2.charAt(j);
                int n2 = c2-'0';
                //System.out.println("n2:"+n2);
                int sum = n1+n2;
                result.add(String.valueOf((sum+extraValue)%10));
                extraValue = (sum+extraValue)/10;
                i--;
                j--;
            }
            if(i>j){
                while(i>=0){
                    char c = num1.charAt(i);
                    int n = c-'0';
                    result.add(String.valueOf((n+extraValue)%10));
                    extraValue=(n+extraValue)/10;
                    i--;
                }
            }
            else if(i<j){
                while(j>=0){
                    char c = num2.charAt(j);
                    int n = c-'0';
                    result.add(String.valueOf((n+extraValue)%10));
                    extraValue=(n+extraValue)/10;
                    j--;
                }
            }
            if(extraValue>0){
                result.add(String.valueOf(extraValue));
            }
            //System.out.println(result);
            StringBuilder sb=new StringBuilder();
            for(int k=result.size()-1;k>=0;k--){
                sb.append(result.get(k));
            }
            return sb.toString();
        }
    }

    class SolutionLessCode {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int i=num1.length()-1;
            int j=num2.length()-1;
            int extraValue=0;
            while(i>=0||j>=0){
                int n1 = i>=0?num1.charAt(i)-'0' : 0;
                int n2 = j>=0?num2.charAt(j)-'0' : 0;
                int sum = n1+n2+extraValue;
                //System.out.println(n1+"##"+n2+"##"+extraValue+"##"+sum);
                sb.append(sum%10);
                extraValue = sum/10;
                i--;
                j--;
            }
            if(extraValue>0){
                sb.append(extraValue);
            }
            sb.reverse();
            return sb.toString();
        }
    }

    class Solution20240618 {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int p1=num1.length()-1,p2=num2.length()-1,moreThanTen=0;
            int n1=0,n2=0;
            while(p1>=0 || p2>=0){
                n1 = p1>=0?num1.charAt(p1)-'0':0;
                n2 = p2>=0?num2.charAt(p2)-'0':0;
                int sum = n1+n2+moreThanTen;
                int n3 = sum%10;
                moreThanTen = sum/10;
                sb.append(n3);
                //System.out.println(n3);

                p1--;
                p2--;
            }
            //System.out.println("test");
            // while(p1>=0){
            //     n1 = num1.charAt(p1)-'0';
            //     int sum = n1+moreThanTen;
            //     int n3 = sum%10;
            //     moreThanTen = sum/10;
            //     sb.append(n3);

            //     p1--;
            // }
            // while(p2>=0){
            //     n2 = num2.charAt(p2)-'0';
            //     int sum = n2+moreThanTen;
            //     int n3 = sum%10;
            //     moreThanTen = sum/10;
            //     sb.append(n3);

            //     p2--;
            // }
            if(moreThanTen>0){
                sb.append(moreThanTen);
            }
            sb.reverse();
            return sb.toString();
        }
    }
//确实第一时间想到了用数组，但看到入参是string，那结果先用stringbuilder吧。
//当进位变量不为0，则要继续处理
//技巧：获得char类型的数字对应的int值，char-'0'
//最后翻转一下string?

    class Solution20240627 {
        public String addStrings(String num1, String num2) {
            int p1=num1.length()-1,p2=num2.length()-1;
            int n1=0,n2=0;
            int c1,c2;
            int sum=0,moreThanTen=0;
            StringBuilder sb = new StringBuilder();
            while(p1>=0|| p2>=0 || moreThanTen !=0){

                if(p1>=0){
                    c1 = num1.charAt(p1);
                    n1 = c1-'0';
                    p1--;
                }else{
                    n1=0;
                }
                if(p2>=0){
                    c2=num2.charAt(p2);
                    n2=c2-'0';
                    p2--;
                }else{
                    n2=0;
                }
                sum = n1+n2 + moreThanTen;
                //System.out.println("n1: " + n1 + "  n2 " + n2);

                moreThanTen = sum/10;
                //System.out.println("sum: " + sum + "  moreThanTen: " + moreThanTen);
                sb.append(sum%10);

                //System.out.println(p1 + "   " + p2 + "   " + moreThanTen);

            }
            return sb.reverse().toString();
        }
    }
//用一个变量记录进位的值
//计算当前char对应的int，用char='0'
//搞错了，指针要从后往前遍历

    class Solution20240731 {
        public String addStrings(String num1, String num2) {
            int index1=num1.length()-1,index2=num2.length()-1;
            StringBuilder sb = new StringBuilder();


            int moreThanTen=0;
            while(index1>=0 || index2>=0 || moreThanTen>0){
                char c1='0',c2='0';
                //System.out.println("index1: " + index1 + " index2: " + index2);
                int n1=0,n2=0,sum=0,value=0;
                if(index1>=0){
                    c1 = num1.charAt(index1);
                    index1--;
                }
                if(index2>=0){
                    c2 = num2.charAt(index2);
                    index2--;
                }
                n1 = c1-'0';
                n2 = c2-'0';
                //System.out.println("n1: " + n1 + " n2: " + n2);
                sum = n1 + n2 + moreThanTen;
                moreThanTen = sum /10;
                value = sum%10;
                //System.out.println("sum: " + sum + " moreThanTen: "+moreThanTen + " value: " + value);
                sb.append(value);
            }

            return sb.reverse().toString();
        }
    }

//双指针。瞟到了上次的思路：求当前char对应的int，用c-'0';
//要从字符串的后面往前算了
//事后：又增加一条铁律：尽量缩小变量作用域，即使每次循环都声明一次变量又如何？

    class Solution20241127 {
        public String addStrings(String num1, String num2) {
            int index1 = num1.length()-1,index2 = num2.length()-1;
            StringBuilder sb = new StringBuilder();
            int moreThanTen=0;
            while(index1>=0 || index2>=0 || moreThanTen>0){
                char c1='0',c2='0';
                if(index1>=0){
                    c1 = num1.charAt(index1);
                    index1--;
                }
                if(index2>=0){
                    c2 = num2.charAt(index2);
                    index2--;
                }
                int n1=c1-'0',n2=c2-'0';
                int sum = n1+n2+moreThanTen;
                int value = sum % 10;
                moreThanTen = sum / 10;
                sb.append(value);
            }
            return sb.reverse().toString();
        }
    }

//双指针。瞟到了上次的思路：求当前char对应的int，用c-'0';
//要从字符串的后面往前算了
//事后：又增加一条铁律：尽量缩小变量作用域，即使每次循环都声明一次变量又如何？
}