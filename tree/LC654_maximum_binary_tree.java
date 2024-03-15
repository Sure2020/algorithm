/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC654_maximum_binary_tree
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
public class LC654_maximum_binary_tree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length-1);
        }
        public TreeNode build(int[] nums, int low, int high){
            //一开始对这个base case不理解，其实把边界代入，就好理解了：
            //假设现在Low high相等，那就是说数组里只有一个节点，它就是根节点，后面递归时，就会造成low>high的场景，触发base base
            if(low>high){
                return null;
            }
            int index=-1, maxValue = Integer.MIN_VALUE;
            for(int i=low;i<=high;i++){
                if(nums[i]>maxValue){
                    index=i;
                    maxValue=nums[i];
                }
            }
            TreeNode root = new TreeNode(maxValue);
            root.left=build(nums, low, index-1);
            root.right=build(nums, index+1, high);
            return root;
        }
    }
}