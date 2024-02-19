/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC2300_successful_pairs_of_spells_and_potions
 * Date Created : 2024-02-18
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-18       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题给了我惊醒，意识到牢记二分框架代码的重要性。前后断断续续搞了两天终于在原创的基础上搞定了
 * @author: Admin
 * @create: 2024-02-18
 **/
public class LC2300_successful_pairs_of_spells_and_potions {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] a = new int[]{5,1,3};
        int[] b = new int[]{1,2,3,4,5};*/

        int[] a =new int[]{1,2,3,4,5,6,7};
        int[] b = new int[]{1,2,3,4,5,6,7};

        int success = 25;
        Tools.listPriter(solution.successfulPairs(a,b,success));
    }
    static class Solution {
        int[] result = null;
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            result = new int[spells.length];
            bs(spells, potions, success);
            return  result;
        }
        public void bs(int[] spells, int[] potions, long success){
            for (int i = 0; i < spells.length; i++) {
                //1.一开始框架代码用的混乱，这里length-1的话，while条件就要写成left<=right！
                int left=0,right=potions.length-1,mid=0;
                while(left<=right){
                    mid = left+(right-left)/2;
                    if(isSuccess(spells[i], potions[mid], success)){
                        right=mid-1;
                    }else{
                        left = mid+1;
                    }
                }
                System.out.println(left+"###"+right+"###"+mid+"###"+potions.length);
                //2.这里是没找到target时的逻辑，往框架代码上套就是了
                if(left>=potions.length){
                    //left = left+1;
                    result[i]=0;
                }else{
                    result[i]=potions.length-left;
                }


            }
        }
        public boolean isSuccess(int a, int b, long success){
            //3.最坑的是这里，一开始success是long类型时就感觉不妙，果然栽在了这里，记得int相乘要转成long，不然会溢出！
            if (((long)a*b)>=success){
                return true;
            }else{
                return false;
            }
        }
    }
}