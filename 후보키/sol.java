package progrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//@todo
public class Soluitiuon42890 {

    int colCount;
    int elemCount;
    List<List<String>> rel = new ArrayList<>();
    Set<List<Integer>> answerKey = new HashSet<>();

    //class Solution {
    public int solution(String[][] relation) {

        int answer = 0;
        colCount = relation[0].length;
        elemCount = relation.length; // 원소갯수

        //2D 배열을 >  2D 리스트로
        for (String[] strings : relation) {
            rel.add(Arrays.asList(strings));
        }


        // 모든 컬럼의 조합들을 구하기
        Set<List<Integer>> candyKeys = new HashSet<>();
        for (int i = 1; i <= colCount; i++) {//키의 조합원소는 1개부터 컬럼갯수까지
            boolean[] visisted = new boolean[colCount];
            dfs(candyKeys, visisted, i, 0);
        }


        // set의 갯수만큼 일일히 유일성을 체크
        //answerKey
        // list.contains 로 answerKey에 포함된게 하나라도 있으면 패스>> 메서드만들기


        return answer;

    }

    private void dfs(Set<List<Integer>> candyKeys, boolean[] visisted, int combi, int count) {
        if (count == combi) {
            List<Integer> integers = new ArrayList<>();
            //do some
            candyKeys.add(integers);
            return;
        } else {
            //for(visisted)
        }

    }


    public static void main(String[] args) {
        Soluitiuon42890 s = new Soluitiuon42890();
        String[][] ins = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        int temp = s.solution(ins);
        if (2 == temp) {
            System.out.println("OK");
            return;
        }
        System.out.printf("NG, return:%d \n", temp);
    }
}
