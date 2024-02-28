/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC169_majority_element
 * Date Created : 2024-02-28
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-28       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 唉，这正负电子的思路真秒，记一下吧
 * @author: Admin
 * @create: 2024-02-28
 **/
public class LC169_majority_element {
    class Solution {
        public int majorityElement(int[] nums) {
            int result=0;
            int count =0;
            for(int i=0;i<nums.length;i++){
                if(count==0){
                    result = nums[i];
                    count=1;
                }else if(nums[i]==result){
                    count++;
                }else{
                    count--;
                }
            }
            return result;
        }
        public int majorityElementSelf(int[] nums) {
            if(nums.length==1){
                return nums[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int key = nums[i];
                if(map.containsKey(key)){
                    int value = map.get(key)+1;
                    if(value > nums.length/2){
                        return key;
                    }
                    map.put(key, value);
                }else{
                    map.put(key,1);
                }
            }
            /*for(Integer key: map.keySet()){
                int value = map.get(key);
                if(value>nums.length/2){
                    return key;
                }
            }*/
            return -9*1000000000;
        }
    }
}