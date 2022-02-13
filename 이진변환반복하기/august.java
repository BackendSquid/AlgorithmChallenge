class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int removed = 0;
        
        while (!s.equals("1")) {
            int length = s.length();
            s = s.replace("0", "");
            removed += length - s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = removed;
        return answer;
    }
}
