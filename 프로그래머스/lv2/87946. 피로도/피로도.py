def solution(k, dungeons):
    global answer
    answer = -1

    def dfs(cur, visited, cnt):
        global answer
        
        # 만약에 모든 던전수를 갈 수 있는 방법이 나왔다면 바로 탐색을 끝낸다
        if cnt == len(dungeons):
            answer = cnt
            return True

        # 가장 많이 방문 할 수 있는 던전수를 갱신한다
        answer = max(cnt, answer)
        
        # for문을 통해 탐색하면서 갈수 있는 던전을 방문한다
        for i, dungeon in enumerate(dungeons):
            # 방문하지 못하는 던전이면 탐색을 계속한다
            if visited[i] or dungeon[0] > cur:
                continue
            
            # 방문 처리
            visited[i] = True
            if dfs(cur - dungeon[1], visited, cnt + 1):
                return True
            visited[i] = False

        return False

    dfs(k, [False for _ in range(len(dungeons))], 0)
    return answer

