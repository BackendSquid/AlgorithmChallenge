def solution(n):
    bit_count = bitCount(n)
    
    candidate = n + 1
    
    while candidate <= 1_000_001:
        if (bitCount(candidate)==bit_count):
            return candidate
        candidate += 1
    return 0

def bitCount(n):
    answer = 0
    while n > 0:
        if n % 2 == 1:
            answer += 1
        n = n // 2
    return answer
