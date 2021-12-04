class Solution {
  public int[] solution(int n, long left, long right) {
      int length = (int) (right - left + 1);
      int[] answer = new int[length];
      
      for (int i = 0; i < length; i++) {
          long position = left + i;
          
          answer[i] = findValue(n, position);
      }
      return answer;
  }
  
  private int findValue(int n, long position) {
      long row = position / n;
      long col = position % n;
      return (int) Long.max(row, col) + 1;
  }
}
