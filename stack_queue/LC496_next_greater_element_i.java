/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC496_next_greater_element_i
 * Date Created : 2024-03-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-19       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 要练
 * @author: Admin
 * @create: 2024-03-19
 **/
public class LC496_next_greater_element_i {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res1 = new int[nums1.length];
            int[] res2 = nextGreaterElement(nums2);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<res2.length;i++){
                //System.out.println(res2[i]+"#"+i);
                map.put(nums2[i], res2[i]);
            }
            //System.out.println("#####");
            for(int i=0;i<nums1.length;i++){
                //System.out.println("#"+nums1[i]);
                res1[i]=map.get(nums1[i]);
            }
            return res1;
        }
        public int[] nextGreaterElement(int[] nums){
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for(int i=nums.length-1;i>=0;i--){
                while(!stack.isEmpty() && nums[i]>=stack.peek()){
                    stack.pop();
                }
                res[i] = stack.isEmpty()?-1:stack.peek();
                stack.push(nums[i]);
            }
            return res;
        }
    }
}