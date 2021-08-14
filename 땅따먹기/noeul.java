package com.example.programmers.레벨2.땅따먹기;


public class Solution {
    int solution(int[][] land) {
        int answer = 0;
        final int MAX_ROW = land.length;

        int prevIndex = -1;

        for (int row = 0; row < MAX_ROW; row++) {
            prevIndex = findMaxIndex(land[row], prevIndex);

            answer += land[row][prevIndex];
        }

        return answer;
    }

    public static int findMaxIndex(int[] rows, int excludedIdx){
        int maxElement = 0;
        int index = -1;

        for(int col=0; col< rows.length; col++){
            if(col == excludedIdx){
                continue;
            }
            if(rows[col] > maxElement){
                maxElement = rows[col];
                index = col;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(new Solution().solution(in));
    }
}
