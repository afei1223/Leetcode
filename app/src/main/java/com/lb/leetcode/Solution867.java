package com.lb.leetcode;

/**
 * Date: 2021/2/25
 * Time: 9:06 AM
 * Author: afei
 */
/**
 * leetcode 8667 转置矩阵
 * https://leetcode-cn.com/problems/transpose-matrix/submissions/
 *
 * 过于简单
 * */
public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int[][] newMartix = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                newMartix[j][i] = matrix[i][j];
            }
        }
        return newMartix;
    }
}
