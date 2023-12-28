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
        System.out.println(coinChange3(coins, 11));

        coins = new int[]{2};
        System.out.println(coinChange3(coins, 3));

        coins = new int[]{1};
        System.out.println(coinChange3(coins, 0));

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
}