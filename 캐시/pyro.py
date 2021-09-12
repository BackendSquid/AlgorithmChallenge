from collections import deque

def solution(cacheSize, cities):    
    if cacheSize < 1:
        return len(cities) * 5
    
    answer = 0
    cache = deque()
    for city in [city.upper() for city in cities]:
        if city in cache:
            answer += 1
            cache.remove(city)
        else:
            answer += 5
            if len(cache) >= cacheSize:
                cache.popleft()
        cache.append(city)
    return answer
