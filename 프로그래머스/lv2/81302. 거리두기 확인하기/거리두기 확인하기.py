def solution(places):
    x = [0, 1, 0, -1]
    y = [-1, 0, 1, 0]
    diax = [1, 1, -1, -1]
    diay = [-1, 1, 1, -1]
    x2 = [0, 2,0,-2]
    y2 = [-2, 0, 2, 0]
    answer = []
    
    for room in places:
        isOkay = True
        for i in range(5):
            if isOkay == False:
                break
            for j in range(5):
                if room[i][j] == "P":
                    
                    for k in range(4):
                        n_y = int(i + y[k])
                        n_x = int(j + x[k])
                        if n_y < 0 or n_y > 4 or n_x < 0 or n_x > 4:
                            continue
                        if room[n_y][n_x] == "P":
                            isOkay = False
                            break
                        
                    for k in range(4):
                        n_y = int(i + diay[k])
                        n_x = int(j + diax[k])
                        if n_y < 0 or n_y > 4 or n_x < 0 or n_x > 4:
                            continue
                        if room[n_y][n_x] == "P":
                            if room[n_y][j] != "X" or room[i][n_x] != "X":
                                isOkay = False
                                
                    for k in range(4):
                        n_y = int(i + y2[k])
                        n_x = int(j + x2[k])
                        if n_y < 0 or n_y > 4 or n_x < 0 or n_x > 4:
                            continue
                        if room[n_y][n_x] == "P":
                            if i == n_y:
                                n_y = i
                                if j < n_x:
                                    n_x = j + 1
                                else:
                                    n_x = j -1           
                            else:
                                n_x = j
                                if i < n_y:
                                    n_y = i + 1
                                else:
                                    n_y = i -1
                                    
                            if room[n_y][n_x] != "X":
                                isOkay = False
        if isOkay:
            answer.append(1)
        else:
            answer.append(0)
    
    return answer