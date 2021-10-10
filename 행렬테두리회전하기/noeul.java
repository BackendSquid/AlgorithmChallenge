package com.example.programmers.레벨2.행렬테두리회전하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        Arrays.fill(answer, Integer.MAX_VALUE);

        initMatrix(rows, columns, matrix);

        int answerIndex = 0;
        for(int[] query : queries){
            int row1 = query[0]-1;
            int col1 = query[1]-1;
            int row2 = query[2]-1;
            int col2 = query[3]-1;

            int[][] matrixClone = new int[rows][columns];

            copyMatrix(rows, columns, matrix, matrixClone);


            for(int row= row1; row <= row2; row++){
                for(int col= col1; col <= col2; col++){

                    // 오른쪽 밀기
                    if(row == row1){
                        if(col == col1){
                            matrixClone[row][col] = matrix[row+1][col];
                            answer[answerIndex] = Math.min(answer[answerIndex], matrix[row+1][col]);
                        }else{
                            matrixClone[row][col] = matrix[row][col-1];
                            answer[answerIndex] = Math.min(answer[answerIndex], matrix[row][col-1]);
                        }
                    }

                    // 아래로 밀기
                    else if(col == col2){
                        matrixClone[row][col] = matrix[row-1][col];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row-1][col]);
                    }

                    // 왼쪽으로 밀기
                    else if(row == row2){
                        matrixClone[row][col] = matrix[row][col+1];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row][col+1]);
                    }

                    // 위로 밀기
                    else if(col == col1){
                        matrixClone[row][col] = matrix[row+1][col];
                        answer[answerIndex] = Math.min(answer[answerIndex], matrix[row+1][col]);
                    }
                }
            }

            copyMatrix(rows, columns, matrixClone, matrix);
            answerIndex++;
        }

        return answer;
    }

    private void copyMatrix(int rows, int columns, int[][] matrix, int[][] matrixClone) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrixClone[row][column] = matrix[row][column];
            }
        }
    }

    private void initMatrix(int rows, int columns, int[][] matrix) {
        int count = 1;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = count++;
            }
        }
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;

        int[][] queries = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        new Solution().solution(rows, columns, queries);
    }
}