from collections import deque


def solution(cacheSize, cities):
    cache = deque()

    time = 0
    for city in cities:
        city = city.lower()

        if city in cache:
            cache.remove(city)
            time += 1
        else:
            if cacheSize == 0:
                time += 5
                continue
            if len(cache) == cacheSize:
                cache.popleft()
            time += 5
        cache.append(city)
    return time
