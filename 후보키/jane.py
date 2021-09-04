# 키 조합을 만들고 원소 수를 세어서 전체 데이터 수와 같으면 유일성 보장, 더 작은 부분집합 존재하면 제거하면 최소성 보장

from itertools import combinations


def solution(relation):
    answer = 0
    key_index = []
    keys = []
    for i in range(len(relation[0])):
        key_index.append(i)
    for i in range(1, len(relation[0]) + 1):
        keys.extend(list(combinations(key_index, i)))

    unique_key = []
    for key in keys:
        temps = set()
        for row in relation:
            temp = tuple()
            for i in key:
                temp += tuple(row[i])
            temps.add(temp)
        if len(temps) == len(relation):
            unique_key.append(key)

    uk_set = [set(uk) for uk in unique_key]

    for i in range(len(uk_set)):
        for j in range(i + 1, len(uk_set)):
            if uk_set[i].issubset(uk_set[j]):
                uk_set[j] = {-1}

    for u in uk_set:
        if list(u)[0] != -1:
            answer += 1
    return answer


solution([["100", "ryan", "music", "2"], ["200", "apeach", "math", "2"], ["300", "tube", "computer", "3"],
          ["400", "con", "computer", "4"], ["500", "muzi", "music", "3"], ["600", "apeach", "music", "2"]])
