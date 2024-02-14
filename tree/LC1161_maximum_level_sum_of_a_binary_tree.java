/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1161_maximum_level_sum_of_a_binary_tree
 * Date Created : 2024-02-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-15       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-15
 **/
public class LC1161_maximum_level_sum_of_a_binary_tree {
    class Solution {

        public int maxLevelSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            return bfs(root);
        }
        public int bfs(TreeNode root){
            int resultLevel = 0;
            //一开始设置的maxSum的初始值是0，没考虑val的取值范围，大意了
            int maxSum = -1000000;//-10*Math.pow(10,6);
            int currentLevel = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size = q.size();
                int currentSum = 0;
                currentLevel ++;
                //System.out.println("currentLevel: "+ currentLevel);
                for(int i=0;i<size;i++){
                    TreeNode tempNode = q.poll();
                    currentSum += tempNode.val;
                    if(i==size-1){
                        if(currentSum>maxSum){
                            maxSum = currentSum;
                            resultLevel = currentLevel;
                        }
                        //System.out.println(currentSum+"###"+maxSum+"###"+resultLevel);
                    }
                    if(tempNode.left!=null){
                        q.offer(tempNode.left);
                    }
                    if(tempNode.right!=null){
                        q.offer(tempNode.right);
                    }
                }
            }
            return resultLevel;
        }
    }
}