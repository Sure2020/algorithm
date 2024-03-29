/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC103_binary_tree_zigzag_level_order_traversal
 * Date Created : 2024-03-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-11       Admin     xxx
 * --------------------------------------------------------------------
 */

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题确实是自己独立写出来的，但不够简洁，主要是不知道linkedlist还有addLast和addFirst方法，需再练练
 * @author: Admin
 * @create: 2024-03-11
 **/
public class LC103_binary_tree_zigzag_level_order_traversal {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);

        Solution solution = new Solution();
        solution.reverse(list);
        System.out.println(list.get(0) + " "+list.get(1)+" "+list.get(2));
        TreeNode root = Tools.treeCreater(new int[]{3,9,20,15,7});
        solution.zigzagLevelOrder(root);
    }
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isLeft=true;
            boolean isRight=false;
            while(!queue.isEmpty()){
                int size = queue.size();
                //System.out.println("####"+size);
                List<Integer> tempList = new ArrayList<>();
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    tempList.add(tempNode.val);
                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                }
                if(isLeft){
                    //System.out.println("####  left");

                    isLeft=false;
                    isRight=true;
                    result.add(tempList);
                    continue;
                }
                if(isRight){
                    //System.out.println("####  right");

                    isLeft=true;
                    isRight=false;
                    reverse(tempList);
                    result.add(tempList);
                    //continue;
                }

            }
            return result;
        }
        public void reverse(List<Integer> list){
            for(int i=0,j=list.size()-1; i<=j; i++,j--){
                int temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);
            }
        }
    }

    class Solution20240312 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> result = new LinkedList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isLeftToRight=true;
            while(!queue.isEmpty()){
                int size = queue.size();
                LinkedList<Integer> tempList = new LinkedList<>();
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    if(isLeftToRight){
                        tempList.addLast(tempNode.val);
                    }else{
                        tempList.addFirst(tempNode.val);
                    }

                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                }
                isLeftToRight = !isLeftToRight;
                result.add(tempList);
            }
            return result;
        }
    }
}