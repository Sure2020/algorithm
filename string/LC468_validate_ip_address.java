/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC468_validate_ip_address
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
public class LC468_validate_ip_address {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String ip = "172.16.254.1";
        System.out.println(ip.split("\\.").length);
        System.out.println("2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":").length);
        //System.out.println(solution.validIPAddress(ip));
    }
    //感觉官解也没什么厉害的地方，所以就保持自己这个解法吧，记忆成本低，就是很多细节依赖调试才能补充完整
    static class Solution {
        public String validIPAddress(String queryIP) {
            String Neither = "Neither";
            String IPv4 = "IPv4";
            String IPv6 = "IPv6";
            int length = queryIP.length();
            if(length==0){
                return Neither;
            }
            String[] list = null;
            if(queryIP.contains(".")){
                if(queryIP.startsWith(".") || queryIP.endsWith(".")){
                    return Neither;
                }
                list = queryIP.split("\\.");
                if(list.length!=4){
                    return Neither;
                }
                for(String item:list){
                    if(!isValidIPv4Part(item)){
                        return Neither;
                    }
                }
                return IPv4;
            }else if(queryIP.contains(":")){
                if(queryIP.startsWith(":") || queryIP.endsWith(":")){
                    return Neither;
                }
                list = queryIP.split(":");
                if(list.length!=8){
                    return Neither;
                }
                for(String item:list){
                    if(!isValidIPv6Part(item)){
                        return Neither;
                    }
                }
                return IPv6;
            }else{
                return Neither;
            }
            // return Neither;
        }
        public boolean isValidIPv4Part(String s){
            if(s.length()==0){
                return false;
            }
            if(s.length()!=1&&s.charAt(0)=='0'){
                return false;
            }
            int num=0;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c<'0'||c>'9'){
                    return false;
                }
                num=num*10+(c-'0');
            }
            if(num<0||num>255){
                return false;
            }
            return true;
        }
        public boolean isValidIPv6Part(String s){
            int length=s.length();
            if(length<1||length>4){
                return false;
            }
            for(int i=0;i<length;i++){
                char c = s.charAt(i);
                if(!(c>='a'&&c<='f') && !(c>='A'&&c<='F') && !(c>='0'&&c<='9')){
                    return false;
                }
            }
            return true;
        }
    }
}