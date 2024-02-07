/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC501_find_mode_in_binary_search_tree
 * Date Created : 2024-02-07
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-07       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-07
 **/
public class LC501_find_mode_in_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{1,0,1,0,0,1,1,0});
        //TreeNode root = Tools.treeCreater(new int[]{1,-1,2});
        //TreeNode root = Tools.treeCreater(new int[]{1,-1,2,-1,-1,2});
        Tools.treePrettyPrinter(root);
        SolutionSelf solution = new SolutionSelf();
        //Solution2 solution = new Solution2();
        Tools.listPriter(solution.findMode(root));
    }
    //纯粹按自己想法写的，没利用中序遍历的特点，最终没解出来，保留痕迹如下
    static class SolutionSelf {
        int[] result = new int[10000];
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int maxCount = 1;
        int count = 0;
        boolean isEqual = true;
        public int[] findMode(TreeNode root) {
            dfs(root, root.val-1);
            System.out.println(result);
            System.out.println(map);
            System.out.println(maxCount);
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                Integer value = entry.getValue();
                if (value==maxCount){
                    Integer key = entry.getKey();
                    result[index] = key;
                    index ++;
                }
            }
            int[] finalResult = new int[index];
            for(int i=0;i<index;i++){
                finalResult[i]=result[i];
            }
            return finalResult;
        }
        public void dfs(TreeNode root, int parantVal){
            if (root==null){
                return;
            }
            dfs(root.left, root.val);

            /*if(!isEqual){
                count = 1;
            }*/

            //问题出在这里，传入了parentVal会导致count误置为1
            if(root.val != parantVal){
                count=1;
            }else{
                count++;
            }
            maxCount = Math.max(maxCount,count);
            map.put(root.val, count);
            /*if(root.left!=null && root.left.val==root.val){
                count += 1;
                maxCount = Math.max(maxCount, count);
                System.out.println(maxCount+"###"+count+"###"+root.val);
                map.put(root.val,count);
            }

            if(root.right!=null && root.right.val == root.val){
                count +=1;
                maxCount = Math.max(maxCount, count);
                System.out.println(maxCount+"###"+count+"###"+root.val);
                map.put(root.val, count);
            }*/


            /*if(root.left!=null && root.right!=null && root.left.val!=root.right.val){
                isEqual = false;
            }*/

            dfs(root.right, root.val);
        }
    }

    //看了labuladong和官解后尝试自己默写：
    static class Solution2 {
        int base,count,maxCount;
        List<Integer> tempList = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] result = new int[tempList.size()];
            for (int i = 0; i < tempList.size(); i++) {
                result[i]=tempList.get(i);
            }
            return result;
        }
        public void dfs(TreeNode root){
            if(root==null){
                return;
            }
            dfs(root.left);
            update(root.val);
            dfs(root.right);

        }
        public void update(int x){
            //System.out.println(x + "###" + base + "###" + count + "###" + maxCount);
            if(base == x){
                count++;

            }else {
                base = x;
                count =1;
            }
            if(count==maxCount && !tempList.contains(x)){
                tempList.add(x);
            }
//            maxCount = Math.max(maxCount, count);
            if(count>maxCount){
                tempList.clear();
                tempList.add(x);
                maxCount = count;
            }
        }
    }
}