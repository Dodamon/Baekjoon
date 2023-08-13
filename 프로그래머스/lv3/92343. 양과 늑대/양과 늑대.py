def solution(info, edges):
    global answer
    answer = 0
    visited = [False for _ in range(len(info))]
    
    # DFS 탐색
    def dfs(sheep, wolf):
        global answer
        
        if sheep > wolf:
            answer = max(answer, sheep)
        else:
            return
        
        # edges 정보를 모두 돌면서 갈 수 있는 노드들을 간다
        for p, c in edges:
            if visited[p] and not visited[c]:
                visited[c] = True
                if info[c] == 0:
                    dfs(sheep + 1, wolf)
                else:
                    dfs(sheep, wolf + 1)
                visited[c] = False
    
    visited[0] = True
    dfs(1, 0)
    return answer