package com.lb.leetcode;

/**
 * Date: 2021/2/24
 * Time: 5:38 PM
 * Author: afei
 */
/**
 * leetcode 832 反转图像
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 * 过于简单
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null){
            return A;
        }
        int[][] B = new int [A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                B[i][A[0].length-j-1] = (A[i][j]-1)*(-1);
            }
        }
        return B;
    }
}
