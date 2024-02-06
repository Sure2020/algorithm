/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR046_binary_tree_right_side_view
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-06
 **/
public class LCR046_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = q.poll();
                if(i==size-1){
                    result.add(currentNode.val);
                }
                if(currentNode.left!=null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}