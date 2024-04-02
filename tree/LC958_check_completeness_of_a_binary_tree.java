/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC958_check_completeness_of_a_binary_tree
 * Date Created : 2024-04-02
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-02       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题自己栽了，认了，我的习惯是先写框架，再在之上加逻辑，而此题恰恰是因为太过于拘泥于框架，导致步入歧途
 * solution是自己独立写的，各种面向测试用例编程，过程中明显感觉到走弯路了，但不甘心，已无法自拔，搞到最后终于放弃。。。
 * @author: Admin
 * @create: 2024-04-02
 **/
public class LC958_check_completeness_of_a_binary_tree {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if(root==null){
                return false;
            }
            //先写个bfs遍历
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                boolean empty = false;
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    if(tempNode==null){
                        break;
                    }
                    // if(root.left==null || root.right==null){
                    //     return false;
                    // }
                    // if(tempNode.right==null){

                    // }
                    //三种情况，1.当前节点，只要出现只有右叶子节点的情况，就判定为false
                    //2.当前节点，若只有左子节点，无右子节点，需要遍历后面的所有节点，不能有左子节点和右子节点。
                    //3.当前节点，无子节点，则后面的节点也不能有
                    if(tempNode.left==null && tempNode.right!=null){
                        return false;
                    }
                    System.out.println(i+"##"+tempNode.val+"###"+size);
                    if(/*tempNode.left!=null && */tempNode.right==null){
                        for(int j = i+1;j<=size;j++){
                            TreeNode tempNode2 = queue.poll();
                            if(tempNode2==null){
                                break;
                            }
                            if(tempNode2.left!=null || tempNode2.right!=null){
                                return false;
                            }
                        }
                        // TreeNode nextTempNode = queue.poll();
                        // if()
                        // return false;
                    }
                    // else if(tempNode.left==null && tempNode.right==null){
                    //     for(int j = i+1;j<=size;j++){
                    //         TreeNode tempNode2 = queue.poll();
                    //         if(tempNode2.left!=null || tempNode2.right!=null){
                    //             return false;
                    //         }
                    //     }
                    //     // TreeNode nextTempNode = queue.poll();
                    //     // if()
                    //     // return false;
                    // }


                    // System.out.println(i+"##"+tempNode.val);
                    // if(empty && i<size-1){
                    //     System.out.println(empty+"##"+i+"###"+size);
                    //     return false;
                    // }

                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                    // else{

                    //     empty=true;
                    //     System.out.println("##"+empty);
                    // }
                }

            }
            return true;
        }
    }

    //主要思路是当遇到第一个null时就标记一下，后面如果遇到非null，则说明不是完全二叉树
    class SolutionLabuladong {
        public boolean isCompleteTree(TreeNode root) {
            if(root==null){
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean empty = false;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    if(tempNode==null){
                        empty=true;
                    }else{
                        if(empty){
                            return false;
                        }else{
                            //这里无需判断非空，直接放到队列中，这是关键，我直接写了带判空的bfs框架，并在之上加逻辑，结果越加越乱，把自己带进坑里了。。。
                            queue.offer(tempNode.left);
                            queue.offer(tempNode.right);
                        }
                    }
                }
            }
            return true;
        }
    }
}