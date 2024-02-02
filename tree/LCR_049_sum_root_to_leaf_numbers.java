/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR_049_3Etpl5
 * Date Created : 2024-02-02
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-02       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-02
 **/
public class LCR_049_sum_root_to_leaf_numbers {
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root);
        return sum;
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            sum += Integer.valueOf(sb.toString());
        }
        traverse(root.left);
        traverse(root.right);
        sb.deleteCharAt(sb.length()-1);
    }
}