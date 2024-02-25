/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC15_3sum
 * Date Created : 2024-02-25
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-25       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 别提了，这题虽然是看了labuladong后独立写出来，并硬用sout调试出来了，但坑很多，详见注释。另：有若干处可以优化，再写时看下Labuladong!要不最后改成通用的nSum?
 * @author: Admin
 * @create: 2024-02-25
 **/
public class LC15_3sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //注意1，一开始忘了先排序！
            Arrays.sort(nums);
            // for(int i =0;i<nums.length;i++){
            //     System.out.print(nums[i]+",");
            // }
            //System.out.println();
            for(int i=0;i<nums.length-1;i++){
                //System.out.println("### threeSum i: "+i);
                List<List<Integer>> twoSumResult = twoSum(nums, i+1, 0-nums[i]);
                for(List<Integer> onePair: twoSumResult){
                    //System.out.println("###nums[i]:   "+nums[i]+"###   "+onePair.get(0)+"###"+onePair.get(1));
                    onePair.add(nums[i]);
                    result.add(onePair);
                }
                //System.out.println("### for");
                while(i<nums.length-1){
                    if(nums[i]==nums[i+1]){
                        i++;
                    }else{
                        break;
                    }
                }
                //System.out.println("### while");
            }
            return result;
        }
        public List<List<Integer>> twoSum(int[] nums, int start, int target){
            List<List<Integer>> result = new ArrayList<>();
            int left=start, right=nums.length-1,mid=0;
            while(left<right){
                //System.out.println("###"+left+"###"+right);
                // mid=left+(right-left)/2;
                int tempSum = nums[left]+nums[right];
                //System.out.println("###########tempSum: "+tempSum+"###target: "+target);
                if(tempSum==target){
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[left]);
                    tempResult.add(nums[right]);
                    result.add(tempResult);
                    //System.out.println("###size: " +result.size());
                    left++;
                    right--;
                    while(left<nums.length-1){
                        //System.out.println("### while1 "+left);
                        //注意2：这里不能比left和left+1，因为上面已经对left++过了，而是要像下面这样写！否则会跳过正确的解
                        if(nums[left-1]==nums[left]){
                            left++;
                        }else{
                            break;
                        }
                    }
                    while(right>start){
                        //System.out.println("### while2 " + right);
                        //注意3： 这里不能比righ和right-1,因为right已经被--，而是要比right+1和right，否则会跳过正确的解
                        if(nums[right+1]==nums[right]){
                            right--;
                        }else{
                            break;
                        }
                    }
                }
                else if(tempSum<target){
                    left++;
                    while(left<nums.length-1){
                        //System.out.println("### while3 "+left+"### "+right);
                        if(nums[left-1]==nums[left]){
                            left++;
                        }else{
                            break;
                        }
                    }
                }
                else if(tempSum>target){
                    right--;
                    while(right>start){
                        //System.out.println("### while4 "+right);
                        if(nums[right+1]==nums[right]){
                            right--;
                        }else{
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}