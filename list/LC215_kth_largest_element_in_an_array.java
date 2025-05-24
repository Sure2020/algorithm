/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC215_kth_largest_element_in_an_array
 * Date Created : 2024-03-28
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-28       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @program: PACKAGE_NAME
 * @description: 偷懒排序，小顶堆（优先队列），快速选择，需要练
 * @author: Admin
 * @create: 2024-03-28
 **/
public class LC215_kth_largest_element_in_an_array {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 排序
            // Arrays.sort(nums);
            // return nums[nums.length-k];
            // 小顶堆
            // PriorityQueue<Integer> pq = new PriorityQueue<>();
            // for(int i=0;i<nums.length;i++){
            //     pq.offer(nums[i]);
            //     if(pq.size()>k){
            //         pq.poll();
            //     }
            // }
            // return pq.peek();


            //快速选择算法

            // 假设升序排序，这里转换成找第k个元素
            k = nums.length-k;
            //System.out.println("###"+k);
            int p = 0;
            int left = 0,right = nums.length-1;
            shuffle(nums);
            while(left<=right){
                p = partition(nums, left, right);
                //System.out.println(p);
                //当目标元素下标比基准元素小，那目标元素肯定在基准元素左边
                if(k<p){
                    right=p-1;
                }
                //当目标元素下标比基准元素大，那目标元素肯定在基准元素右边
                else if(k>p){
                    left=p+1;
                } else{
                    return nums[p];
                }
            }
            return -10001;
        }
        public int partition(int[] nums, int i, int j){
            int pivot = nums[i];
            int start = i;
            while(i<j){
                //注意注意，这里大于等于和小于等于与下面的搞反了，一定要细心啊！
                while(i<j && nums[j]>=pivot){
                    j--;
                }
                while(i<j && nums[i]<=pivot){
                    i++;
                }
                if(i>=j){
                    break;
                }
                swap(nums,i,j);
                // i++;
                // j--;
            }
            swap(nums, start, i);
            return i;
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void shuffle(int[] nums){
            int n = nums.length;
            Random random = new Random();
            for(int i = 0;i<n; i++){
                int r = random.nextInt(n-i);
                swap(nums, i,r);
            }

        }
    }


    class Solution20240618 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue=new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                Integer num = nums[i];
                queue.offer(num);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
//用基于快速排序的快速选择，虽然曾经理解过，但记忆成本太高，果断舍得。。。
//这个就记住一点，用优先级队列

    class Solution20240619 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue  = new PriorityQueue<>((a,b)->a-b);
            for(int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
                if(queue.size()>k){
                    queue.remove();
                }
            }
            return queue.peek();
        }
    }
//利用小顶堆


    class Solution202407232115 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>((a, b)->b-a);

            for(int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
            }
            int count = 1;
            int i = 0;
            while(count <k){
                queue.poll();
                // queue.offer(nums[i]);
                // i++;
                count++;

            }
            return queue.poll();
        }
    }
//第一眼是动态规划，但没想起来用大顶堆这个奇技淫巧
//过程中的总结：记错了，大顶堆（优先队列）应该是PriorityQueue，而不是PriorityLinkedList,
//而且别忘了new 一下，自定义比较函数为(a,b)->b-a,意思是较大的优先

    class Solution202407232120 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
            for(int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
//做上一遍的时候就感觉到写复杂了，其实就是利用小顶堆，每次放入元素后再拿出元素，最后只剩下k个，那此时顶部的元素就是所求

    class Solution20241204 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
            for(int i:nums){
                queue.offer(i);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
//做上一遍的时候就感觉到写复杂了，其实就是利用小顶堆，每次放入元素后再拿出元素，最后只剩下k个，那此时顶部的元素就是所求
    class Solution20250517 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
            for(int i: nums){
                queue.offer(i);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }

    class Solution20250524 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
            for(int i=0;i<nums.length;i++){
                queue.offer(nums[i]);
                //这里不要写>=k,要时刻清楚要干嘛，而不是机械地去输出
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
}