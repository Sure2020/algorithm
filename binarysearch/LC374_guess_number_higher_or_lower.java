/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC374_guess_number_higher_or_lower
 * Date Created : 2024-02-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-17       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 又一个独立完成，且一次成功的题，值得纪念
 * @author: Admin
 * @create: 2024-02-17
 **/
public class LC374_guess_number_higher_or_lower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */

    public class Solution /*extends GuessGame*/ {
        public int guessNumber(int n) {
            return chose(1,n);
        }
        public int chose(int left, int right){
            int mid = left+(right-left)/2;
            int guessFlag = 0;//guess(mid);
            if(guessFlag==-1){
                right = mid-1;
            }
            if(guessFlag==1){
                left = mid+1;
            }
            if(guessFlag==0){
                return mid;
            }
            return chose(left, right);
        }
    }
}