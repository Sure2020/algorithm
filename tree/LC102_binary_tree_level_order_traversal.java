/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC102_binary_tree_level_order_traversal
 * Date Created : 2024-02-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-15       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 第二次写，没搞清楚两层循环咋写，只写出来一层，需要再练
 * @author: Admin
 * @create: 2024-02-15
 **/
public class LC102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{3,9,20,-1,-1,15,7});
        Tools.treePrettyPrinter(root);
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return new ArrayList<>();
            }
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            while(!q.isEmpty()){
                List<Integer> currentLevelVals = new ArrayList<>();
                int size = q.size();
                // 提交后发现自己的和labuladong的运行用时差很多，最后发现是因为多了几处print导致！提交前记得去掉print！
                //System.out.println(size);
                for(int i=0;i<size;i++){
                    TreeNode tempNode = q.poll();
                    //System.out.println(tempNode.val+"###");
                    currentLevelVals.add(tempNode.val);
                    if(i==size-1){
                        result.add(currentLevelVals);
                    }
                    //System.out.println(currentLevelVals.size()+"###"+result.size());
                    //下面两处offer第一次写在了for循环外面，导致OOM，还调试了半天，真的尴尬
                    if(tempNode.left!=null){
                        q.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        q.offer(tempNode.right);
                    }
                }
            }
            return result;
        }
    }
    class Solution20240311 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){

                int size = queue.size();
                List<Integer> tempList = new LinkedList<>();
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
                result.add(tempList);

            }
            return result;

        }
    }

    //每层放到一个队列中，再依次取
    //嗯，还行，通过做其他几个简单的题，然后窥视到了层序遍历的一些细节，然后在这里“独立”写出来了，哈哈
    class Solution20240529 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
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
                result.add(tempList);

            }
            return result;
        }
    }
    //每层先放到queue中，再逐个取出
    class Solution20240604 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> tempList= new ArrayList<>();
                int size = queue.size();
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
                result.add(tempList);
            }
            return result;
        }
    }

    class Solution20240619 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                //System.out.println("size: " + size);
                TreeNode tempNode = new TreeNode();
                List<Integer> tempList = new ArrayList<>();;
                for(int i=1;i<=size;i++){
                    tempNode = queue.poll();
                    //System.out.println("tempNode.val: " + tempNode.val);
                    tempList.add(tempNode.val);

                    //过度自信，思路没完全理清就直接上，结果下面两个Offer写在了for循环外面。
                    //作用是将每个节点的左右子节点都放入queue，所以要放在for里面！
                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                }
                result.add(tempList);
            }
            return result;
        }
    }
    class Solution20240620 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                TreeNode tempNode = null;
                List<Integer> tempList = new ArrayList<>();
                for(int i=0;i<size;i++){
                    tempNode = queue.poll();
                    tempList.add(tempNode.val);
                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                    }
                }
                result.add(tempList);
            }
            return result;
        }
    }
//queue先进先出记录node
//haha，我喜欢做这个，因为印象深刻。。。

    class Solution20240725 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
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
                result.add(tempList);
            }
            return result;
        }
    }
//queue
//事后：真厉害，一次过

    class Solution20241205 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> tempList = new ArrayList<>();
                //size要提取算，不能在for循环中算，因为那时候已经有下一层的插入queue了
                int size = queue.size();
                //System.out.println("size: "+ queue.size());
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    //System.out.println("val: " + tempNode.val);
                    tempList.add(tempNode.val);
                    if(tempNode.left!=null){
                        queue.add(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        queue.add(tempNode.right);
                    }
                }
                result.add(tempList);
            }
            return result;
        }
    }
//时间久了还是一时间没想起来，这次把思路写清楚些：
//利用queue，先把root塞进去，再开始遍历queue，记录值的同时，再把左右子树塞进queue
}