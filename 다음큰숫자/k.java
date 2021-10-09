class Solution {
  public int solution(int n) {
    int bitCount = Integer.bitCount(n);

    int number = n + 1;
    while (number < 1_000_001) {
      if (Integer.bitCount(number) == bitCount) {
        return number;
      }
      number++;
    }
    return 0;
  }
}
