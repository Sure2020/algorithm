/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC899_construct_binary_tree_from_preorder_and_postorder_traversal
 * Date Created : 2024-03-16
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-16       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-16
 **/
public class LC889_construct_binary_tree_from_preorder_and_postorder_traversal {
    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,5,3,6,7};
        int[] inOrder = new int[]{4,5,2,6,7,3,1};
        Solution solution = new Solution();
        Tools.treePrettyPrinter(solution.constructFromPrePost(preOrder, inOrder));
    }
    //我感觉自己挺厉害的，看了labuladong的思路，没看他代码，自己写出来了，虽然用ide进行了单步调试才确定了一些细节，但值得骄傲
    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if(preorder.length==0){
                return null;
            }

            for(int i=0;i<postorder.length;i++){
                map.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);

        }
        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
            if(preStart>preEnd){
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            //2.最后加了这个条件，就成了。没啥道理，是单步调试来的
            if(preStart==preEnd){
                return root;
            }
            //1.这里取前序遍历的第二个数，作为左右子树的分割
            int nextRootVal = preorder[preStart+1];
            int nextRootIndex = map.get(nextRootVal);
            int leftLength = nextRootIndex-postStart+1;
            int rightLength = postEnd-1 - nextRootIndex;
            root.left=build(preorder, preStart+1, preStart+leftLength, postorder, postStart, nextRootIndex);
            root.right=build(preorder, preEnd-rightLength+1, preEnd, postorder, nextRootIndex+1, postEnd-1);
            return root;
        }
    }
}