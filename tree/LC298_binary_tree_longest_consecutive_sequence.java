/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC298_binary_tree_longest_consecutive_sequence
 * Date Created : 2024-02-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 总结：每个分支独享的变量，用传参的方式传给下一次递归，这样能防止别的分支的干扰。
 * 我一开始是将代表当前长度的变量弄了个全局变量，导致各个分支互相影响
 * @author: Admin
 * @create: 2024-02-06
 **/
public class LC298_binary_tree_longest_consecutive_sequence {
    public static void main(String[] args) {
        SolutionSelf solution = new SolutionSelf();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(4);
        root.right.right.right = new TreeNode(5);
//        Tools.treePrettyPrinter(root);
        System.out.println(solution.longestConsecutive(root));
    }
    static class SolutionSelf {
        int result = 1;
        public int longestConsecutive(TreeNode root) {
            if(root==null){
                return 0;
            }
            traverse(root, 0,root.val-1);
            return result;
        }
        public void traverse(TreeNode root, int currentLength, int parantVal){
            if(root==null){
                return ;
            }
            if(root.val-parantVal==1){
                currentLength++;
                result = Math.max(result, currentLength);
            }else{
                currentLength = 1;
            }
            //System.out.println(root.val);
            traverse(root.left, currentLength, root.val);

            traverse(root.right, currentLength, root.val);
        }
    }
}