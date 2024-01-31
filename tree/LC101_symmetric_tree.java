/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC101_symmetric_tree
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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-31
 **/
class LC101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p1, TreeNode p2){
        if(p1==null&&p2==null){
            return true;
        }
        if(p1==null||p2==null){
            return false;
        }
        if(p1.val!=p2.val){
            return false;
        }else{
            return check(p1.left, p2.right)&&check(p1.right,p2.left);
        }

    }
    public boolean check2(TreeNode p1, TreeNode p2){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(p1);
        q.offer(p2);
        while(!q.isEmpty()){
            p1 = q.poll();
            p2 = q.poll();
            if(p1==null&&p2==null){
                continue;
            }
            if((p1==null||p2==null)  || p1.val!=p2.val){
                return false;
            }
            q.offer(p1.left);
            q.offer(p2.right);

            q.offer(p1.right);
            q.offer(p2.left);
        }
        return true;

    }
}