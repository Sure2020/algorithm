/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC841_keys_and_rooms
 * Date Created : 2024-02-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-17       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 只带visited辅助的图的遍历，入门，需要反复看
 * @author: Admin
 * @create: 2024-02-17
 **/
public class LC841_keys_and_rooms {
    class Solution {
        Set<Integer> visited = new HashSet<>();
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            dfs(rooms, 0, rooms.size());
            return rooms.size()== visited.size();
        }
        public void dfs(List<List<Integer>> rooms, int s, int roomNum){
            visited.add(s);
            /*if (visited.size()==roomNum){
                return true;
            }*/
//            int size = rooms.size();
            for (int v: rooms.get(s)) {
                if(!visited.contains(v)){
                    dfs(rooms, v, roomNum);
                }
            }
//            return false;
        }
    }
}