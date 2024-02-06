/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC108_convert_sorted_array_to_binary_search_tree
 * Date Created : 2024-02-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-06
 **/
public class LC108_convert_sorted_array_to_binary_search_tree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-10,-3,0,5,9};
        solution.sortedArrayToBST(nums);
    }
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums == null){
                return null;
            }
            return build(nums, 0, nums.length-1);
        }
        public TreeNode build(int[] nums, int left, int right){
            if(left>right){
                return null;
            }
            int mid = left + (right-left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, left, mid-1);
            root.right = build(nums,mid+1, right);
            return root;
        }
    }
}