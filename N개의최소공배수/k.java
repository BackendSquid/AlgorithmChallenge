class Solution {
  public int solution(int[] arr) {
      int lcm = 1;
      
      for (int num : arr) {
          lcm = lcm(lcm, num);
      }
      
      return lcm;
  }
  
  private int gcd(int a, int b) {
      if (a == b) {
          return a;
      }
      
      int bigger = Integer.max(a,b);
      int smaller = Integer.min(a, b);
      
      while (smaller != 0) {
          int n = bigger % smaller;
          bigger = smaller;
          smaller = n;
      }
      
      return bigger;
  }
  
  private int lcm(int a, int b) {
      return a * b / gcd(a, b);
  }
}
