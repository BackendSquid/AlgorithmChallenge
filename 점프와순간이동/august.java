public class Solution {
    public int solution(int n) {
        int ans = 0;
        ans = go(n, ans);
        return ans;
    }

    private int go(int n, int ans) {
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
