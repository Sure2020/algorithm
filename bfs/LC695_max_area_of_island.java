/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC695_max_area_of_island
 * Date Created : 2024-04-01
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-01       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-01
 **/
public class LC695_max_area_of_island {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(solution.maxAreaOfIsland(grid));
    }
    static class Solution {
        int result = 0;
        int currentArea=0;
        int m = 0;
        int n = 0;
        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dfs(grid, i, j);
                    //处理此次结果并把临时和置为0的时机，很重要，一开始写到了dfs里面，看测试用例1，当遍历完5.10这个节点时，临时和就会被置为空，最终统计到错误的结果。
                    //要注意，上下左右已遍历完，只能代表当前节点已处理完，并不能代表当前岛屿已处理完！
                    //还是要纪念一下，毕竟是自己独立想出来的思路，记忆和复写成本更低。虽然比不上labuladong的简洁，但思路大同小异，都是类似200题
                    result = Math.max(result, currentArea);
                    currentArea=0;
                }
            }
            return result;
        }
        public void dfs(int[][] grid, int i, int j){
            // System.out.println(i+"#"+j);
            // if(i==8&&j==3){
            //     System.out.println("find");
            // }
            if(i<0||j<0||i>=m||j>=n){
                return;
            }
            if(grid[i][j]==0){
                return;
            }else if(grid[i][j]==1){
                currentArea+=1;
                grid[i][j]=0;
            }
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
            // result = Math.max(result, currentArea);
            // currentArea=0;
        }
    }
}