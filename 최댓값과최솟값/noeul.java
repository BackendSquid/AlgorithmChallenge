import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] split = s.split(" ");
        int[] number = new int[split.length];
        
        int index =0;
        for(String num : split){
            number[index] = Integer.parseInt(num);  
            index++;
        }
        
        Arrays.sort(number);
    
        return number[0]+" "+number[number.length-1];
    }
}
