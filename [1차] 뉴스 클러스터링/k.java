import java.util.*;

class Solution {
    private final int BASE = 65536;
    
    public int solution(String str1, String str2) {        
        List<String> set1 = toSet(str1);
        List<String> set2 = toSet(str2);
        
        List<String> union = union(set1, set2);
        
        if(union.isEmpty()) {
            return BASE;
        }
        
        List<String> intersection = intersection(set1, set2);
        
        return intersection.size() * BASE / union.size();
    }
    
    private List<String> union(List<String> set1, List<String> set2) {
        List<String> result = new ArrayList<>();
        List<String> set2Tmp = new ArrayList<>(set2);
        
        for (String a : set1) {
            result.add(a);
            set2Tmp.remove(a);
        }
        
        for (String a : set2Tmp) {
            result.add(a);
        }
        
        return result;
    }
    
    private List<String> intersection(List<String> set1, List<String> set2) {
        List<String> result = new ArrayList<>();
        List<String> set2Tmp = new ArrayList<>(set2);
        
        for(String a : set1) {
            if (set2Tmp.contains(a)) {
                result.add(a);
                set2Tmp.remove(a);
            }
        }
        
        return result;
    }
    
    private List<String> toSet(String str) {
        str = str.toLowerCase();
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < str.length() - 1; i++) {
            String sliced = str.substring(i, i + 2);
            if (isLowerCasedAlphaString(sliced)) {
                result.add(sliced);
            }
        }
        
        return result;
    }
    
    private boolean isLowerCasedAlphaString(String str) {
        for(char c : str.toCharArray()) {
            if (!('a' <= c && c <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
