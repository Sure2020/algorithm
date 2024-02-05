/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC662_maximum_width_of_binary_tree
 * Date Created : 2024-02-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-05       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-05
 **/
public class LC662_maximum_width_of_binary_tree {
    public static void main(String[] args) {
        //TreeNode root = Tools.treeCreater(new int[] {0,0,0,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1,-1,0,0,-1});
        TreeNode root = new TreeNode();
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(0);

        root.left.right.right.right = new TreeNode(0);
        root.right.left.left.left = new TreeNode(0);

        root.left.right.right.right.right = new TreeNode(0);
        root.right.left.left.left.left = new TreeNode(0);

        root.left.right.right.right.right.right = new TreeNode(0);
        root.right.left.left.left.left.left = new TreeNode(0);

        root.left.right.right.right.right.right.right = new TreeNode(0);
        root.right.left.left.left.left.left.left = new TreeNode(0);
        Tools.treePrettyPrinter(root);
        //System.out.println(widthOfBinaryTree(root));
    }
    // 记录节点和对应编号
    class Pair {
        TreeNode node;
        int id;

        public Pair( TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 记录最大的宽度
        int maxWidth = 0;
        // 标准 BFS 层序遍历算法
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        // 从上到下遍历整棵树
        while (!q.isEmpty()) {
            int sz = q.size();
            int start = 0, end = 0;
            // 从左到右遍历每一行
            for (int i = 0; i < sz; i++) {
                Pair cur = q.poll();
                TreeNode curNode = cur.node;
                int curId = cur.id;
                // 记录当前行第一个和最后一个节点的编号
                if (i == 0) {
                    start = curId;
                }
                if (i == sz - 1) {
                    end = curId;
                }
                // 左右子节点入队，同时记录对应节点的编号
                if (curNode.left != null) {
                    q.offer(new Pair(curNode.left, curId * 2));
                }
                if (curNode.right != null) {
                    q.offer(new Pair(curNode.right, curId * 2 + 1));
                }
            }
            // 用当前行的宽度更新最大宽度
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }

    //my,failed
    int width = 0;
    public int widthOfBinaryTree2(TreeNode root) {
        // if(root==null){
        //     return 0;
        // }
        // if(root.left==null&&root.right==null){
        //     return 1;
        // }
        bfs(root);
        return width;

    }
    public void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            System.out.println("size: " + size);
            int leftIndex = -1,rightIndex = -1;
            for(int i=0;i<size;i++){
                TreeNode tempNode = q.poll();
                if(tempNode.val!=-999){
                    if(leftIndex==-1){
                        leftIndex=i;
                    }else{
                        rightIndex=i;
                    }
                }
                if(tempNode.left==null){
                    tempNode.left=new TreeNode(-999);
                }
                if(tempNode.right==null){
                    tempNode.right = new TreeNode(-999);
                }
                //print
                q.offer(tempNode.left);
                q.offer(tempNode.right);
            }
            System.out.println(leftIndex+"########"+rightIndex);
            if(leftIndex==-1&&rightIndex==-1){
                return;
            }else if(leftIndex!=-1&&rightIndex==-1){
                width=Math.max(width, 1);
            }else{
                width = Math.max(width, rightIndex-leftIndex+1);
            }
            System.out.println("width: "+ width);

        }
    }
}