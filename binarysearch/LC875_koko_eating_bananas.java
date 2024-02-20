/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC875_koko_eating_bananas
 * Date Created : 2024-02-20
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-20       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这道题是二分的变体应用，很有讲究，难度不小，需要多加练习，具体看注释吧
 * @author: Admin
 * @create: 2024-02-20
 **/
public class LC875_koko_eating_bananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //1.left最小从1开始而不是0，0的话会造成除0异常
            int left=1,right=1000000000,mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                //需要让speed大一点
                if(needHours(piles, mid)>h){
                    left=mid+1;

                }
                //需要左边界，让speed小一些
                else if (needHours(piles, mid)<=h){
                    right=mid-1;
                }
                //需要让speed小一点
                // 3.思路理清楚后，就合并重复的分支，能提升代码性能
                // else if (needHours(piles, mid)<h) {
                //     right=mid-1;
                // }
            }
            return left;
        }
        /*
        2.为什么 f(x) 的返回值是 long 类型？因为你注意题目给的数据范围和 f 函数的逻辑。piles 数组中元素的最大值是 10^9，最多有 10^4 个元素；那么当 x 取值为 1 时，hours 变量就会被加到 10^13 这个数量级，超过了 int 类型的最大值（大概 2x10^9 这个量级），所以这里用 long 类型避免可能出现的整型溢出
         */
        public long needHours(int[] piles, int speed){
            int length = piles.length;
            long hours = 0;
            for (int i = 0; i < length; i++) {
                hours+=piles[i]/speed;
                if(piles[i]%speed>0){
                    hours++;
                }
            }

            return hours;
        }
    }
}