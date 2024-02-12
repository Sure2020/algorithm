/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1448_count_good_nodes_in_binary_tree
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
public class LC1448_count_good_nodes_in_binary_tree {
    //我太牛了，独立完成，只改了一次就通过了
    class Solution {
        int result = 0;
        public int goodNodes(TreeNode root) {
            dfs(root,root.val);
            return result;
        }
        public void dfs(TreeNode root, int currentMax){
            if(root==null){
                return;
            }
            if(root.val>=currentMax){
                result++;
                currentMax=root.val;
            }
            dfs(root.left,currentMax);
            dfs(root.right,currentMax);
        }
    }
}