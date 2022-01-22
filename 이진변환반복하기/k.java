import java.util.*;

class Solution {
    public int[] solution(String s) {
        String x = s;
        
        int count = 0;
        int removedZeros = 0;
        while (!x.equals("1")) {
            int prevLength = x.length();
            x = x.replaceAll("0", "");
            int c = x.length();
            
            x = Integer.toString(c, 2);
            
            removedZeros += prevLength - c;
            count++;
        }
        
        return new int[] {count, removedZeros};
    }
}
