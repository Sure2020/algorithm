/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC617_merge_two_binary_trees
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
 * 这道题是个遗憾，只差一点就自己独立解出来了。注意看被注释掉的部分，那个判断条件是多此一举，分明是没认真读题！
 * @author: Admin
 * @create: 2024-02-06
 **/
public class LC617_merge_two_binary_trees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2!=null){
            return root2;
        }
        if(root1!=null&&root2==null){
            return root1;
        }
        if(root1==null&&root2==null){
            return null;
        }
        // if(root1.val != root2.val){
        //     root1.val += root2.val;
        //     return root1;
        // }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}