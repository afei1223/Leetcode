package com.lb.leetcode;

/**
 * Date: 2021/2/22
 * Time: 2:12 PM
 * Author: afei
 */
public class Solution766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
