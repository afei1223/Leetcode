package com.lb.leetcode;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * Date: 2021/2/21
 * Time: 7:09 PM
 * Author: afei
 */
/**
 * 绝对差不超过限制的最长连续子数组
 * leetcode 1438
 * 数据结构 + 滑动窗口
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * 感兴趣可以看下我的超时代码，主要是排序花了太多时间，这里不能每轮都去排个序。
 * 每个数据进来之前，把他前面比他小的都扔出去，反正等这个数据被从前头扔出去的时候，在他前面的那些数据也已经在左边界的左边了。
 * 这样只会只弹nums.length()次，和每轮对一堆无用数据排序相比好太多了。
 * */
public class Solution1438 {
    //对输入的数据进行处理
    public int solution(String s, String s1, Activity activity){

        if(s==null&&s.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        if(s1==null&&s1.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        int k = Integer.parseInt(s1);
        char[] chars = s.toCharArray();
        int[] a = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            a[i] = chars[i] - '0';
        }
        return longestSubarray(a,k);
    }


    public int longestSubarray(int[] nums, int limit) {
        List<Integer> maxNum = new ArrayList<>();
        int left = 0;
        for(int right=0;right<nums.length;right++){
            maxNum.add(nums[right]);
            Collections.sort(maxNum);
            if(maxNum.get(maxNum.size() - 1) - (maxNum.get(0) ) > limit){
                for(int i=0;i<maxNum.size();i++){
                    if(nums[left] == maxNum.get(i)){
                        maxNum.remove(i);
                        break;
                    }
                }
                left++;
            }
        }
        return nums.length-left;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        for (int r = 0, l = 0; r < n; r++) {
            while (!max.isEmpty() && nums[r] >= nums[max.peekLast()]) max.pollLast();
            while (!min.isEmpty() && nums[r] <= nums[min.peekLast()]) min.pollLast();
            max.addLast(r);
            min.addLast(r);
            while (Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit) {
                l++;
                if (max.peekFirst() < l) max.pollFirst();
                if (min.peekFirst() < l) min.pollFirst();
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
