def solution(arr1, arr2):
    answer = [[0] * len(arr2[0]) for _ in range(len(arr1))]

    for i in range(len(arr1)):
        idx = 0
        for j in range(len(arr2[0])):
            _sum = 0
            for k in range(len(arr1[0])):
                _sum += arr1[i][k] * arr2[k][idx]
            answer[i][j] = _sum
            idx += 1
            
    return answer
