/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : Ali_DP
 * Date Created : 2025-05-25
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2025-05-25       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2025-05-25
 **/
import java.util.*;

public class Ali_DP {
    public static boolean canFormString(String str, List<String> dict) {
        // 使用 HashMap 缓存子问题的结果
        Map<String, Boolean> memo = new HashMap<>();
        return canForm(str, dict, memo);
    }

    private static boolean canForm(String s, List<String> dict, Map<String, Boolean> memo) {
        // 如果 s 是空字符串，返回 true
        if (s.isEmpty()) {
            return true;
        }
        // 如果已经计算过 s 的结果，直接返回
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // 遍历字典中的每个字符串
        for (String word : dict) {
            // 如果 s 以 word 开头
            if (s.startsWith(word)) {
                // 递归检查剩余部分
                String remaining = s.substring(word.length());
                if (canForm(remaining, dict, memo)) {
                    memo.put(s, true); // 缓存结果
                    return true;
                }
            }
        }

        // 如果所有 word 都无法匹配，缓存并返回 false
        memo.put(s, false);
        return false;
    }

    static Map<String, Boolean> memo2 = new HashMap<>();
    public static boolean canFormString2(String str, List<String> dict) {
        return canForm2(str,dict);
    }
    public static boolean canForm2(String str, List<String> dict){
        if(str.length()==0){
            return true;
        }
        //把这个给忘了
        if(memo2.containsKey(str)){
            return memo2.get(str);
        }
        for(String word: dict){
            if(str.startsWith(word)){
                String remaining = str.substring(word.length());
                if(canForm2(remaining, dict)){
                    memo2.put(str,true);
                    return true;
                }
            }
        }
        memo2.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(canFormString2(str, dict)); // true

        str = "applepenapple";
        dict = Arrays.asList("apple", "pen");
        System.out.println(canFormString2(str, dict)); // true

        str = "catsandog";
        dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(canFormString2(str, dict)); // false
    }
}