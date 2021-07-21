import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int length = s.length();
        
        for (int windowSize = 1; windowSize <= length; windowSize++) {
            answer = Math.min(zip(s, windowSize), answer);
        }
        
        return answer;
    }
    
    private int zip(String s, int windowSize) {
        StringBuilder zipped = new StringBuilder();
        
        int count = 1;
        String window = s.substring(0, windowSize);
        String currentWindow = window;
        for (int i = windowSize; i < s.length(); i += windowSize) {
            if (i + windowSize >= s.length()) {
                currentWindow = s.substring(i, s.length());
            } else {
                currentWindow = s.substring(i, i + windowSize);
            }
            
            if (window.equals(currentWindow)) {
                count++;
            } else {
                if (count == 1) {
                    zipped.append(window);
                } else {
                    zipped.append(count)
                        .append(window);
                    count = 1;
                }
            }
            window = currentWindow;
        }
        
        if (count == 1) {
            zipped.append(window);
        } else {
            zipped.append(count)
                .append(window);
        }
        
        return zipped.length();
    }
    
}
