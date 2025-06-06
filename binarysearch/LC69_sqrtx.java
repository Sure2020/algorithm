/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC69_sqrtx
 * Date Created : 2024-03-29
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-29       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 其实看到时间复杂度要求为o(logn)，就应该第一时间想到二分，其实我也想到了，但真正写代码的时候思路跑偏了，淦
 * @author: Admin
 * @create: 2024-03-29
 **/
public class LC69_sqrtx {
    class Solution {
        public int mySqrt(int x) {
            // return (int)Math.sqrt(x);
            //遍历，如果当前i的平方大于x,而i-1的平方小于x，则答案就是x。或者i的平方小于x，而i+1的平方大于x，则x也是答案
            // int half = x/2+1;
            // System.out.println("###"+ half);
            // for(long i=half;i>=0;i--){
            //     //System.out.println("#"+Math.pow(i-1, 2) + "#"+Math.pow(i, 2)+ "#"+Math.pow(i+1, 2));
            //     if(i*i==x){
            //         return (int)i;
            //     }
            //     else if(i*i>x && (i-1)*(i-1)<=x){
            //         return (int)i-1;
            //     }
            //     else if(i*i<x&&(i+1)*(i+1)>x){
            //         return (int)i;
            //     }
            // }
            // return -1;

            //二分查找
            //找k*k<=x的最大的k
            long left=0,right=x;
            long mid=0;
            long max = 0;
            while(left<=right){
                mid = left + (right-left)/2;
                long value = mid * mid;
                if(value==x){
                    return (int)mid;
                }else if(value>x){
                    right = mid-1;
                }else{
                    //mid是当前参与判断的数，而不是left，所以我这里把max和left比是在干嘛？
                    // max = Math.max(max, left);
                    max = mid;
                    left = mid+1;
                }
                //下面是官解，更简洁
                // if(value<=x){
                //     max = mid;
                //     left=mid+1;
                // }else{
                //     right=mid-1;
                // }
            }
            return  (int)max;
        }
    }

    //第一反应是循环遍历，找k*k=x的k值，其实这样和二分查找没半毛钱关系
//思路，找k*k<=x的最大k
    class Solution20240611 {
        public int mySqrt(int x) {
            long left=1,right=x;
            long mid=0;
            while(left<=right){
                mid=(right-left)/2 + left;
                //System.out.println("###  " + mid);
                if(mid * mid<x){

                    left=mid+1;
                }else if(mid*mid==x){
                    return (int)mid;
                }else if(mid*mid>x) {
                    //竟然把这个条件给忘了，然后一直超时
                    right=mid-1;
                }
            }
            if(mid*mid>x){
                return (int) (mid-1);
            }else{
                return (int) mid;
            }
        }
    }

    //小技巧是用一个变量记录当前满足mid*mid<=x的最大值
//注意事项是，要用long变量，否则会溢出
    class Solution202406111056 {
        public int mySqrt(int x) {
            long left=0,right=x;
            long max=-1,mid=-1;
            while(left<=right){
                mid=left+(right-left)/2;
                if(mid*mid<x){
                    max=mid;
                    left=mid+1;
                }else if(mid*mid==x){
                    return (int)mid;
                }else if(mid*mid>x){
                    right=mid-1;
                }
            }
            return (int)max;
        }
    }

    class Solution20240612 {
        public int mySqrt(int x) {
            long left = 1,right=x,mid=0;
            long result = 0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(mid*mid==x){
                    return (int)mid;
                }else if (mid*mid>x){
                    right = mid-1;
                }else if (mid*mid<x){
                    result = mid;
                    left = mid+1;
                }
            }
            return (int)result;
        }
    }
//二分查找，找到k*k<=x的最大k值

    class Solution20240702 {
        public int mySqrt(int x) {
            int k=0;
            int result = 0;
            //从0-x范围内找
            long left=1,right=x,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                //System.out.println("mid: " + mid);
                if(mid*mid==x){
                    return (int)mid;
                }else if(mid*mid>x){
                    right = mid-1;
                }else{
                    left=mid+1;
                    result = (int)mid;
                }
            }
            return (int)result;

        }
    }
//二分查找，找k*k<=x的最大k

    class Solution20240801 {

        public int mySqrt(int x) {
            long left=1,right=x,mid=0;
            int max=0;
            while(left<=right){
                mid = left+(right-left)/2;
                long n = mid*mid;
                //System.out.println("mid: " + mid + " n: " + n + " x: " + x);
                if(n==x){
                    return (int)mid;
                }else if(n>x){
                    //System.out.println("n>x");
                    right = mid-1;
                }else{
                    //System.out.println("n<x");
                    max = (int)mid;
                    left = mid+1;
                }
            }
            return (int)max;
            // double a = 1073697800;
            // double b = a*a;
            // double c = 2147395599;
            // System.out.println("c: " + c + " b: " + b);
            // System.out.println(c>b);
            // return 1;
        }
    }
//二分查找
//事后：不能用double类型，否则小数点会带来麻烦，用long即可

    class Solution20241127 {
        public int mySqrt(int x) {
            int left=0,right=x,mid=0;
            int max=0;
            while(left<=right){
                mid = left+(right-left)/2;
                //System.out.println("mid: " + mid);
                //mid*mid后这里要强转一下成long，否则Int的mid相乘的结果仍然会以int存储，造成溢出
                long temp = (long)mid*mid;
                //System.out.println("temp: " + temp);
                if(temp==x){
                    return (int)mid;
                }else if (temp>x){
                    right = mid-1;
                }else{
                    max = Math.max(max, mid);
                    left = mid+1;
                }
            }
            return max;
        }
    }
//mid*mid后这里要强转一下成long，否则Int的mid相乘的结果仍然会以int存储，造成溢出


    class Solution20250513 {
        public int mySqrt(int x) {
            long left = 0,right=x,mid=0;

            while(left<=right){
                mid = left+(right-left)/2;
                long temp = mid*mid;
                if(temp == x){
                    return (int)mid;
                }
                if(temp<x){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            if(mid*mid>x){
                return (int)(mid-1);
            }else{
                return (int)mid;
            }
        }
    }

    class Solution20250525 {
        public int mySqrt(int x) {
            long left=0,right=x,mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                long temp = mid*mid;
                if(temp==x){
                    return (int)mid;
                }
                if(temp>x){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            if(mid*mid>x){
                return (int)(mid-1);
            }else{
                return (int)mid;
            }
        }
    }
}