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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
        //System.out.println(widthOfBinaryTreePractise1(root));
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


    //按labuladong练习1
    class NodeAndId{
        TreeNode node;
        int id;
        public NodeAndId(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTreePractise1(TreeNode root) {
        if(root==null){
            return 0;
        }
        bfsPractise1(root);
        return widthPractise1;
    }
    int widthPractise1=0;
    public void bfsPractise1(TreeNode root){
        if(root==null){
            return;
        }
        Queue<NodeAndId> q = new LinkedList<>();
        q.offer(new NodeAndId(root, 1));
        while(!q.isEmpty()){
            int size = q.size();
            int start=0,end =0;
            for(int i = 0;i< size;i++){
                NodeAndId nodeAndId = q.poll();
                if (i==0){
                    start = nodeAndId.id;
                }
                if (i==size-1){
                    end = nodeAndId.id;
                }
                if(nodeAndId.node.left!=null){
                    q.offer(new NodeAndId(nodeAndId.node.left, 2*nodeAndId.id));
                }
                if(nodeAndId.node.right!=null){
                    q.offer(new NodeAndId(nodeAndId.node.right, 2*nodeAndId.id+1));
                }
            }
            widthPractise1 = Math.max(widthPractise1, end-start+1);
        }
    }

    //关键是二叉树的节点编号，完全二叉树的情况下假设根节点编号为x，则左叶子为2x，右叶子为2x+1;
    //次关键点是，自定义一个结构体存储节点和编号。
    class Solution20240530 {
        // public class Pair{
        //     private TreeNode node;
        //     private int number;
        //     public Pair(TreeNode node, int number){
        //         this.node = node;
        //         this.number = number;
        //     }
        // }
        public int widthOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            int maxWidth = 0;
            // List<Pair> pairList = new ArrayList<>();
            Map<TreeNode, Integer> map = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            map.put(root, 1);
            while(!queue.isEmpty()){
                int size = queue.size();
                long start = 0,end=0;
                for(int i=1;i<=size;i++){
                    TreeNode tempNode = queue.poll();
                    int number = map.get(tempNode);
                    if(tempNode.left!=null){
                        queue.offer(tempNode.left);
                        map.put(tempNode.left, 2*number);
                    }
                    if(tempNode.right!=null){
                        queue.offer(tempNode.right);
                        map.put(tempNode.right, 2*number+1);
                    }

                    // System.out.println("size: "+size);
                    // System.out.println("i: "+i);
                    if(i==1){
                        start = map.get(tempNode);

                    }
                    if(i==size){
                        end = map.get(tempNode);

                        // System.out.println("start: "+start);
                        // System.out.println("end: "+end);
                        int diff = (int)(end-start+1);
                        // System.out.println("diff: "+diff);
                        maxWidth = Math.max(maxWidth, diff);
                        // System.out.println("max: "+maxWidth);
                        // System.out.println("####################");
                    }
                    //end-start的运算不能放在这里，会造成0-超大start然后溢出的情况


                }
            }
            return maxWidth;
        }
    }

    class Solution20240607 {
        class Pair {
            private TreeNode node;
            private long number;
            Pair(TreeNode node, long number){
                this.node = node;
                this.number = number;
            }
            public TreeNode getNode(){
                return this.node;
            }
            public long getNumber(){
                return this.number;
            }
        }
        public int widthOfBinaryTree(TreeNode root) {
            long result = 0;
            if(root==null){
                return 0;
            }
            Queue <Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root,1));
            while(!queue.isEmpty()){
                int size = queue.size();
                //注意2，要用long，int的话容易溢出
                long start =0,end=0;
                for(int i=1;i<=size;i++){
                    Pair pair = queue.poll();
                    TreeNode node = pair.getNode();
                    long number = pair.getNumber();
                    if(i==1){
                        //System.out.println("i==i: ### " + i + " $$$ " + number);
                        start = number;
                    }
                    //注意1，这里还不能用else if，自作聪明了，考虑只有一个根节点的情况
                    if(i==size){
                        //System.out.println("i==size: ### " + i + " $$$ " + number);
                        end = number;
                    }
                    //result = Math.max(result, end-start + 1);
                    if(node.left!=null){
                        queue.offer(new Pair(node.left, 2* number));
                    }
                    if(node.right!=null){
                        queue.offer(new Pair(node.right, 2*number+1));
                    }
                    //System.out.println("################");
                }
                //注意3，被自己蠢到了！把这个放在了for循环里面，导致溢出，放在外面，就可以用int类型，因为溢出也没关系，最后算的是两个值的差值
                result = Math.max(result, end-start + 1);
            }
            return (int)result;
        }
    }
//由于老能偷瞄到上次的思路，导致练习不够纯粹，以后思路就写在代码下方了。
//这次就是偷瞄到了上次的思路：关键是记录每个节点的编号。
}