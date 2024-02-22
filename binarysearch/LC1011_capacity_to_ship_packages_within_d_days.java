/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1011_capacity_to_ship_packages_within_d_days
 * Date Created : 2024-02-21
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-21       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-21
 **/
public class LC1011_capacity_to_ship_packages_within_d_days {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] weights = new int[]{1,2,3,1,1};
        //int[] weights = new int[]{3,2,2,4,1,4};
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        //int[] weights = new int[]{500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500};
        //System.out.println(solution.getDays(weights, 6));
        System.out.println(solution.shipWithinDays(weights,5));
    }
    static class Solution {
        public int shipWithinDays(int[] weights, int days) {
            //left的取值不能从1开始，否则会遇到weights[i]>cap的情况，也就是某个包裹超过运载能力，根本无法完成运输。left最小值应该是所有包裹的最大值。
            // right的取值
            //int left=1,right=25000000,mid=0;
            int left=0,right=0,mid=0;
            for (int i = 0; i < weights.length; i++) {
                left=Math.max(left, weights[i]);
                right+=weights[i];
            }
            while(left<=right){
                mid=left+(right-left)/2;
                //System.out.println(left+"###"+right+"###"+mid);
                if (getDays(weights, mid)>days){
                    left=mid+1;
                }else if(getDays(weights, mid)<=days){
                    right=mid-1;
                }/*else if(getDays(weights, mid)<days){
                    right=mid-1;
                }*/
            }
            return left;
        }
        public int getDays (int[] weights, int x){
            int days=0;
            for(int i=0;i<weights.length;){
                int cap = x;
                //System.out.println(cap+"###"+i);
                while(i<weights.length){
                    //System.out.println(cap+"###"+i+"###"+weights[i]);
                    if(weights[i]>cap){
                        break;
                    }else{
                        cap-=weights[i];
                        i++;
                    }
                }
                days++;
            }
            return days;
        }
        public int getDaysSelf(int[] weights, int skill){
            int days=0;
            int currentWeight=0;
            for (int i=0;i<weights.length;i++){
                //装载能力太小时，连一个包裹都装不下，根本无法完成任务，直接返回一个很大的数，
                if(weights[i]>skill){
                    return 50001;
                }
                currentWeight +=weights[i];
                //System.out.println("########   ###"+weights[i]+"###"+currentWeight+"###"+days);
                if(currentWeight<skill){
                    //System.out.println("<   ###"+weights[i]+"###"+currentWeight+"###"+days);
                    continue;//继续装
                } else if (currentWeight==skill) {
                    days++;
                    currentWeight=0;
                    //System.out.println("=   ###"+weights[i]+"###"+currentWeight+"###"+days);
                } else if(currentWeight>skill){
                    i--;
                    //System.out.println("i_____");
                    days++;
                    currentWeight=0;
                    //System.out.println("<   ###"+weights[i]+"###"+currentWeight+"###"+days);
                }
            }
            //最后判断是否还有剩余的包裹，这一步连续忘了两次，需注意
            if(currentWeight>0){
                days++;
            }
            return days;
        }

        //注意每份包裹不能拆开装运！我第一次写这个函数就犯了这个错
        public int getDaysSplit(int[] weights, int skill){
            int days=0;
            int currentWeight=0;
            int reset=0;
            for (int i=0;i<weights.length;i++){
                currentWeight = weights[i]+reset;
                System.out.println(currentWeight+"###"+weights[i]);
                if(currentWeight>skill){
                    days=currentWeight/skill;
                    reset=currentWeight%skill;
                    System.out.println("##>, "+days+"##"+reset);
                }else if(currentWeight==skill){
                    reset =0;
                    days++;
                    System.out.println("##==, "+days+"##"+reset);
                }else if(currentWeight<skill){
                    reset = currentWeight%skill;
                    System.out.println("##<, "+days+"##"+reset);
                }
                System.out.println("###############");
            }
            if(reset!=0){
                days++;
            }
            return days;
        }

    }
}