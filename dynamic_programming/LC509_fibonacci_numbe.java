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
}