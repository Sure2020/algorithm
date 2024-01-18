/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1539_kth_missing_positive_number
 * Date Created : 2024-01-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-17       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-17
 **/
public class LC1539_kth_missing_positive_number {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,7,11};
        int[] nums2 = new int[]{1,2,3,4};
        System.out.println(findKthPositive_enum(nums, 5));

    }
    public static int findKthPositive(int[] arr, int k) {
        int countK = 0;
        int currentArr = 1;
        int[] missArr = new int[k];
        Set<Integer> arrSet = new HashSet();
        for(int i=0;i<arr.length;i++){
            if(countK>=k){
                break;
            }
            arrSet.add(arr[i]);
            if(!arrSet.contains(currentArr)){
                missArr[countK]=currentArr;
                countK++;
            }
            currentArr++;
        }
        int j = countK;
        while (j<k){
            if(!arrSet.contains(currentArr)){
                missArr[j]=currentArr;
                j++;
            }
            currentArr++;
        }
        return missArr[k-1];
    }

    public static int findKthPositive_enum(int[] arr, int k) {
        int indexK = 1;
        int currentArr = 1;
        int missArr = 0;
        int indexArr = 0;
        while(indexK<=k){
            if (indexArr<arr.length){
                if (arr[indexArr]!=currentArr){
                    missArr = currentArr;
                    indexK ++;
                    currentArr ++;
                }else{
                    indexArr++;
                    currentArr ++;
                }
            } else {
                missArr = currentArr;
                currentArr++;
                indexK++;
            }

        }
        return missArr;
    }

    public static int findKthPositive_binarySearch(int[] arr, int k) {
        return -1;
    }
}