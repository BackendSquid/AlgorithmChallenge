import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        str1 = str1.toUpperCase(Locale.ROOT);
        str2 = str2.toUpperCase(Locale.ROOT);

        substring(str1, map1);
        substring(str2, map2);

        int intersection = 0;
        int union = 0;
        for (String key : map1.keySet()) {
            union += map1.get(key);
        }
        for (String key : map2.keySet()) {
            if (map1.containsKey(key)) {
                int value1 = map1.get(key);
                int value2 = map2.get(key);
                intersection += Math.min(value1, value2);
                union += Math.max(value1, value2) - map1.get(key);
            } else {
                union += map2.get(key);
            }
        }

        if (union != 0) {
            answer = (int) ((double) intersection / union * 65536);
        }
        return answer;
    }

    private void substring(String str1, Map<String, Integer> map1) {
        for (int i = 0; i < str1.length() - 1; i++) {
            String substring = str1.substring(i, i + 2);
            if (substring.charAt(0) < 'A' || substring.charAt(0) > 'Z') continue;
            if (substring.charAt(1) < 'A' || substring.charAt(1) > 'Z') continue;
            map1.put(substring, map1.getOrDefault(substring, 0) + 1);
        }
    }
}
