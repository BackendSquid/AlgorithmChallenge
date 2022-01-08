class Solution {
  private int zero = 0;
  private int one = 0;
  public int[] solution(int[][] arr) {
      zero = 0;
      one = 0;
      
      count(arr, 0, 0, arr.length);
      
      int[] answer = {zero, one};
      return answer;
  }
  
  private void count(int[][] arr, int rBase, int cBase, int n) {
      int zero = 0;
      int one = 0;
      
      for(int i = rBase; i < rBase + n; i++) {
          for(int j = cBase; j < cBase + n; j++) {
              if (arr[i][j] == 0) {
                  zero++;
              } else {
                  one++;
              }
              
          }
      }
      
      if (zero == 0 || one == 0) {
          this.zero += zero / (n * n);
          this.one += one / (n * n);
      } else {
          int half = n / 2;
          count(arr, rBase, cBase, half);
          count(arr, rBase + half, cBase, half);
          count(arr, rBase, cBase + half, half);
          count(arr, rBase + half, cBase + half, half);
      }
  }
}
