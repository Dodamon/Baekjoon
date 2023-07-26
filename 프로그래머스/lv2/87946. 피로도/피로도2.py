from itertools import permutations

def solution(k, dungeons):
    answer = -1
    # python의 내장함수를 사용하는게 더 빠르다
    # n이 충분히 작아서 가능하다
    perms = permutations(dungeons, len(dungeons))
    
    for perm in perms:
        cur = k
        cnt = 0
        for dungeon in perm:
            if cur >= dungeon[0]:
                cur -= dungeon[1]
                cnt += 1
        answer = max(cnt, answer)
        if answer == len(dungeons):
            break
    return answer
