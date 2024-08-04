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

    class Solution20240804 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null || q==null){
                return p==q;
            }
            if(p!=null && q!=null && p.val != q.val){
                return false;
            }
            // if(p.left!=null && p.right!=null && q.left!=null && q.right!=null && p.left.val==q.left.val && p.right.val==q.right.val){
            //     return true;
            // }
            if(p!=null &&p.left==null && p.right==null && q!=null && q.left==null && q.right==null && p.val==q.val){
                return true;
            }

            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
//比较两树左节点，再比较两树右节点
//看了眼以前的提交记录，想复杂了，还是重来吧
//事后：其实在判断何时返回true时，过于谨慎了，只要写清楚了返回false的条件。最后能成功走到p==q==null这个条件，已经可以说明上面的都相等
}