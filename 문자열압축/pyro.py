def solution(s):
    length = len(s)
    answer = length

    for segment_size in range(1, length // 2 + 1):
        segments = [s[i:i+segment_size] for i in range(0, length, segment_size)]
        compression = [[segments[0], 1]]

        for segment in segments[1:]:
            if compression[-1][0] == segment:
                compression[-1][1] += 1
            else:
                compression.append([segment, 1])

        compressed = ("").join([str(count) + segment if count > 1 else segment for segment, count in compression])
        answer = min(answer, len(compressed))

    return answer
