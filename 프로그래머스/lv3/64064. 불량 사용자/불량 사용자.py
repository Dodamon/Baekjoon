import re
global answer

def dfs(visited, cur, matched, n, path):
    global answer
    
    # 모든 자리가 차면
    # set에 넣어서 만든적이 있는 경우의 수인지 확인한다
    if cur == n:
        answer.add(''.join(str(s) for s in sorted(path)))
        return
    
    # dfs 탐색을 계속한다
    for id in matched[cur]:
        if not visited[id]:
            visited[id] = True
            path[cur] = id
            dfs(visited, cur+1, matched, n, path)
            visited[id] = False

def solution(user_id, banned_id):
    global answer
    answer = set()
    # matched : 각 banned id에 해당 될수 있는 userid를 저장한다
    B = len(banned_id)
    matched = [[] for _ in range(B)]
    
    # regular expression을 사용해서 각 패턴에 포함되는 id를 구한다
    for i, banned in enumerate(banned_id):
        # regular expression으로 바꾼다
        banned = banned.replace("*", "\w")
        for j, user in enumerate(user_id):
            if re.fullmatch(banned, user):
                matched[i].append(j)
    
    # 제재 아이디 목록을 만든다
    dfs([False] * len(user_id), 0, matched, B, [0]*B)
    return len(answer)