/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC105_construct_binary_tree_from_preorder_and_inorder_traversal
 * Date Created : 2024-03-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-15       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-15
 **/
public class LC105_construct_binary_tree_from_preorder_and_inorder_traversal {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        Solution solution = new Solution();
        Tools.treePrettyPrinter(solution.buildTree(preOrder, inOrder));
    }
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        }

        public TreeNode build(int[] preorder, int low1, int high1, int[] inorder, int low2, int high2) {
            //System.out.println(low1+"###"+high1+"###"+low2+"###"+high2);
            if (low1 > high1 || low2 > high2) {
                return null;
            }
            //找到根节点，并构造
            //迭代左右子树

            TreeNode root = new TreeNode(preorder[low1]);
            int rootIndex = -1;
            for (int i = low2; i <= high2; i++) {
                if (inorder[i] == preorder[low1]) {
                    rootIndex = i;
                }
            }
            int leftLength = rootIndex - low2;
            int rightLength = high2 - rootIndex;
            //前序数组的两个端点的确定，真的是有讲究，原则是尽量依赖自身的索引去计算，别跟后续数组扯关系！调了我整整一上午！手工调不能发现问题，最后借助了IDE！共调了3个小时！！！以后这种情况，还是直接看题解吧！！！
            //或者这么说，算前序的两个端点时，左子树就依赖左端点（low）去算，右子树就依赖右端点（high）去算。右子树不能依赖左端点，因为右子树整体会滑来滑去，而下一次的右端点和本次的右端点相同，依赖右端点最稳妥！
            root.left = build(preorder, low1 + 1, low1 + leftLength, inorder, low2, rootIndex - 1);
            //System.out.println("######   left finish");
            //root.right=build(preorder,rootIndex+1, high1, inorder, rootIndex+1, high2);
            //root.right=build(preorder,low1+rightLength, high1, inorder, rootIndex+1, high2);
            root.right = build(preorder, high1 - rightLength + 1, high1, inorder, rootIndex + 1, high2);
            //System.out.println("######   right finish");
            return root;
        }
    }

    //哈哈，我踏马是个天才！简单看了下之前的思路，独立敲完，调试了3次，直接AC!
    class Solution20250603 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        }
        public TreeNode build(int[] preorder, int preLow,int preHigh, int[] inorder, int inLow, int inHigh){
            //落下了base case
            if(preLow>preHigh||inLow>inHigh){
                return null;
            }
            //前序遍历的第一个节点就是根节点
            TreeNode root = new TreeNode(preorder[preLow]);
            int rootIndex = -1;
            for(int i=inLow;i<=inHigh;i++){
                if(inorder[i]==preorder[preLow]){
                    rootIndex=i;
                    break;
                }
            }
            int leftLength=rootIndex-inLow;
            int rightLength=inHigh-rootIndex;
            root.left = build(preorder,preLow+1,preLow+leftLength,inorder,inLow,inLow+leftLength-1);
            root.right = build(preorder,preHigh-rightLength+1,preHigh,inorder,inHigh-rightLength+1,inHigh);
            return root;
        }
    }

    //分解的思路
    //注意！根节点的值要写成preorder[preStart]，而不是preorder[0]!因为子树的根节点在变，不固定！
    //还不错，自己优化了一下，性能提升50%！狗头
    class Solution20240604 {
        Map<Integer,Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i],i);
            }
            return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

        }
        //函数定义，回推树
        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStrat, int inEnd){
            //base case
            if(preStart>preEnd || inStrat  > inEnd){
                return null;
            }
            int rootIndex = map.get(preorder[preStart]);
            // for(int i=0;i<inorder.length;i++){
            //     //这里！错把根节点的值写成了preorder[0]！要知道左右子树是在滑动的，各子树根节点不固定！
            //     if(preorder[preStart] == inorder[i]){
            //         rootIndex=i;
            //         break;
            //     }
            // }
            int leftLength = rootIndex-inStrat;
            int rightLength = inEnd-rootIndex;
            //这里根节点的值错写成了preorder[0]
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = build(preorder,preStart+1,preStart+leftLength,inorder,inStrat, rootIndex-1);
            root.right = build(preorder,preEnd-rightLength+1, preEnd,inorder,rootIndex+1,inEnd);
            return root;
        }
    }

    class Solution20240710 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        }
        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            //System.out.println("preStart: " + preStart + " preEnd " + preEnd + " inStart: " + inStart + " inEnd: "+inEnd);
            if(preEnd<preStart || inEnd<inStart){
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            //base case
            if(preStart==preEnd || inStart==inEnd){
                return root;
            }

            //在中序遍历中找到root的位置
            int rootIndex = -1;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i]==rootVal){
                    rootIndex = i;
                    break;
                }
            }
            //这里leftLen错写成了rootIndex，应该是rootIndex-inStart
            int leftTreeLength = rootIndex-inStart;
            //这里rightLen错写成了inorder.length-rootIndex-1
            int rightTreeLength = inEnd-rootIndex;
            //System.out.println("rootIndex: " + rootIndex + " leftlen: " + leftTreeLength+" rightlen " + rightTreeLength);
            if(leftTreeLength==0){
                root.left=null;
            }else{
                root.left = build(preorder, preStart+1,preStart+leftTreeLength,inorder,inStart, inStart+leftTreeLength-1);
            }
            if(rightTreeLength==0){
                root.right=null;
            }else{
                //算preorder边界时，别跟rootIndex扯上关系，因为它是inorder的产物！
                //root.right = build(preorder,rootIndex+1,rootIndex+rightTreeLength,inorder,rootIndex+1,rootIndex+rightTreeLength);
                root.right = build(preorder,preEnd-rightTreeLength+1,preEnd,inorder, rootIndex+1,inEnd);
            }


            return root;
        }
    }
//有印象，还是分解的递归，然后每次递归的两边端点有讲究

//哎，又栽在这里
//三点！1.计算leftLen和rightLen，就利用rootIndex和inStart\inEnd来，也就是全用中序遍历相关的变量别扯其他的！
//2.计算左子树的边界：
//左子树的前序界，就用preStart和leftLength算，别扯其他的！
//左子树的中序边界，就用inStart和rootIndex算，别扯其他的！
//3.计算右子树的边界：
//右子树的前序边界，就用preEnd和rightLen算，别扯其他的！
//右子树的中序边界，就用inEnd和rootIndex算，别扯其他的！
    /*{
        int leftLength = rootIndex-inStrat;
        int rightLength = inEnd-rootIndex;
        //这里根节点的值错写成了preorder[0]
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder,preStart+1,preStart+leftLength,inorder,inStrat, rootIndex-1);
        root.right = build(preorder,preEnd-rightLength+1, preEnd,inorder,rootIndex+1,inEnd);
    }*/

    class Solution20250518 {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i=0;i<inorder.length;i++){
                inorderMap.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }
        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart>preEnd || inStart>inEnd){
                return null;
            }
            int rootIndex = inorderMap.get(preorder[preStart]);
            int leftLength = rootIndex-inStart;
            int rightLength = inEnd - rootIndex;
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = build(preorder, preStart+1, preStart+leftLength, inorder, inStart, rootIndex-1);
            // 这里竟然错把rightLength写成了leftLength
            root.right = build(preorder, preEnd-rightLength+1, preEnd, inorder, rootIndex+1, inEnd);
            return root;
        }
    }
}