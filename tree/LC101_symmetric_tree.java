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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    //想当然地用到了层序遍历的方法，结果无法通过镜像对称的测试用例，切记别再掉到坑里
    class SolutionSelfWrong {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> tempList = new ArrayList<>();
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    tempList.add(tempNode.val);
                    //
                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                }
                if(!isSame(tempList)){
                    return false;
                }
            }
            return true;
        }

        public boolean isSame (List<Integer> list){
            if(list==null){
                return true;
            }
            int size = list.size();
            if(size==1){
                return true;
            }
            for(int i=0,j=size-1; i<=j; i++,j--){
                if(list.get(i) != list.get(j)){
                    return false;
                }
            }
            return true;
        }
    }

    class Solution20240313 {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }
        public boolean check (TreeNode nodeA, TreeNode nodeB){
            if(nodeA ==null &&nodeB==null){
                return true;
            }
            if(nodeA==null||nodeB==null){
                return false;
            }
            return nodeA.val==nodeB.val && check(nodeA.left, nodeB.right) && check(nodeA.right, nodeB.left);
        }

    }
}