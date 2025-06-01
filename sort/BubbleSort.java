/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : BubbleSort
 * Date Created : 2025-06-01
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2025-06-01       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2025-06-01
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};

        BubbleSort.bubbleSort3(arr, arr.length);

        for(int i:arr){
            System.out.print(i+",");
        }
    }
    public static void bubbleSort1(int[] arr, int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr, int n){
        boolean hasSwapped = false;
        for(int i=0;i<n;i++){
            hasSwapped=false;
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    hasSwapped=true;
                }
            }
            if (!hasSwapped) {
                return;
            }
        }
    }
    public static void bubbleSort3(int[] arr, int n){
        boolean hasSwapped = true;
        int pos = 0;
        int k = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    hasSwapped=true;
                    pos = j;
                }
            }
            k=pos;
            if(!hasSwapped){
                return;
            }
        }
    }
}