/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : DFS
 * Date Created : 2024-02-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-03       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-03
 **/
public class DFS {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{1,2,3,-1,5,-1,4});
        Tools.printTree(root);
        dfs(root);//12534
    }
    public static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}