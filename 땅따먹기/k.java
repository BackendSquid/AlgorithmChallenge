class Solution {
  int solution(int[][] land) {
      int N = land.length;
      int answer = 0;
      
      int[] point = land[0].clone();
      
      for (int i = 1; i < N; i++) {
          int[] row = land[i];
          int[] prevMax = point.clone();
          for (int j = 0; j < 4; j++) {
              int max = 0;
              for (int k = 0; k < 4; k++) {
                  if (j == k) continue;
                  max = Math.max(max, prevMax[k]);
              }
              point[j] = row[j] + max;
          }
      }
      
      
      for (int i = 0; i < 4; i++) {
          answer = Math.max(answer, point[i]);
      }

      return answer;
  }
}
