/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC165_compare_version_numbers
 * Date Created : 2024-04-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-03       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-03
 **/
public class LC165_compare_version_numbers {
    //这题就不再练了吧，考察细心的，又是面向测试用例编程，调试耗费了我2个小时的时间
    class Solution {
        public int compareVersion(String version1, String version2) {
            // int index1=0;
            // int index2=0;
            // int length1 = version1.length();
            // int length2 = version2.length();
            String[] list1 = version1.split("\\.");
            String[] list2 = version2.split("\\.");
            //System.out.println("testing");
            int index1=0, index2=0;
            while(index1<list1.length&&index2<list2.length){
                //System.out.println(list1[index1] + "######" + list2[index2]);
                // if(stripZero(list1[index1]).compareTo(stripZero(list2[index2])) < 0){
                //     return -1;
                // }else if (stripZero(list1[index1]).compareTo(stripZero(list2[index2])) > 0){
                //     return 1;
                // }
                if(compareStringNumber(list1[index1], list2[index2]) == 1) {
                    return 1;
                }else if (compareStringNumber(list1[index1], list2[index2]) == -1) {
                    return -1;
                }
                index1++; index2++;
            }
            if(index1<list1.length){
                for(int i=index1;i<list1.length;i++){
                    //System.out.println(list1[i] + "#");
                    // if(list1[i]!="0"){
                    //     return 1;
                    // }
                    //这里不能用==判断两个字符串，踩坑了
                    if(!stripZero(list1[i]).equals("0")){
                        return 1;
                    }
                }
            }
            if(index2<list2.length){
                for(int i=index2;i<list2.length;i++){
                    //System.out.println(list2[i]+"######");
                    //这里不能用==判断两个字符串，踩坑了
                    if(!stripZero(list2[i]).equals("0")){
                        return -1;
                    }
                }
            }
            return 0;
        }
        public String stripZero(String str){
            int i=0;
            //这里将边界i<str.length()改为i<str.length()-1，目的是保留最后一个字符，这样在字符全为0时，去掉前缀零可以剩下一个0
            while(i<str.length()-1 && str.charAt(i)=='0'){
                i++;
            }
            return str.substring(i, str.length());
        }
        public int compareStringNumber(String s1, String s2){
            String str1 = stripZero(s1);
            String str2 = stripZero(s2);
            int num1 = Integer.valueOf(str1);
            int num2 = Integer.valueOf(str2);
            if(num1>num2){
                return 1;
            }else if(num1==num2){
                return 0;
            }else{
                return -1;
            }
        }
    }
}