import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = 0;
        for(int a : A){
            answer += (A[index]*B[(B.length-1)-index]);
            index++;
        }
        
        return answer;
    }
}
