import java.util.*;

public class Solution {
    private static int[] table;
    public int solution(int n) {
        return bitCount(n);
    }
    
    private int bitCount(int n) {
        int result = 0;
        
        while(n > 0) {
            if (n % 2 == 1) {
                result++;
            }
            n /= 2;
        }
        
        return result;
    }
    
    private int dp(int n) {
        table = new int[n + 1];

        for(int distance = 1; distance <= n; distance++) {
            table[distance] = Math.min(teleport(distance), distance);
        }

        return table[n];
    }
    
    private int teleport(int n) {
        int half = n / 2;
        int remain = n % 2;
        
        return table[half] + remain;
    }
    
    
}
