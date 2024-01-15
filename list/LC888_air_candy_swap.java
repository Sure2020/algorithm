/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC888_air_candy_swap
 * Date Created : 2024-01-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-15       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-15
 **/
public class LC888_air_candy_swap {
    public static void main(String[] args) {
        int[] aliceSizes = new int[]{1,1};
        int[] bobSizes = new int[]{2,2};
        fairCandySwap(aliceSizes, bobSizes);
    }
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum=0;
        for(int i = 0;i<aliceSizes.length;i++){
            aliceSum+=aliceSizes[i];
        }
        for(int j = 0;j<bobSizes.length;j++){
            bobSum+=bobSizes[j];
        }
        // int difference = aliceSum-bobSum;

        // int aliceIndex=0,bobIndex=0;
        // Array.sort(aliceSizes);
        // Array.sort(bobSizes);
        // while(difference!=0){
        //     aliceSizes[aliceIndex]
        // }
        int aliceIndex=0,bobIndex=0;
        for(aliceIndex = 0;aliceIndex<aliceSizes.length;aliceIndex++){
            for(bobIndex=0; bobIndex<bobSizes.length;bobIndex++){
                if ( (aliceSum-aliceSizes[aliceIndex]+bobSizes[bobIndex]) == (bobSum-bobSizes[bobIndex]+aliceSizes[aliceIndex]) ){
                    return new int[]{aliceSizes[aliceIndex], bobSizes[bobIndex]};
                }
            }
        }
        return new int[]{-1,-1};

    }
}