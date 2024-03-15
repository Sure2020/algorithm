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
}