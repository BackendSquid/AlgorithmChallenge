class Solution {
    fun solution(A: Array<Int>, B: Array<Int>): Int {
        var answer: Int = 0;
        A.sorted();
        B.sorted();
        for (i: Int in 0..A.size) {
            answer += A[i] * B[(B.size-1)-i];
        }
        return answer;
    }
}