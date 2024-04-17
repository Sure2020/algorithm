/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC509_fibonacci_numbe
 * Date Created : 2023-12-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-27       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-27
 **/
public class LC509_fibonacci_numbe {

    public static void main(String[] args) {
        System.out.println(fib4(7));
    }

    // #########################################
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // #########################################
    public static int fib2(int n) {
        int[] num = new int[n + 1];
        return fib2(num, n);

    }

    public static int fib2(int[] num, int n) {
        if (n == 0 || n == 1) {
            num[n] = n;
            return n;
        }
        if (num[n] != 0) {
            return num[n];
        }
        num[n] = fib2(num, n - 1) + fib2(num, n - 2);
        return num[n];
    }

    // #########################################
    public static int fib3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // #########################################
    public static int fib4(int n){
        if (n==0||n==1){
            return n;
        }
        int tempa=0;
        int tempb=1;
        int result = 0;
        for (int i = 2;i<=n;i++){
            result = tempa+tempb;
            tempa=tempb;
            tempb=result;
        }
        return result;
    }
    class Solution20240417 {

        public int fib1(int n) {
            //暴力
            if(n==1||n==0){
                return n;
            }
            return fib1(n-1) + fib1(n-2);

        }

        Map<Integer,Integer> map = new HashMap<>();
        Solution20240417(){
            map.put(0,0);
            map.put(1,1);
        }
        //自顶向下
        public int fib2(int n) {
            if(map.containsKey(n)){
                return map.get(n);
            }
            map.put(n, fib2(n-1) + fib2(n-2));
            return map.get(n);
        }

        //自底向上
        public int fib3(int n) {
            int[] dp = new int[n+1];
            if(n == 0 || n==1){
                return n;
            }
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
        //降低空间复杂度
        public int fib(int n) {
            if(n == 0 || n==1){
                return n;
            }
            int dp1=0;
            int dp2=1;
            int res=0;
            for(int i=2;i<=n;i++){
                res= dp1+dp2;
                dp1=dp2;
                dp2=res;
            }
            return res;
        }
    }
}