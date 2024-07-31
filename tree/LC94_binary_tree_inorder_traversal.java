/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC94_binary_tree_inorder_traversal
 * Date Created : 2024-03-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-10       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-10
 **/
public class LC94_binary_tree_inorder_traversal {
    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            traverse(root);
            return result;
        }
        public void traverse(TreeNode root){
            if(root == null){
                return;
            }
            traverse(root.left);
            result.add(root.val);
            traverse(root.right);
        }
    }

    class Solution20240310 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }

    //哈哈
    class Solution20240529 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }

    //来
    class Solution20240604 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }

    class Solution20240701 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }
    }

    class Solution20240731 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {

            if(root==null){
                return result;
            }
            // result.add(root.val);
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);

            return result;
        }
    }
//竟然卡了一小会儿。。。原因是没有把result变量放在函数外面
}