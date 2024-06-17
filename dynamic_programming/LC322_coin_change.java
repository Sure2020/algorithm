/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC322_coin_change
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

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-27
 **/
public class LC322_coin_change {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Solution20240419 solution20240419 = new Solution20240419();
        System.out.println(solution20240419.coinChange(coins, 11));
        /*System.out.println(coinChange3(coins, 11));

        coins = new int[]{2};
        System.out.println(coinChange3(coins, 3));

        coins = new int[]{1};
        System.out.println(coinChange3(coins, 0));*/

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subResult = coinChange(coins, amount - coin);
            if (subResult == -1) {
                continue;
            }
            result = Math.min(result, subResult + 1);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] num = new int[amount + 1];
        return coinChange2(num, coins, amount);
    }

    public static int coinChange2(int[] num, int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (num[amount] != 0) {
            return num[amount];
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subResult = coinChange2(num, coins, amount - coin);
            if (subResult == -1) {
                continue;
            }
            num[amount] = Math.min(result, subResult + 1);
        }
        return num[amount] == 0 ? -1 : num[amount];
    }

    public static int coinChange3(int[] coins, int amount) {
        int[] num = new int[amount + 1];
        Arrays.fill(num, amount + 999);
        //base case
        num[0] = 0;
        for (int i = 0; i < num.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                num[i] = Math.min(num[i], num[i - coin] + 1);
            }
        }
        return num[amount] == (amount + 999) ? -1 : num[amount];
    }
    class Solution20240418 {
        public int coinChange(int[] coins, int amount) {
            int[] dp  = new int[amount+1];
            //试了把dp用一个不可能的值填满，没太大必要，运行时间是26ms，还多了1ms。但学到了Arrays.fill方法。
            //Arrays.fill(dp, -666);
            return dp(coins, amount, dp);
        }

        public int dp(int[] coins, int amount, int[] dp) {
            //base case
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(dp[amount]!=0){
                return dp[amount];
            }
            //这里不能用-1，虽然-1也是一个不可能的值，但题目求的是最小值，所以res的初始值要用一个很大的值
            //再次注意，这个res的职责是统计当前层的结果，并在最后返回。不能放到dp函数外面
            int res=Integer.MAX_VALUE;//-1;//Integer.MAX_VALUE;
            for(int i=0;i<coins.length;i++){
                int subProblem = dp(coins, amount-coins[i], dp);
                // 此次无解，跳过
                if(subProblem==-1){
                    continue;
                }
                res = Math.min(res, subProblem + 1);
            }
            dp[amount] = res == Integer.MAX_VALUE ? -1 : res;
            return dp[amount];
        }
    }
    //自底向上的DP时间快很多25ms->13ms
    static class Solution20240419 {
        int[] count;
        public int coinChange(int[] coins, int amount) {
            //比如amount是11，那么count[11]的数组长度其实是12，所以这里要+1
            count = new int[amount + 1];
            //为了标记当前amount的最小值还没算出，这里用一个不可能的较大值填充。不能用Integer.MAX_VALUE，不然后面的count[i-coins]会溢出
            Arrays.fill(count, amount+666);
            count[0]=0;
            return dp(coins, amount);
        }

        //dp定义：返回count(amount)的最少硬币数
        public int dp(int[] coins, int amount){
            //每个amount的数值都遍历一遍，自底向上算出最终的dp(amount)
            //这里落下了i=amount的边界，调试了好几次，被自己蠢哭了！写代码要边写边想啊，弄清楚每一步要干嘛，细节决定成败啊
            for(int i=0;i<=amount;i++){
                //开始尝试用每个硬币的面额去计算最小个数
                for(int coin : coins){
                    //
                    if(i-coin<0){
                        continue;
                    }
                    count[i] = Math.min(count[i], 1+count[i-coin]);
                }
            }
            return count[amount]==amount+666?-1:count[amount];
        }
    }

    class Solution20240617 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp,amount+678);
            //忘了base case;
            dp[0]=0;
            //dp[1]=1;
            //为啥从0开始，因为如果从1开始，需要amount为1，则dp的大小为2，这不现实
            for(int i=0;i<=amount;i++){
                for(int coin:coins){
                    if(i-coin<0){
                        continue;
                    }
                    //写成这样比较好理解
                    if(dp[i-coin]+1<amount+678){
                        dp[i]=dp[i-coin]+1;
                    }
                    //dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount]==amount+678)?-1:dp[amount];
        }
    }
//用自底向上，因为性能好
}