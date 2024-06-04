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

//import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    //层序遍历基础上，带上当前深度来控制方向
    //用一个flag标记方向，能感觉到性能不行，但好歹是独立做出来的，而且相对顺利！
    class Solution20240529 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean leftToRight=true;
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> tempList = new ArrayList<>();
                if(leftToRight){
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
                }else{
                    Stack<TreeNode> stack = new Stack<>();

                    for(int i=1;i<=size;i++){
                        TreeNode tempNode = queue.poll();
                        stack.push(tempNode);
                        //tempList.add(tempNode.val);
                        if(tempNode.left!=null){
                            queue.offer(tempNode.left);
                        }
                        if(tempNode.right!=null){
                            queue.offer(tempNode.right);
                        }
                    }
                    for(int i=1;i<=size;i++){
                        TreeNode tempNode = stack.pop();
                        tempList.add(tempNode.val);
                    }
                }
                result.add(tempList);
                leftToRight = !leftToRight;
            }

            return result;
        }
    }

    //层序遍历基础上，带上当前深度来控制方向
    //用一个flag标记方向，能感觉到性能不行，但好歹是独立做出来的，而且相对顺利！
    //唉！恍然大悟！记住LinkedList有方法可以头插或者尾插！自然就可以控制方向了
    class Solution20240529LinkedList {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean leftToRight=true;
            while(!queue.isEmpty()){
                int size = queue.size();
                //List<Integer> tempList = new ArrayList<>();
                LinkedList<Integer> tempList = new LinkedList<>();
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    if(leftToRight){
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
                result.add(tempList);
                leftToRight = !leftToRight;
            }

            return result;
        }
    }

    //我踏马记得你，LinkedList可以头插或尾插！
    class Solution20240604 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isLeftToRight = true;
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