def solution(files):
    answer = []
    
    for file in files:
        
        idxNum = 0
        for i in range(len(file)):
            if file[i].isdigit():
                idxNum = i
                break
        
        idxTail = len(file)-1
        for i in range(idxNum,len(file)):
            if not file[i].isdigit():
                idxTail = i
                break

        if idxTail == len(file)-1:
            idxTail += 1
            
        # head, number, tail을 찾아서 sort에 key설정을 통해 정렬한다
        # 이게 가능한 이유는 python의 sort는 stable헤서 입력으로 받은 순서를 유지하며 정렬을 하기 때문이다.
        head, number, tail = file[:idxNum], file[idxNum:idxTail], file[idxTail:]  
        answer.append((head, number, tail))
    
    answer.sort(key=lambda x: (x[0].lower(), int(x[1])))
    return  [''.join(file) for file in answer]
