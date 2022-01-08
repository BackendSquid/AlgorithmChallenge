import java.util.*;

public class Solution {
    
    private int rec(int n, int ans) {
        if (n < 1) {
            return ans;
        }
        if (n % 2 == 0) {
            return rec(n / 2, ans);
        }
        return rec(n /2, ans + 1);
    }
    
    public int solution(int n) {
        return rec(n, 0);
    }
}
