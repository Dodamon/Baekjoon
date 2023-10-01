from collections import Counter

def solution(m, musicinfos):
    answer = '(None)'
    infos = []
    
    # 입력된 데이터를 편집한다
    for info in musicinfos:
        # 시간을 편집한다
        start, end, title, music = info.split(",")
        start_HH, start_MM = map(int, start.split(":"))
        end_HH, end_MM = map(int, end.split(":"))
        start = start_HH*60 + start_MM
        end = end_HH*60 + end_MM
        term = end - start
        
        # 음악을 편집한다 : 음중간에 "+"를 넣는다 , 반복되면 반복되는 구간을 더해준다
        l = []
        i = 0
        new_music = "+"
        while i < len(music):
            note = music[i]
            if i < len(music)-1 and music[i+1] == '#':
                note += music[i+1]
                i += 2
            else:
                i += 1
            l.append(note)
        
        if term < len(l):
            new_music += "+".join(l[:term])
        else:
            new_music += "+".join(l * (term // len(l)))
            new_music += "+"
            new_music += "+".join(l[:term%len(l)])
            
        infos.append((start, end, title, new_music + "+"))
    infos.sort(key = lambda x: (x[0]-x[1], x[0]))
    
    # 네오가 기억한 멜로디를 편집한다 : 음중간에 "+"를 넣는다
    i = 0
    new_m = "+"
    while i < len(m):
        if i < len(m)-1 and m[i+1] == '#':
            new_m += m[i] + m[i+1] + "+"
            i += 2
        else:
            new_m += m[i] + "+"
            i += 1
            
    # 그 음을 찾으면 바로 출력한다
    for start, end, title, music in infos:
        if new_m in music:
            answer = title
            break
    
    return answer