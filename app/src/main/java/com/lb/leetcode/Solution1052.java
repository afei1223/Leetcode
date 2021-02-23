package com.lb.leetcode;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

/**
 * Date: 2021/2/23
 * Time: 9:45 AM
 * Author: afei
 */
/**
 * leetcode 1052
 * 爱生气的书店老板
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 *
 * 也是滑动窗口的变形，还是讲一些解题思路吧。
 *
 * 如题所述，有两条数组表示顾客数量和老板生气的时间。
 * 两条数组相乘就可以得出一条数组，即为老板生气时赶走的客人。
 * 题目求，让满意的客人最多，也就是赶走的客人最少，也就是老板在x分钟内赶走的客人最多
 * 有一点点绕，说白了就是，如果x为0，那么老板不管做什么，不满意的客人都是这么多，
 * 如果x为1，那么老板肯定会选客人最多的那一分钟内不生气。
 * 看到这里如果还没理解，建议多看几遍，理解了之后继续往下看。
 * 从上面得知，现在的目标是求，x分钟内，老板赶走的最多的客人。
 * 那么套滑动窗口， 窗口滑动的条件就是right-left>=x的时候，
 * 算出被赶走最多的客人之后就是加法了。
 * 先求出老板没有克制下，不生气的顾客，这里一个小窍门。
 * 因为统计的是老板生气的数组，1为生气0不生气，那么需要把他们反一下，
 * 做if判断的话显得不是很酷，用(a-1)*(-1)即可。
 * 算出正常情况下满意的客人之后，还有一个值，就是被老板赶走最多的人，
 * 这两个值直接相加就是结果。
 * */
public class Solution1052 {

    //对输入的数据进行处理
    public int solution(String s,String s2, String s1, Activity activity){

        if(s==null&&s.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        if(s1==null&&s1.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        if(s2==null&&s1.equals("")){
            Toast.makeText(activity,"不能为空！",Toast.LENGTH_LONG).show();
            return 0;
        }
        int k = Integer.parseInt(s1);
        char[] chars = s.toCharArray();
        int[] a = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            a[i] = chars[i] - '0';
        }
        chars = s2.toCharArray();
        int[] b = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            b[i] = chars[i] - '0';
        }
        return maxSatisfied(a,b,k);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int [] leaveCustomers = new int[customers.length];
        for(int i=0;i<customers.length;i++){
            leaveCustomers[i] = customers[i]*grumpy[i];
        }
        int maxLeaveCustomer = 0,leaveCustomer = 0,left=0;
        int notLeaveCustomer = 0;
        for(int right=0;right<leaveCustomers.length;right++){
            if(right - left>=X){
                int i = leaveCustomer - leaveCustomers[left];
                leaveCustomer = i;
                left++;
            }
            notLeaveCustomer += (grumpy[right]-1)*(-1)*customers[right];
            leaveCustomer += leaveCustomers[right];
            if(maxLeaveCustomer < leaveCustomer){
                maxLeaveCustomer = leaveCustomer;
            }
        }
        return notLeaveCustomer+maxLeaveCustomer;
    }
}
