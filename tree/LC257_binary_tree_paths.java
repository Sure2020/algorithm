/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC257_binary_tree_paths
 * Date Created : 2024-02-01
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-01       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-01
 **/
public class LC257_binary_tree_paths {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        tempNode = root.left;
        tempNode.right = new TreeNode(5);

        tempNode = root.right;
        tempNode.left = new TreeNode(10);
        //path2(root,"");
        path(root,"");
        List<String> res = new ArrayList<>();
        res.addAll(result);
        result.clear();
        System.out.println(res);
    }
    static List<String> result = new ArrayList<>();
    public static void path (TreeNode root, String onePath){
        if(root==null){
            return ;
        }
        StringBuilder sb = new StringBuilder(onePath);
        sb.append(root.val) ;
        if(root.left==null&&root.right==null){
            result.add(sb.toString());
            return;
        }else{
            sb.append("->");
        }
        path(root.left, sb.toString());
        path(root.right, sb.toString());
    }
    public static void path2 (TreeNode root, String onePath){
        if(root==null){
            return ;
        }
        onePath += (root.val) ;
        if(root.left==null&&root.right==null){
            result.add(onePath);
            return;
        }else{
            onePath+=("->");
        }
        if(root.left!=null){
            path2(root.left, onePath);
        }
        if(root.right!=null){
            path2(root.right, onePath);
        }

    }
}