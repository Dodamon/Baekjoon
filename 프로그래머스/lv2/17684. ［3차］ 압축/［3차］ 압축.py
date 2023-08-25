def solution(msg):
    answer = []
    idx = 1

    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    d = {k:v for (k,v) in zip(alphabet, list(range(1,27)))}
    
    w = 0
    idx = 27
    while w < len(msg):
        s = w + 1
        while s <= len(msg) and d.get(msg[w:s]) != None:
            s += 1
            
        answer.append(d[msg[w:s-1]])
        d[msg[w:s]] = idx
        idx += 1
        w += (s-w-1)
    
    return answer