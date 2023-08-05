import heapq

def solution(operations):
    answer = [0, 0]
    max_heap = []
    min_heap = []
    popped = [False for _ in range(len(operations))]
    # heappush: maxheap과 minheap을 만들어서 둘모두에게 push한다 
    # popped를 체크해서 pop된 node인지 아닌지 체크한다
    
    # heappop: 이미 popped된 node이면 계속해서 pop한다
    for i, op in enumerate(operations):
        cmd, num = op.split(" ")
        
        if cmd == 'I':
            heapq.heappush(min_heap, (int(num), i))
            heapq.heappush(max_heap, (int(num) * -1, i))
            
        elif cmd == 'D' and num == '1' and max_heap:
            node, i = heapq.heappop(max_heap)
            while max_heap and popped[i]:
                node, i = heapq.heappop(max_heap)
            popped[i] = True
            
        elif cmd == 'D' and num == '-1' and min_heap:
            node, i = heapq.heappop(min_heap)
            while min_heap and popped[i]:
                node, i = heapq.heappop(min_heap)
            popped[i] = True
    
    # 모든 연산이 끝나고 최소, 최대 값을 저장한다
    if not max_heap or not min_heap:
        return answer
    # 최대값
    node, i = heapq.heappop(max_heap)
    while max_heap and popped[i]:
        node, i = heapq.heappop(max_heap)
    answer[0] = node * -1
    # 최소값
    node, i = heapq.heappop(min_heap)
    while min_heap and popped[i]:
        node, i = heapq.heappop(min_heap)
    answer[1] = node
    
    return answer