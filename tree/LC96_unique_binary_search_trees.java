/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC96_unique_binary_search_trees
 * Date Created : 2024-02-12
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-12       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-12
 **/
public class LC96_unique_binary_search_trees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(18));
    }
    static class Solution_slow {
        public int numTrees(int n) {
            return count(1,n);
        }
        public int count (int low, int high){

            if(low>high){
                return 1;
            }
            int result = 0;
            //这里是我一开始不理解的地方，为什么要搞个for循环。理由：1到n，每个值都可以作为根节点！
            for(int i=low;i<=high;i++){
                int left = count(low, i-1);
                int right = count(i+1, high);
                result += left*right;
            }
            return result;
        }
    }
    static class Solution {
        int[][] memo;
        public int numTrees(int n) {
            //因为n是从1开始，所以初始化备忘录时，大小要设置为n+1，才会有下标为n的元素
            memo = new int[n+1][n+1];
            return count(1,n);
        }
        public int count (int low, int high){

            if(low>high){
                return 1;
            }
            if(memo[low][high]!=0){
                return memo[low][high];
            }
            int result = 0;
            //这里是我一开始不理解的地方，为什么要搞个for循环。理由：1到n，每个值都可以作为根节点！
            for(int i=low;i<=high;i++){
                int left = count(low, i-1);
                int right = count(i+1, high);
                result += left*right;
                memo[low][high]=result;
            }
            return result;
        }
    }
}