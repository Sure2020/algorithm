/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC100_same_tree
 * Date Created : 2024-01-31
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-31       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-31
 **/
public class LC100_same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    //从LC101过来，这个可以秒了吧
    class Solution20240529 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null || q==null){
                return p==q;
            }
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    class Solution20240718 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null || q==null){
                return p==q;
            }
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
//递归，函数内判断值是否相等，结尾是judge(p.left,q.left) && judge(p.right,q.right);
//判断是否对称时，就是(p.left,q.right)&&(p.right,q.left)
}