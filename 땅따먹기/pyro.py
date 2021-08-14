# https://programmers.co.kr/learn/courses/30/lessons/12913

def solution(land):
    i_len = len(land)
    j_len = len(land[0])
    for i in range(1, i_len):
        for j in range(j_len):
            land[i][j] += max(land[i-1][:j] + land[i - 1][j+1:])
    return max(land[-1])
