from collections import defaultdict

def solution(n, build_frame):
    answer = []
    hashmap = defaultdict(int)
    
    def checkRow(x, y) -> bool:
        # 여기 보가 있는게 맞다면
        
        # 1. 보 아래에 기둥이 있거나
        # 2. 보 오른쪽 아래에 기둥이 있거나
        # 3. 보 양쪽에 보가 있거나
        if hashmap[(x, y-1, 0)] or hashmap[(x+1, y-1, 0)] or ( hashmap[(x-1, y, 1)] and hashmap[(x+1, y, 1)]):
            return True
        return False
        
    def checkCol(x, y) -> bool:
        # 여기 기둥이 있는게 맞다면
        # 1. 아래가 바닥이거나
        # 2. 왼쪽이 보이거나
        # 3. 오른쪽이 보이거나
        # 4. 아래가 기둥이다
        if y == 0 or hashmap[(x-1, y, 1)] or hashmap[(x, y, 1)] or hashmap[(x, y-1, 0)]:
            return True
        return False
    
    for x, y, a, b in build_frame: 
        # 기둥설치
        if b == 1 and a == 0 and checkCol(x, y):
            hashmap[(x, y, 0)] = 1

        # 보오설치
        elif b == 1 and a == 1 and checkRow(x, y):
            hashmap[(x, y, 1)] = 1
        
        # 기둥삭제
        elif b == 0 and a == 0:
            hashmap[(x, y, 0)] = 0
            if y+1 <= n and hashmap[(x, y+1, 0)] == 1 and not checkCol(x, y+1):
                hashmap[(x, y, 0)] = 1
                continue
                   
            if y+1 <= n and hashmap[(x, y+1, 1)] == 1 and not checkRow(x, y+1):
                hashmap[(x, y, 0)] = 1
                continue
                    
            if y+1 <= n and x-1 >= 0 and hashmap[(x-1, y+1, 1)] == 1 and not checkRow(x-1, y+1):
                hashmap[(x, y, 0)] = 1
                continue
            
        # 보오삭제
        elif b == 0 and a == 1:
            hashmap[(x, y, 1)] = 0
            
            if hashmap[(x, y, 0)] == 1 and not checkCol(x, y):
                hashmap[(x, y, 1)] = 1
                continue
                    
            if x+1 <= n and hashmap[(x+1, y, 0)] == 1 and not checkCol(x+1, y):
                hashmap[(x, y, 1)] = 1
                continue
                    
            if x+1 <= n and hashmap[(x+1, y, 1)] == 1 and not checkRow(x+1, y):
                hashmap[(x, y, 1)] = 1
                continue
                    
            if x-1 >= 0 and hashmap[(x-1, y, 1)] == 1and not checkRow(x-1, y):
                hashmap[(x, y, 1)] = 1
                continue

                
    for key in sorted(hashmap.keys()):
        if hashmap[key] != 0:
            answer.append([key[0], key[1], key[2]])
    return answer