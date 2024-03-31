/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC200_number_of_islands
 * Date Created : 2024-03-31
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-31       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这个感觉挺难实则有点意思，多亏了labuladong的诙谐幽默的注释，让我重拾信心，嘿嘿。。
 * @author: Admin
 * @create: 2024-03-31
 **/
public class LC200_number_of_islands {
    class Solution {
        int m=0,n=0;
        public int numIslands(char[][] grid) {
            int result = 0;
            m = grid.length;
            n = grid[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]=='1'){
                        //找到岛屿则结果+1
                        result ++;
                    }
                    //将与之相邻的都填海，变成海水
                    dfs(grid, i,j);
                }
            }
            return result;
        }
        public void dfs(char[][] grid, int i, int j){
            //base case
            //因为m和n都是取的length而不是length-1，所以这里要用>=
            if(i<0||j<0||i>=m||j>=n){
                //搜索到边界
                return;
            }
            if(grid[i][j]=='0'){
                //已经是海水
                return;
            }
            //变为海水
            grid[i][j]='0';
            //上下左右递归
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}