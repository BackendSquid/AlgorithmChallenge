import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int round = 0;
        int drop = 0;
        boolean isDropped = false;

        Set<String> set = new HashSet<>();
        char last = '0';
        for (String word : words) {
            if (last != '0' && (last != word.charAt(0) || set.contains(word))) {
                isDropped = true;
                break;
            }
            last = word.charAt(word.length() - 1);
            set.add(word);
            drop = (drop + 1) % n;
            round++;
        }

        if (isDropped) {
            answer[0] = drop + 1;
            answer[1] = round / n + 1;
        }
        return answer;
    }
}
