/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Temp
 * Date Created : 2023-11-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-01       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-01
 **/
public class Temp {
    public void test(){
        test();
        System.out.println();
    }
    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    // 主函数
    int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }


}