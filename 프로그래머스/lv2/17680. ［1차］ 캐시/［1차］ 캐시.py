import heapq
from collections import defaultdict

def solution(cacheSize, cities):
    answer = 0
    cache = []

    if cacheSize == 0:
        return len(cities) * 5

    for i, city in enumerate(cities):
        city = city.lower()
        # hit
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer += 1
        # miss
        else:
            if len(cache) == cacheSize:
                cache[:] = cache[1:]
            cache.append(city)
            answer += 5

    return answer