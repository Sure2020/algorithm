/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC113_path_sum_ii
 * Date Created : 2024-02-13
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-13       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题自己独立做出来的，只是list.remove方法不太熟练，且忘了需要在add前先new list
 * @author: Admin
 * @create: 2024-02-13
 **/
public class LC113_path_sum_ii {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            findPath(root, targetSum);
            return result;
        }
        public void findPath(TreeNode root,int targetSum){
            if(root==null){
                return;
            }
            currentPath.add(root.val);
            if(root.left==null&&root.right==null){
                if(root.val == targetSum){
                    //这里没用new，导致最后的结果是空的，好在自己独立发现并改正了
                    result.add(new ArrayList<>(currentPath));
                }
            }
            findPath(root.left,targetSum-root.val);
            findPath(root.right,targetSum-root.val);
            currentPath.remove(currentPath.size()-1);
        }
    }
}