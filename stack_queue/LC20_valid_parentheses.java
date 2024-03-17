/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC20_valid_parentheses
 * Date Created : 2024-03-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-17       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-17
 **/
public class LC20_valid_parentheses {
    //1.这题虽然简单，但自己仍然折腾了有一个小时2.把map的地方改成if语句，执行时间竟然可以缩短1s
    class Solution {
        public boolean isValid(String s) {
            // Map<Character, Character> map = new HashMap();
            // map.put(')', '(');
            // map.put(']', '[');
            // map.put('}', '{');
            Stack<Character> stack = new Stack<>();
            // for(int i=0;i<s.length();i++){
            for(char currentChar: s.toCharArray()){
                //char currentChar = s.charAt(i);
                //if(")]}".contains(String.copyValueOf(new char[]{currentChar}))){
                //if(map.containsKey(currentChar)){
                if(')'==currentChar || ']'==currentChar||'}'==currentChar){
                    if(stack.empty()){
                        stack.push(currentChar);
                    }
                    else if (stack.pop()!=leftOf(currentChar)){
                        return false;
                    }
                    //stack.pop();
                }else {
                    stack.push(currentChar);
                }
            }

            return stack.empty();
        }
        public char leftOf(char c){
            if(')'==c){
                return '(';
            }else if(']'==c){
                return '[';
            }else{
                return '{';
            }
        }
    }
}