package progrs;
//https://programmers.co.kr/learn/courses/30/lessons/12939
//최대값과 최소값
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution12939 {
    public String solution(String s) {
        if (s.length() == 1) {
            return s + " " + s;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqr = new PriorityQueue<>(Comparator.reverseOrder());

        for (String elem : s.split(" ")) {
            pq.add(Integer.parseInt(elem));
            pqr.add(Integer.parseInt(elem));
        }

        StringBuilder builder = new StringBuilder();
        return builder.append(pq.peek()).append(" ").append(pqr.peek()).toString();

    }

}
