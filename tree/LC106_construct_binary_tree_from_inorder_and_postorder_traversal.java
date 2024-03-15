/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC106_construct_binary_tree_from_inorder_and_postorder_traversal
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
public class LC106_construct_binary_tree_from_inorder_and_postorder_traversal {
    //我还是有点牛的，独立把105题的边界弄清楚以后，这个题的边界也在几次调试后弄清，最后独立做出来了
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length==0){
                return null;
            }
            for(int i =0;i<inorder.length; i++){
                map.put(inorder[i], i);
            }
            return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }
        public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
            if(inStart>inEnd){
                return null;
            }
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = map.get(rootVal);
            //int rootIndex=-1;
            // for(int i=inStart;i<=inEnd;i++){
            //     if(inorder[i]==postorder[postEnd]){
            //         rootIndex=i;
            //         break;
            //     }
            // }
            int leftLength = rootIndex-inStart;
            int rightLength = inEnd-rootIndex;
            root.left=build(inorder, inStart, rootIndex-1, postorder,postStart, postStart+leftLength-1);
            root.right=build(inorder, rootIndex+1, inEnd, postorder,postEnd-rightLength,postEnd-1);
            return root;
        }
    }
}