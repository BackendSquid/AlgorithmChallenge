def solution(A,B):
    a = sorted(A)
    b = sorted(B, key=lambda x : -x)
    
    answer = 0

    for i in range(len(a)):
        answer += a[i] * b[i]

    return answer
