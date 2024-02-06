/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR145_dui_cheng_de_er_cha_shu_lcof
 * Date Created : 2024-02-07
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-07       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-07
 **/
public class LCR145_dui_cheng_de_er_cha_shu_lcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(8);
        System.out.println(solution.checkSymmetricTree(root));
    }
    static class Solution {
        public boolean checkSymmetricTree(TreeNode root) {
            return judge(root.left,root.right);
        }
        public boolean judge(TreeNode root1, TreeNode root2){
            if(root1==null&&root2==null){
                return true;
            }
            if(root1!=null&&root2==null){
                return false;
            }
            if(root1==null&&root2!=null){
                return false;
            }
            if(root1.val != root2.val){
                return false;
            }
            //这道题又是差点独立完成。看被注释掉的部分，太急于返回true了。返回true的条件是所有子树都对称，所以需要递归，而只需发现不对称即可立马返回false
            /*if(root1.val==root2.val){
                return true;
            }*/
            return judge(root1.left, root2.right) && judge(root1.right,root2.left);
        }
    }
}