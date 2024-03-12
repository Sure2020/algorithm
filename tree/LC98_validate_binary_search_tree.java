/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC98_validate_binary_search_tree
 * Date Created : 2024-02-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题是看了labuladong的解释后才默写的，结果还是犯错了，注意最后return时的min或max参数
 * 这题有一定的技巧性，需要将最小值或最大值通过参数向下传递
 * @author: Admin
 * @create: 2024-02-11
 **/
public class LC98_validate_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root =Tools.treeCreater(new int[]{5,4,6,-1,-1,3,7});
        Tools.treePrettyPrinter(root);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
    static class Solution_wrong {
        public boolean isValidBST(TreeNode root) {
            return judge(root, null, null);
        }
        public boolean judge(TreeNode root, TreeNode min, TreeNode max){
            if(root ==null){
                return true;
            }
            if(min!=null && root.val <=min.val){
                return false;
            }
            if(max!=null&&root.val>=max.val){
                return false;
            }
            //注意这里的两个null是错的
            return judge(root.left, null, root)&&judge(root.right,root, null);
        }
    }
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return judge(root, null, null);
        }
        public boolean judge(TreeNode root, TreeNode min, TreeNode max){
            if(root ==null){
                return true;
            }
            if(min!=null && root.val <=min.val){
                return false;
            }
            if(max!=null&&root.val>=max.val){
                return false;
            }
            boolean left = judge(root.left,min, root);
            boolean right = judge(root.right, root,max);
            return left && right;
        }
    }

    class Solution20240312SelfWrong {
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }
            if(root.left==null && root.right==null){
                return true;
            }
            boolean leftFlag = true;
            boolean rightFlag = true;
            if(root.left!=null){
                if(root.val<=root.left.val){
                    //leftFlag=false;
                    return false;
                }
            }
            if(root.right!=null){
                if(root.val>=root.right.val){
                    //rightFlag=false;
                    return false;
                }
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
    class Solution20240312 {
        public boolean isValidBST(TreeNode root) {
            return judge(root, null, null);
        }
        public boolean judge(TreeNode root, TreeNode min, TreeNode max){
            if(root==null){
                return true;
            }
            if(min!=null && root.val<=min.val){
                return false;
            }
            if(max!=null &&root.val>=max.val){
                return false;
            }
            return judge(root.left, min, root) &&judge(root.right,root,max);
        }
    }
}