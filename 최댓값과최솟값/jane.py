def solution(s):
    answer = sorted(list(map(int, s.split(' '))))
    return str(answer[0]) + " " + str(answer[-1])
