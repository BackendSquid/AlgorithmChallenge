def findValueByPosition(n, position):
    row = position // n;
    col = position % n;
    return max(row, col) + 1;

def solution(n, left, right):
    answer = []
    for position in range(left, right + 1):
        answer.append(findValueByPosition(n, position))
    return answer
