package com.lb.leetcode;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 2021/2/21
 * Time: 7:09 PM
 * Author: afei
 */
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
}
