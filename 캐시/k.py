def solution(cacheSize, cities):
    cache = {}
    
    def is_cache_hit(city):
        return city in cache

    def cache_LRU_update(city, time):
        cache[city] = time
    
    def is_cache_full():
        return len(cache) >= cacheSize

    def evict_cache():
        min_time = 100001
        victim = None
        for city, time in cache.items():
            if time >= min_time:
                continue
            min_time = time
            victim = city
        if victim != None:
            del cache[victim]
    
    def insert_cache(city, time):
        if is_cache_full():
            evict_cache()
        if len(cache) < cacheSize:
            cache[city] = time

    execution_time = 0
    for time, _city in enumerate(cities):
        city = _city.lower()
        if is_cache_hit(city):
            cache_LRU_update(city, time)
            execution_time += 1
            continue
        
        insert_cache(city, time)
        execution_time += 5
                
    return execution_time
