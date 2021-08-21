def solution(info, query):
    answer = []

    info = [list(i.split()) for i in info]
    query = [list(i.split()) for i in query]

    dic = get_groups()

    for i in info:
        for l in [i[0], '-']:
            for p in [i[1], '-']:
                for c in [i[2], '-']:
                    for f in [i[3], '-']:
                        dic[(l, p, c, f)].append(int(i[4]))
    dic = {key: sorted(value) for key, value in dic.items()}

    for q in query:
        key = (q[0], q[2], q[4], q[6])
        results = dic[key]

        score = int(q[7])

        left = 0
        right = len(results)

        while left < right:
            mid = (left + right) // 2
            if results[mid] >= score:
                right = mid
            else:
                left = mid + 1

        answer.append(len(results) - left)
    return answer


def get_groups():
    dic = dict()

    language = ["cpp", "java", "python", "-"]
    part = ['backend', 'frontend', '-']
    career = ['junior', 'senior', '-']
    food = ['chicken', 'pizza', '-']

    for l in language:
        for p in part:
            for c in career:
                for f in food:
                    dic.setdefault((l, p, c, f), [])
    return dic
