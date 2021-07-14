def solution(s):
    answer = len(s)
    result = ""

    for idx in range(1, len(s) // 2 + 1):
        count = 1
        temp = s[:idx]

        for i in range(idx, len(s), idx):
            if temp == s[i:i + idx]:
                count += 1
            else:
                if count != 1:
                    result += str(count) + temp
                else:
                    result += temp
                temp = s[i:i + idx]
                count = 1

        if count == 1:
            count = ""
        result += str(count) + temp
        answer = min(answer, len(result))
        result = ""

    return answer

