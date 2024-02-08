/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC222_count_complete_tree_nodes
 * Date Created : 2024-02-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 将遍历完全二叉树和普通二叉树的方法结合起来
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC222_count_complete_tree_nodes {
    class Solution {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            //注意这里，要从当前节点逐层遍历以获取树的高度，而不是从左子节点或右子节点开始
            //逐层遍历，分别从左右两侧获取高度
            TreeNode point = root;
            //TreeNode left = root.left;
            int leftHeigth = 0;
            while(point !=null){
                leftHeigth++;
                point = point.left;
            }
            point = root;
            //TreeNode right = root.right;
            int rightHeight = 0;
            while(point!=null){
                rightHeight++;
                point = point.right;
            }
            //如果左右两侧的高度一致，说明当前这棵树是完全二叉树，用2的height次方-1的方式即可获取树的节点树
            if(leftHeigth==rightHeight){
                return (int)Math.pow(2,leftHeigth)-1;
            }
            //是普通树，就按普通的方式遍历
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}