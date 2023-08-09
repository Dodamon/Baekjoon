import collections
def solution(topping):
    answer = 0
    
    # right가 동생의 롤케이크의 토핑 갯수를 count한 hashmap
    # left가  철수의 롤케이크의 토핑 갯수를 count한 hashmap
    right = collections.Counter(topping)
    left = collections.defaultdict(int)
    
    # for문을 통해 왼쪽에서 오른 쪽으로 이동하면서
    # 철수의 토핑갯수가 늘어나고 동생의 토핑 갯수는 줄어든다
    for i, t in enumerate(topping):
        # 동생의 토핑갯수가 1이라면 딕셔너리에서 아예제거한다
        if right[t] == 1:
            right.pop(t)
        else:
            right[t] -=1
        # 철수의 토핑갯수는 늘어난다
        left[t] += 1
        
        # 막약 둘의 토핑갯수가 같다면 경우의 수가 하나씩 늘어나게된다
        if len(right) == len(left):
            answer += 1
        elif len(right) < len(left):
            break
            
    return answer