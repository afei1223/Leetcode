package com.lb.leetcode;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2021/2/20
 * Time: 3:13 PM
 * Author: afei
 */

/**
 *
 * leetcode 695
 * https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * 没啥好讲的
 *
 * 优秀题解
 * https://leetcode-cn.com/problems/degree-of-an-array/solution/shu-zu-ji-shu-ha-xi-biao-ji-shu-jie-fa-y-a0mg/
 * */
public class Solution697 {

    //对输入的数据进行处理
    public int solution(String s, Activity activity){

        if(s==null&&s.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] a = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            a[i] = chars[i] - '0';
        }
        return findShortestSubArray(a);
    }

    private int findShortestSubArray(int[] nums) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        int j = 0;
        for(int i : nums){
            hashMap.put(""+j,i);
            j++;
        }
        Map<Integer,Integer> res=new HashMap<>();
        int max = 1;
        for (Map.Entry<String,Integer> entry:hashMap.entrySet()){
            if (res.containsKey(entry.getValue())){
                res.put(entry.getValue(),res.get(entry.getValue())+1);
                if(max<res.get(entry.getValue())){
                    max = res.get(entry.getValue());
                }
            }else{
                res.put(entry.getValue(),1);
            }
        }
        List<Integer> maxNum = new ArrayList();
        for(int key: res.keySet()){
            if(res.get(key).equals(max)){
                maxNum.add(key);
            }
        }
        int first = 0;
        int last = 0;
        int result;
        int minresult = 50001;
        for(int i : maxNum){
            int maxflag = max;
            for(j=0;j<nums.length;j++){
                if(nums[j] == i){
                    if(maxflag == max){
                        first = j;
                    }
                    maxflag --;
                    if(maxflag == 0){
                        last = j;
                    }
                }
            }
            result = last-first+1;
            if(minresult>result){
                minresult = result;
            }
        }
        Log.i(StaticFun.TAG,res+"!");
        return minresult;
    }

}
