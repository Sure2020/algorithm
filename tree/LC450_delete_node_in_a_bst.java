/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC450_delete_node_in_a_bst
 * Date Created : 2024-02-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 在BST中删除一个数，技巧性很强，学来的
 * @author: Admin
 * @create: 2024-02-11
 **/
public class LC450_delete_node_in_a_bst {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{5,3,6,2,4,-1,7});
        Tools.treePrettyPrinter(root);
        Solution solution = new Solution();
        Tools.treePrettyPrinter(solution.deleteNode(root, 3));
    }
    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return null;
            }
            if(root.val ==key){
                // case 1
                if(root.left==null&&root.right==null){
                    return null;
                }
                // case 2
                if(root.left == null){
                    return root.right;
                }
                if(root.right==null){
                    return root.left;
                }
                // case 3
                //注意这里误将root.right写成了root，导致无限循环，肉眼还排查不出来。所以写第一遍时保持思路清晰很重要
                TreeNode minNode = findMin(root.right);
                root.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                minNode.right = root.right;
                root = minNode;
            }
            else if(root.val < key){
                root.right = deleteNode(root.right,key);
            }else if(root.val > key){
                root.left=deleteNode(root.left, key);
            }
            return root;
        }
        public TreeNode findMin(TreeNode root){
            if(root ==null){
                return null;
            }
            TreeNode tempNode = root;
            while(tempNode.left!=null){
                tempNode = tempNode.left;
            }
            return tempNode;
        }
    }

    class Solution20240216 {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return null;
            }

            if(root.val==key){
                if(root.left==null&&root.right==null){
                    //第二次写,这里误写成了root=null
                    // root=null;
                    return null;

                }
                if(root.left==null){
                    //第二次写
                    // root=root.right;
                    return root.right;
                }
                if(root.right==null){
                    //第二次写
                    // root=root.left;
                    return root.left;
                }
                //case 3
                if(root.left!=null&&root.right!=null){
                    ////第二次写,误将root.right写成root,犯了第一次写时同样的错啊,不应该
                    TreeNode tempNode = findMin(root.right);

                    root.right = deleteNode(root.right,tempNode.val);
                    tempNode.left=root.left;
                    tempNode.right=root.right;
                    root=tempNode;
                    //labuladong解法没有这个return,感觉写上更有助于理解,存疑~
                    return root;
                }
            }
            // TreeNode left = root.left;
            // TreeNode right = root.right;
            if(key>root.val){
                //root.left = deleteNode(root.left,key);
                root.right = deleteNode(root.right,key);
            }
            if(key<root.val){
                //root.right = deleteNode(root.right,key);
                root.left = deleteNode(root.left,key);
            }
            // root.left = left;
            // root.right = right;
            return root;

        }
        public TreeNode findMin(TreeNode root){
            TreeNode tempNode = root;
            while(tempNode.left!=null){
                tempNode = tempNode.left;
            }
            return tempNode;
        }
    }
}