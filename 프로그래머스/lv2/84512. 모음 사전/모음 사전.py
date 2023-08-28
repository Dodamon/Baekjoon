def solution(word):
    answer = 0
    d = dict()
    alpha = ['A', 'E', 'I', 'O', 'U']
    
    def combination(w, idx):
        d[w] = idx
        if len(w) == 5:
            return idx
        
        for i in range(5):
            idx += 1
            idx = combination(w + alpha[i], idx)
        
        return idx
    
    combination('', 0)
    answer = d[word]
    return answer