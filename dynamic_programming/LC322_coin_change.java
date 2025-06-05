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
                    //不能写成这样，要跟dp[i]比较，比如有coin[2,1]，amount为2，dp[2]最终值为错误的2，而不是正确的1
                    // if(dp[i-coin]+1<amount+678){
                    //     dp[i]=dp[i-coin]+1;
                    // }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount]==amount+678)?-1:dp[amount];
        }
    }
//用自底向上，因为性能好

    class Solution20240708 {

        //来个备忘录：
        int[] dp = new int[10000];
        public int coinChange(int[] coins, int amount) {
            Arrays.fill(dp,-666);
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount){
            //System.out.println("amount: " + amount);
            if(amount<0){
                return -1;
            }
            if(amount==0){
                return 0;
            }
            if(dp[amount]!=-666){
                return dp[amount];
            }

            int result = Integer.MAX_VALUE;
            for(int i=0;i<coins.length;i++){
                int coin =coins[i];
                //System.out.println("coin: " + coin);
                int currentN = coinChange(coins, amount-coin);
                //System.out.println("currentN: " + currentN + " amount-coin: " + (amount-coin));
                if(currentN==-1){
                    //没有，就跳过此次尝试
                    continue;
                }
                //挑战最小值
                result = (currentN + 1)<result?(currentN+1):result;
                //result = Math.min(currentN+1, result);
                dp[amount]=result;
            }
            return result==Integer.MAX_VALUE?-1:result;
            //return result;
        }
    }
//递归，分解的思路吧，求amount-n的最少硬币个数+1，
//一次失败的尝试，时间跨度太大，最后放弃
//两处失误，一个是没搞清楚base case，amount<0要返回-1,amount==0要返回0;另一个是，返回结果时要判断要不要返回-1
//其实太遗憾了，仅仅差一步之遥，就是忘了一个base case，遗憾了


    class Solution20250525 {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount+1];
            Arrays.fill(memo, -888);

            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount){
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(memo[amount]!=-888){
                return memo[amount];
            }
            int result = Integer.MAX_VALUE;
            for(int coin:coins){
                int subProblem = dp(coins, amount-coin);
                if(subProblem==-1){
                    continue;
                }
                // 这里要取两者的最小值，用min
                result = Math.min(result, subProblem+1);
            }
            // 根据题意，没有就返回-1
            memo[amount] = result==Integer.MAX_VALUE?-1:result;
            return memo[amount];
        }
    }

    class Solution20250525v2 {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo=new int[amount+1];
            Arrays.fill(memo, -999);
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount){
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(memo[amount]!=-999){
                return memo[amount];
            }
            int tempResult = Integer.MAX_VALUE;
            for(int coin:coins){
                int subProblem = dp(coins, amount-coin);
                if(subProblem==-1){
                    continue;
                }
                tempResult = Math.min(tempResult, subProblem+1);
            }
            memo[amount] = tempResult==Integer.MAX_VALUE?-1:tempResult;
            return memo[amount];
        }
    }

    class Solution20250601 {

        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount+1];
            Arrays.fill(memo, -999);
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount){
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(memo[amount]!=-999){
                return memo[amount];
            }
            // result只对当前递归生效
            // result默认取最大值，因为要求最小值
            int result = Integer.MAX_VALUE;
            for(int coin: coins){
                int subProblem = dp(coins, amount-coin);
                if(subProblem==-1){
                    continue;
                }
                result = Math.min(result, subProblem+1);
            }
            memo[amount]=result==Integer.MAX_VALUE?-1:result;
            return memo[amount];
        }
    }

    class Solution20250605 {
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount+1];
            Arrays.fill(memo, -999);
            return dp(coins, amount);
        }
        public int dp(int[] coins, int amount){
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(memo[amount]!=-999){
                return memo[amount];
            }
            int result = Integer.MAX_VALUE;
            for(int coin:coins){
                int subProblem = dp(coins, amount-coin);
                if(subProblem==-1){
                    continue;
                }
                result = Math.min(result, subProblem+1);
            }
            memo[amount] = result==Integer.MAX_VALUE?-1:result;
            return memo[amount];
        }
    }

}