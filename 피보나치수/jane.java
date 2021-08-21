class Solution {
    public int solution(int n) {
        return fibo(n);
    }

    public int fibo(int n) {
        int curr = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int temp = curr;
            curr = next;
            next = (temp + next) % 1234567;
        }

        return curr;
    }
}
