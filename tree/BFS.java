/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : BFS
 * Date Created : 2024-02-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-03       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-03
 **/
public class BFS {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{1,2,3,-1,5,-1,4});
        Tools.printTree(root);
        bfs(root);//12354
        System.out.println("############");
        bfs_practise2(root);
    }
    public static void bfs(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tempNode = q.poll();
            System.out.println(tempNode.val);
            if(tempNode.left==null&&tempNode.right==null){
                System.out.println("leaf node");
            }
            if(tempNode.left!=null){
                q.offer(tempNode.left);
            }
            if(tempNode.right!=null){
                q.offer(tempNode.right);
            }
        }
    }
    public static void bfs_practise1(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                TreeNode tempNode = q.poll();
                System.out.print(tempNode.val);
                if(tempNode.left !=null){
                    q.offer(tempNode.left);
                }
                if(tempNode.right !=null){
                    q.offer(tempNode.right);
                }
            }
        }
    }

    public static void bfs_practise2(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode tempNode = q.poll();
                System.out.print(tempNode.val);
                if(tempNode.left!=null){
                    q.offer(tempNode.left);
                }
                if(tempNode.right !=null){
                    q.offer(tempNode.right);
                }
            }
        }
    }
}