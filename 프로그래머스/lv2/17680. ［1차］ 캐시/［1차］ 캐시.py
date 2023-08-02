import heapq
from collections import OrderedDict

def solution(cacheSize, cities):
    answer = 0
    cache = OrderedDict()

    if cacheSize == 0:
        return len(cities) * 5

    for i, city in enumerate(cities):
        city = city.lower()
        # hit
        if city in cache:
            cache.pop(city)
            answer += 1
        # miss
        else:
            if len(cache) == cacheSize:
                cache.popitem(last=False)
            answer += 5
        cache[city] = i
        
    return answer