def solution(n):
    def rec(n, ans):
        if n < 1:
            return ans
        if (n % 2):
            return rec(n // 2, ans + 1)
        return rec(n // 2, ans)
    return rec(n, 0)
