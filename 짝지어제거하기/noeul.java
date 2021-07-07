import java.util.*;

// 1. 2개 연속된 문자 검사
// 2. 연속된 문자 제거
// 3. 문자가 남아있지 않다면 1 리턴, 그렇지않으면 0 리턴

class Solution {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        char[] words = s.toCharArray();

        for(char word : words){
            if(!stack.empty() && stack.peek() == word){
                stack.pop();
            }
            else {  // 연속된 문자가 아닐 경우
                stack.push(word);
            }
        }

        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }

}
