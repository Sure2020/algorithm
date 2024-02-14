/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1372_longest_zigzag_path_in_a_binary_tree
 * Date Created : 2024-02-14
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-14       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * 直接学的labuladong的思路，关键在于对dfs函数的定义：
 * 1、x 的左子树的「右交错路径」+ 节点 x = x 的「左交错路径」
 * 2、x 的右子树的「左交错路径」+ 节点 x = x 的「右交错路径」
 * @create: 2024-02-14
 **/
public class LC1372_longest_zigzag_path_in_a_binary_tree {
    class Solution {
        public int longestZigZag(TreeNode root) {
            dfs(root);
            return res;
        }
        int res = 0;
        public int[] dfs(TreeNode root){
            if(root==null){
                return new int[]{-1,-1};
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
        /*
        这样的话，一个节点 x 能够产生的交错路径就能分解到左右子树：

1、x 的左子树的「右交错路径」+ 节点 x = x 的「左交错路径」

2、x 的右子树的「左交错路径」+ 节点 x = x 的「右交错路径」
        */
            int len1= left[1]+1;
            int len2 = right[0]+1;
            res = Math.max(res,Math.max(len1,len2));
            return new int[]{len1,len2};
        }
    }
}