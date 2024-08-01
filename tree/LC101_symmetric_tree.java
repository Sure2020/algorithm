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

    //思路。。。判断左右子树是否是。
    //但短时间没想出来，直接看答案
    //labuladong说二叉树的递归分为遍历和分解两种，下面是分解，咱曾经也用过遍历的方式，就是BFS遍历出每层节点，再判断是否对称
    class Solution20240529 {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return check(root,root);
        }

        public boolean check(TreeNode left, TreeNode right){
            if(left==null || right==null){
                return left==right;
            }
            if(left.val!=right.val){
                return false;
            }
            //检查子树
            return check(left.left,right.right) && check(left.right, right.left);
        }
    }

    //偷瞄了一眼之前的代码。总之就是分解的思路
    class Solution20240606 {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return false;
            }
            return check(root,root);
        }
        //函数定义:判断两个子树是否对称
        public boolean check (TreeNode root1, TreeNode root2){
            // if(root1==null && root2==null){
            //     return true;
            // }
            // if(root1==null && root2!=null){
            //     return false;
            // }
            // if(root2==null && root1!=null){
            //     return false;
            // }
            // 上面这一堆判断，可以归为一个：有点意思
            if(root1==null || root2==null){
                return root1==root2;
            }
            if(root1.val!=root2.val){
                return false;
            }
            return check(root1.left, root2.right) && check(root2.left, root1.right);
        }
    }

    //接下来用迭代试试，思路就是取出每一层的节点，再判断是否对称，Null的节点补零怎么样
    //事后：不怎么样，看提交记录可以发现自己踩过这个坑，放到list中再判断每层是否对称行不通
    //看了题解各路大神的方法，“默写”如下：
    class Solution20240606Iteration {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return false;
            }
            Queue<TreeNode> queue  = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while(!queue.isEmpty()){
                TreeNode node1=queue.poll();
                TreeNode node2=queue.poll();
                if(node1==null && node2==null){
                    continue;
                }
                if(node1==null || node2==null || (node1.val!=node2.val)){
                    return false;
                }
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node2.left);
                queue.offer(node1.right);
            }
            return true;
        }
    }

    //我靠，竟然给秒了
    class Solution20240710 {
        public boolean isSymmetric(TreeNode root) {
            return judge(root,root);
        }
        public boolean judge(TreeNode node1, TreeNode node2){
            if(node1==null && node2==null){
                return true;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            return judge(node1.left, node2.right) && judge(node1.right, node2.left);
        }
    }

    class Solution20240801 {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return false;
            }
            return compare(root,root);
        }
        public boolean compare(TreeNode node1, TreeNode node2){
            if(node1==null && node2==null){
                return true;
            }
            if(node1==null || node2==null){
                return false;
            }
            //败笔在这里，不能对比==就随便返回true，因为可能当前为true，后面为false。应该遇到false时返回false！
            if(node1.val!=node2.val){
                return false;
            }
            return compare(node1.left,node2.right) && compare(node1.right, node2.left);
        }
    }
//反正不能用层序遍历，要用迭代，左子树和右子树对比，右子树和左子树对比
//事后：不能对比==就随便返回true，因为可能当前为true，后面为false。应该遇到false时返回false！
}