def solution(k, dungeons):
    global answer
    answer = -1

    def dfs(cur, visited, cnt):
        global answer

        if cnt == len(dungeons):
            answer = cnt
            return True
        answer = max(cnt, answer)

        for i, dungeon in enumerate(dungeons):
            if visited[i] or dungeon[0] > cur:
                continue

            visited[i] = True
            if dfs(cur - dungeon[1], visited, cnt + 1):
                return True
            visited[i] = False

        return False

    dfs(k, [False for _ in range(len(dungeons))], 0)
    return answer

