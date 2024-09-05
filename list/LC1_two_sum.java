/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1_two_sum
 * Date Created : 2024-02-24
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-24       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-24
 **/
public class LC1_two_sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> valToIndex = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int need = target - nums[i];
                if(valToIndex.containsKey(need)){
                    return new int[]{valToIndex.get(need), i};
                }
                valToIndex.put(nums[i], i);
            }
            return new int[]{};
        }
    }
    class SolutionSelf {
        public int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            int[] result = {-1,-1};
            for(int i=0; i<length; i++) {
                for(int j=i+1; j<length; j++) {
                    int sum = nums[i] + nums[j];
                    if(sum == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }

                }
            }
            return result;
        }
    }

    class Solution20240612 {
        public int[] twoSum(int[] nums, int target) {
            // Map<Integer,Integer> map = new HashMap<>();
            // for(int i=0;i<nums.length;i++){
            //     map.put(nums[i], i);
            // }
            // int need = 0;
            // int[] result = new int[]{-1,-1};
            // for(int i=0;i<nums.length;i++){
            //     need = target-nums[i];
            //     if(map.containsKey(need) && need!=nums[i]){
            //         result[0]=i;
            //         result[1]=map.get(need);
            //         break;
            //     }
            // }
            // return result;
            Map<Integer, Integer> map = new HashMap<>();
            int need = 0;
            for(int i=0;i<nums.length;i++){
                need = target-nums[i];
                if(map.containsKey(need)){
                    return new int[]{i, map.get(need)};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1,-1};
        }
    }
//因为此题带哈希表标签，那就。。。将所有元素读入一个哈希表，然后依次取数组元素，在hashtable中找与target的差值
//掉坑里了，不能一次性将所有元素都读入hashmap，要边从数组中取元素，边在Map中找元素，边向map中放元素。否则会重复取到同一个元素

    class Solution20240619 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            int need = 0;
            for(int i=0;i<nums.length;i++){
                need = target - nums[i];
                if(map.containsKey(need)){
                    return new int[]{i, map.get(need)};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{-1,-1};
        }
    }
//这个我印象很深刻，不能一次性都放到map中，否则会将同一个元素使用两次，应该边判断边放


    class Solution20240725 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int need = target - nums[i];
                if(map.containsKey(need)){
                    return new int[]{i,map.get(need)};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{-1,-1};
        }
    }
//有印象，map

    class Solution20240904 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            //int index = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int need = target-nums[i];
                if(map.containsKey(need)){
                    // result[0]=i;
                    // result[1]=map.get(need);
                    return new int[]{i, map.get(need)};
                }else{
                    map.put(nums[i], i);
                }
            }
            return new int[]{-1,-1};
        }
    }
//根据当前的值，求需要的值，并去map中找，找不到就把当前值放入map，继续判断下一个元素。
}