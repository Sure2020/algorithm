/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC394_decode_string
 * Date Created : 2024-03-24
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-24       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-24
 **/
public class LC394_decode_string {
    //听我说，听我说，虽然我独立做出来了，但耗费2个小时。这种题感觉重点在考察细心，顺便考察算法。很耗时，所以复习时不建议再做第二遍
    class Solution {
        public String decodeString(String s) {
            return recursor(s, 0, s.length()-1);
        }
        public String recursor(String s, int start, int end){
            StringBuilder result = new StringBuilder();
            // int length = s.length();
            //base case
            if(start>end){
                return "";
            }
            int i=start;
            while (i<=end) {
                int j=0;
                char c = s.charAt(i);
                if(c>='a'&&c<='z'){
                    result.append(c);
                    i++;
                    continue;
                }
                int repeat =0;
                StringBuilder numberSB = new StringBuilder();
                while(i<=end){
                    c = s.charAt(i);

                    if(c>='0'&&c<='9'){
                        //System.out.println("###"+(c-'0'));
                        //repeat+=repeat*10+(c-'0');
                        numberSB.append(c);
                        i++;
                    }else{
                        //System.out.println(numberSB.toString());

                        break;
                    }

                    //i++;
                }
                repeat=Integer.valueOf(numberSB.toString());
                System.out.println(repeat);
                //if(c>='1'&&c<='9'){
                //repeat=c-'0';
                //跳过数字后面的左中括号
                //找匹配的右中括号
                //记录遇到的左中括号个数
                int count = 0;
                j=i;
                while(j<=end){
                    char currentChar = s.charAt(j);
                    if(currentChar=='['){
                        count++;
                    }else if(currentChar==']'){
                        count--;
                    }
                    if(count==0){
                        break;
                    }
                    j++;
                }
                //开始记录中括号里面的内容
                // StringBuilder sb = new StringBuilder();
                // for(int j=i;j<length;j++){

                // }
                //开始递归,i+2跳过左括号
                String  repeatPart = recursor(s, i+1, j-1);
                for(int k=1;k<=repeat;k++){
                    result.append(repeatPart);
                }
                //}
                i=j+1;
                // if (c==']') {
                //     break;
                // }

            }
            return result.toString();
        }
    }
}