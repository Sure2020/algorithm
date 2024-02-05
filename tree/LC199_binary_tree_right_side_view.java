/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC199_binary_tree_right_side_view
 * Date Created : 2024-02-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-05       Admin     xxx
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
 * @create: 2024-02-05
 **/
public class LC199_binary_tree_right_side_view {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return result;
    }

    public void bfs (TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode tempNode = q.poll();
                // 当到达每一层的最右边，就把节点的值加入结果
                if(i==size-1){
                    result.add(tempNode.val);
                }
                if(tempNode.left!=null){
                    q.offer(tempNode.left);
                }
                if(tempNode.right!=null){
                    q.offer(tempNode.right);
                }
            }
        }
    }
}