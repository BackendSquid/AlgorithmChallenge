class Solution {
  private final static int BASE = 1_234_567;
  public int solution(int n) {
      int fn_2 = 0;
      int fn_1 = 1;
      int fn = 0;
      
      for (int i = 2; i <= n; i++) {
          fn = (fn_1 + fn_2) % BASE;
          fn_2 = fn_1;
          fn_1 = fn;
      }
      return fn;
  }
}
