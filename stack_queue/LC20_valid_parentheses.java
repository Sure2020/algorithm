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

    class Solution20241127 {
        public boolean isValid(String s) {
            int length = s.length();
            if(length<=1){
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<length;i++){
                char c = s.charAt(i);
                //System.out.println("current char: " + c);
                //遇到左括号，入栈
                //这里挺遗憾的，错把{写成了}，调试了一会儿。细心很重要哇，写的时候不要急。
                if(c=='(' || c=='[' || c=='{'){
                    stack.push(c);
                }
                //遇到右括号，开始判断是否有匹配的左括号。
                else{
                    // if(!stack.isEmpty()){
                    //     System.out.println("left of: " + leftOf(c));
                    //     System.out.println("peek: " + stack.peek());
                    // }

                    if(!stack.isEmpty() && leftOf(c)==stack.peek()){
                        //匹配上了，就弹出，证明这一组括号没问题，以后不用关注
                        stack.pop();
                    }else{
                        // if(stack.isEmpty()){
                        //     System.out.println("stack is empty");
                        //     return false;
                        // }
                        //System.out.println("left of: " + leftOf(c));
                        //System.out.println("peek: " + stack.peek());
                        //没匹配上，直接返回false
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        public char leftOf(char c){
            if(c==')'){
                return '(';
            }else if(c==']'){
                return '[';
            }else if(c=='}'){
                return '{';
            }else {
                return ' ';
            }
        }
    }
//利用栈，先将左括号存起来，当遇到右括号的时候，开始从栈中寻找匹配的左括号

    class Solution20250513 {
        public boolean isValid(String s) {
            if(s==null || s.length()<2){
                return false;
            }
            Stack<Character> stack = new Stack();
            for(int i=0;i<s.length();i++){
                char currentChar = s.charAt(i);
                if(currentChar=='(' || currentChar=='[' || currentChar=='{'){
                    stack.push(currentChar);
                    System.out.println(stack.size());
                }else{
                    char popC = stack.pop();
                    System.out.println(getMatch(currentChar));
                    System.out.println(popC);
                    if(getMatch(currentChar)!=popC){
                        return false;
                    }
                }
            }
            return true;
        }
        public char getMatch(char c){
            if(c==')'){
                return '(';
            }else if(c==']'){
                return '[';
            }else if(c=='}'){
                return '{';
            }
            return 'e';
        }
    }
}