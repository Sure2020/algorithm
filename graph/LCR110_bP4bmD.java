/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR110_bP4bmD
 * Date Created : 2024-02-16
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-16       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 纯学的labuladong，自己加了一些注释
 * @author: Admin
 * @create: 2024-02-16
 **/
public class LCR110_bP4bmD {
    class Solution {
        //存放结果
        List<List<Integer>> result = new LinkedList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            //存放已遍历的路径
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return result;
        }
        public void traverse(int[][] graph, int s, LinkedList<Integer> path){
            //将当前节点加入路径
            path.add(s);
            int n =  graph.length;
            //到达终点，就把path加入result
            if(s==n-1){
                result.add(new LinkedList<>(path));
            }
            //递归每个相邻的节点
            for(int v : graph[s]){
                traverse(graph,v, path);
            }
            //从路径移出节点s
            path.removeLast();
        }
    }
}