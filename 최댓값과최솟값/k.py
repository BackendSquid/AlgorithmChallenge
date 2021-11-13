def solution(s):
    nums = list(map(int, s.split()))
    
    m = min(nums)
    M = max(nums)
    
    answer = str(m) + ' ' + str(M)
    return answer
