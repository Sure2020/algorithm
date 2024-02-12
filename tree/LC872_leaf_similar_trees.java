/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC872_leaf_similar_trees
 * Date Created : 2024-02-12
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-12       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 注意用不等号对比两个Integer对象，实际是对比的两个对象是否是同一个，而不是对比的值是否相等。改成用equals方法对比，或者先转成int再对比
 * @author: Admin
 * @create: 2024-02-12
 **/
public class LC872_leaf_similar_trees {
    public static void main(String[] args) {
        TreeNode root1 = Tools.treeCreater(new int[]{1,2,200});
        TreeNode root2 = Tools.treeCreater(new int[]{1,2,200});
        Solution solution = new Solution();
        System.out.println(solution.leafSimilar(root1, root2));
    }
    static class Solution {
        List<Integer> leafList1 = new ArrayList<Integer>();
        List<Integer> leafList2 = new ArrayList<Integer>();
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if(root1==null && root2==null){
                return true;
            }
            if(root1==null||root2==null){
                return false;
            }
            getLeafList(root1, leafList1);
            getLeafList(root2, leafList2);
            if(leafList1.size()!= leafList2.size()){
                return false;
            }
            int size = leafList1.size();
            /*for(int i =0;i< size;i++){
                 *//*int leaf1 = leafList1.get(i);
                 int leaf2 = leafList2.get(i);
                 if(leaf1!=leaf2){
                     return false;
                 }*//*
                // 注意这里实际是对比的两个对象是否是同一个，而不是对比的值是否相等。改成用equals方法对比，或者先转成int再对比
                //if(leafList1.get(i)!=leafList2.get(i)){
                if(!leafList1.get(i).equals(leafList2.get(i))){
                    return false;
                }
            }
            return true;*/
            //原来Arraylist的equals方法可以对比两个list的值是否相等
            return leafList1.equals(leafList2);
        }
        public void getLeafList(TreeNode root, List<Integer> leafList){
            if(root==null){
                return;
            }
            if(root.left==null&&root.right==null){
                leafList.add(root.val);
            }
            getLeafList(root.left, leafList);
            getLeafList(root.right, leafList);
        }
    }
}