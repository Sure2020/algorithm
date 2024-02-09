/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC230_kth_smallest_element_in_a_bst
 * Date Created : 2024-02-09
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-09       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这道题是为数不多的自己独立解出来，且只调试了几次就运行成功的题目
 * @author: Admin
 * @create: 2024-02-09
 **/
public class LC230_kth_smallest_element_in_a_bst {
    class Solution {
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            if(root==null){
                return -1;
            }
            int left = kthSmallest(root.left, k);
            count++;
            if(count == k){
                return root.val;
            }
            int right = kthSmallest(root.right, k);
            if(left != -1 || right != -1){
                return left != -1?left:right;
            }
            return -1;
        }
    }
}