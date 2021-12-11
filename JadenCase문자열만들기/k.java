class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        
        charArrayToJadenCase(charArray);
        
        String answer = new String(charArray);
        return answer;
    }
    
    private void charArrayToJadenCase(char[] charArray) {
        ParseJadenCaseState state = ParseJadenCaseState.UPPER;
        
        for(int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            charArray[i] = state.transform(currentChar);
            state = state.next(currentChar);
        }
    }
    
    private enum ParseJadenCaseState {
        UPPER, LOWER;
        
        public char transform(char c) {
            if (this == UPPER) {
                return Character.toUpperCase(c);
            }
            return Character.toLowerCase(c);
        }
        
        public ParseJadenCaseState next(char c) {
            if (c == ' ') {
                return UPPER;
            }
            
            return LOWER;
        }
    }
}
