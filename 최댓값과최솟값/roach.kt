class Solution {
    fun solution(s: String): String {
        val split: List<Int> = s.split(" ").map { value -> value.toInt() };
        val sortedList = split.sorted();
        return "${sortedList[0]} ${sortedList.last()}"
    }
}