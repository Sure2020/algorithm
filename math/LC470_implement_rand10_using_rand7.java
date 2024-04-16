/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC470_implement_rand10_using_rand7
 * Date Created : 2024-04-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-15       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-15
 **/
public class LC470_implement_rand10_using_rand7 {
    //先需要知道这样一个奇怪的知识：(randX()-1) * Y + randY()能等概率得到[1,X*Y]内的数字
    //再注意，b的值要每次重新算，原因暂没研究。。。
    class Solution extends SolBase {
        public int rand10() {
            //得到[1,49]
            while(true){
                int a = rand7();
                int b = rand7();
                int range1_49 = (a-1) * 7 + b;
                if(range1_49<=40){
                    //因为x%10会得到[0-9]，所以后面要加1得到[1-10]
                    return range1_49%10+1;
                }
                //以上，用时6ms
                //[41-49]
                else{
                    a = range1_49 - 40;
                    b = rand7();
                    //[1-63]
                    int range1_63 = (a-1) * 7 + b;
                    if(range1_63<=60){
                        return range1_63 % 10 + 1;
                    }
                    //以上，用时5ms
                    else{
                        a = range1_63 - 60;
                        b = rand7();
                        int range1_21 = (a-1) * 7 + b;
                        if(range1_21<=20){
                            return range1_21 % 10 +1;
                        }
                        //以上，用时5ms
                    }
                }
            }

        }
    }
}