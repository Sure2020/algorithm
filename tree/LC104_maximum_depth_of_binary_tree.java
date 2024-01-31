/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC104_maximum_depth_of_binary_tree
 * Date Created : 2023-10-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-27       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-27
 **/
public class LC104_maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);

        //System.out.println(maxDepth(root));
        System.out.println(recurse(root));

        res=0;

        System.out.println("case2");
        TreeNode tempNode2 = new TreeNode();
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        //System.out.println(maxDepth(root2));
        System.out.println(recurse(root2));

    }
    // 记录最大深度
    static int res = 0;
    // 记录遍历到的节点的深度
    static int depth = 0;

    // 主函数
    static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    static int recurse(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = recurse(root.left);
        int right = recurse(root.right);
        return Math.max(left, right)+1;
    }

    // BFS
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i< size; i++){
                TreeNode currentNode = q.poll();
                if(currentNode.left == null&& currentNode.right==null){
                    return depth;
                }
                if(currentNode.left!=null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.offer(currentNode.right);
                }

            }
            depth ++;
        }
        return depth;
    }
}