/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC797_all_paths_from_source_to_target
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 纯参考的labuladong
 * @author: Admin
 * @create: 2024-02-16
 **/
public class LC797_all_paths_from_source_to_target {
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return result;
        }
        public void traverse(int[][] graph, int s, LinkedList<Integer> path){
            path.add(s);
            int n = graph.length;
            if(s==n-1){
                result.add(new LinkedList<>(path));
            }
            for(int v: graph[s]){
                traverse(graph, v, path);
            }
            path.removeLast();
        }
    }
}