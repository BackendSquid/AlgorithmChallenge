import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];


        for (int row = 0; row < arr1.length; row++) {
            Queue<Integer> queue = new LinkedList<>();

            for (int col = 0; col < arr1[0].length; col++) {
                queue.add(arr1[row][col]);
            }

            for (int col2 = 0; col2 < arr2[0].length; col2++) {
                for (int row2 = 0; row2 < arr2.length; row2++) {

                    if (!queue.isEmpty()) {
                        int temp = queue.poll();
                        answer[row][col2] += temp * arr2[row2][col2];
                        queue.add(temp);
                    }
                }
            }

        }
        
        /*
           for(int i=0; i<arr1.length; i++){
             for(int j=0; j<arr2[0].length; j++){
                for(int k=0; k<arr1[0].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
             }
           } 
        */
        return answer;
    }
}
