/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC912_sort_an_array
 * Date Created : 2024-03-27
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-27       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Random;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-27
 **/
public class LC912_sort_an_array {
    public static void main(String[] args) {
        SolutionMergeSort solutionMergeSort = new SolutionMergeSort();
        int[] nums = new int[]{5,2,3,1};
        Tools.listPriter(nums);
        solutionMergeSort.sortArray(nums);
        System.out.println("#");
        Tools.listPriter(nums);
    }
    //相比于labuladong，我更喜欢这篇题解：https://leetcode.cn/problems/sort-an-array/solutions/650112/dong-hua-mo-ni-yi-ge-kuai-su-pai-xu-wo-x-7n7g/
    class SolutionQuickSort {
        public int[] sortArray(int[] nums) {
            // 洗牌，将元素随机打乱，防止极端耗时的情况
            shufle(nums);
            // 搞了半天原来是这里length忘了-1，what the f**k am I doing?
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        public void sort(int[] nums, int i, int j) {
            if (i >= j) {
                return;
            }
            int p = patition(nums, i, j);
            sort(nums, i, p - 1);
            sort(nums, p + 1, j);
        }

        public int patition(int[] nums, int i, int j) {
            int pivot = nums[i];
            int index = i;
            while (i < j) {
                while (i < j && nums[j] >= pivot) {
                    j--;
                }
                // 需要i和j两侧都找到合适位置后，才交换，所以这里不必急于交换
                // swap(nums, i, j);

                // 对i的++要放在对j--的后面，反过来就不行，这是哪门子道理？？？
                /*
                 * 我是这样想的：如果基准元素是第一个元素，那遍历数组时就要从右边开始。如果基准元素从最后一个开始，遍历要从左边开始（可以自行验证）
                 * 假如有数组1，2，3，4，5，基准元素是第一个1，如果此时遍历数组从第一个开始，由于i++的条件是nums[i]<=pivot，
                 * 会导致i指向2，最后2和5会互换，这显然不是我们想要的，此次遍历元素应该都不动才对。而遍历从右边开始，就能避免这种情况
                 */

                // 注意结束条件是i<j而不是i<n
                while (i < j && nums[i] <= pivot) {
                    i++;
                }

                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, index, i);
            return i;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void shufle(int nums[]) {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int r = random.nextInt(nums.length - i);
                // 实践证明，下面这种随机，不如上面的效果好，用下面的随机，共耗时23ms，上面的随机，共耗时17ms
                // int r = random.nextInt(nums.length);
                // System.out.println(r);
                swap(nums, i, r);
            }
        }
    }

    //归并排序，思路相比快速排序要简单一些，但细心很重要，自己被自己的马虎搞了，1分钟写代码，10分钟调试！！！
    static class SolutionMergeSort {
        private static int[] temp;
        public int[] sortArray(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length-1);
            return nums;
        }
        public void sort(int[] nums, int left, int right){
            if(left>=right){
                return;
            }
            int mid = left+(right-left)/2;
            sort(nums, left, mid);
            sort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
        public void merge(int[] nums, int left, int mid , int right){
            for(int i = left; i<=right; i++){
                temp[i] = nums[i];
            }
            //合并两个有序数组，p负责遍历nums，i和j分别从两个待合并的数组头部开始遍历
            int i=left, j=mid+1;
            for (int p = left;p<=right;p++) {
                //System.out.println(i+"###"+j);
                //左边部分已全写入nums
                if(i>=mid+1){
                    nums[p]=temp[j];
                    j++;
                }
                //右边部分已全写入nums
                //这里竟然错把>=写成了<=，粗心！
                else if(j>=right+1){
                    nums[p] = temp[i];
                    i++;
                }
                //左边数组的元素比右边数组元素大，把较小的右边数组的元素放入nums
                else if(temp[i]>=temp[j]){
                    nums[p]=temp[j];
                    j++;
                }
                //左边数组的元素比右边数组元素小，把较小的左边数组的元素放入nums
                else{
                    //瞧瞧！错把temp写成了nums，what have you done!
                    //nums[p]=nums[i];
                    nums[p]=temp[i];
                    i++;
                }

            }
        }
    }
}