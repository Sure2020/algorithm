/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC8_string_to_integer_atoi
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
public class LC8_string_to_integer_atoi {
    class SolutionSelfWrong {
        public int myAtoi(String s) {

            long num=0;
            boolean numFlag=false;
            boolean frontSpaceFinish=false;
            boolean signFinded=false;
            int sign = +1;

            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(signFinded&&!(c>='0'&&c<='9')){
                    return 0;
                }
                System.out.println(c);
                if(c==' '&&!frontSpaceFinish&&!numFlag){
                    System.out.println("case 1");
                    continue;
                }else if(c=='+'){
                    // if(signFinded){
                    //     return 0;
                    // }
                    frontSpaceFinish=true;

                    signFinded=true;
                    //num = num*1;
                    System.out.println("case 2");
                    continue;
                }else if(c=='-'){
                    // if(signFinded){
                    //     return 0;
                    // }
                    frontSpaceFinish=true;
                    signFinded=true;
                    // num=num*-1;
                    sign=-1;
                    System.out.println("case 3");
                }else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||c=='.'||c==' '){
                    System.out.println("case 4");
                    // if(numFlag){
                    //     return 0;
                    // }
                    break;

                }else if(c>='0'&&c<='9'){
                    signFinded=true;
                    System.out.println("case 5");
                    numFlag=true;
                    num=10*num+(c-'0')*sign;

                    if(num>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }else if(num<Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
                System.out.println("###");

            }
            //num=num*sign;
            System.out.println("###"+num);

            return Integer.valueOf(String.valueOf(num));
        }
    }

    class SolutionSelf2ms {
        public int myAtoi(String s) {
            int n=s.length();
            int sign=1;
            long num=0;
            int i=0;
            //排除空格
            while (i<n&&s.charAt(i)==' ') {
                i++;
            }
            if(i<n&&s.charAt(i)=='+'){
                i++;
            }else if(i<n&&s.charAt(i)=='-'){
                sign=-1;
                i++;
            }
            while(i<n&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                // System.out.println(s.charAt(i));
                num=num*10+(s.charAt(i)-'0')*sign;
                if(num>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(num<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                i++;
            }
            return Integer.valueOf(String.valueOf(num));
        }
    }

    //这题吧，主要考察细心程度，没啥技术含量，就是考察细心！而我为了匹配各种情况，调试了好久最后放弃，改用labuladong思路，这题。。。可以考虑不再练习
    class SolutionLabuladong {
        public int myAtoi(String s) {
            int n=s.length();
            int sign=1;
            long num=0;
            int i=0;
            //排除空格
            while (i<n&&s.charAt(i)==' ') {
                i++;
            }
            if(i==n){
                return 0;
            }
            if(i<n&&s.charAt(i)=='+'){
                i++;
            }else if(i<n&&s.charAt(i)=='-'){
                sign=-1;
                i++;
            }
            if(i==n){
                return 0;
            }
            while(i<n&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                // System.out.println(s.charAt(i));
                // num=num*10+(s.charAt(i)-'0')*sign;
                num=num*10+(s.charAt(i)-'0');
                // if(num>Integer.MAX_VALUE){
                //     return Integer.MAX_VALUE;
                // }else if(num<Integer.MIN_VALUE){
                //     return Integer.MIN_VALUE;
                // }
                if(num>Integer.MAX_VALUE){
                    break;
                }
                i++;
            }
            //实验证明下面这个转换比较耗时，也不难发现，毕竟转了两次。弄成强转会省时一些
            //return Integer.valueOf(String.valueOf(num));
            if((int) num!=num){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            // return (int) num * sign*sign;
            return (int) num * sign;
        }
    }
}