#누적합 문제
from collections import defaultdict

def solution(play_time, adv_time, logs):
    # 시청자들의 누적 재생시간이 가장 큰 구간
    # 어떤 시청자가 시청을 시작할때 => 공익광고를 삽입할 시각
    
    HH, MM, SS = map(int, play_time.split(":"))
    play_time = HH * 60 * 60 + MM * 60 + SS
    HH, MM, SS = map(int, adv_time.split(":"))
    adv_time = HH * 60 * 60 + MM * 60 + SS
    
    if play_time == adv_time:
        return "00:00:00"
    
    # 초로 바꾼다
    dp = [0] * (play_time + 1)
    for i, log in enumerate(logs):
        start, end = log.split("-")
        H1, M1, S1 = map(int, start.split(":"))
        H2, M2, S2 = map(int, end.split(":"))
        start, end = H1*3600 + M1*60 + S1, H2*3600 + M2*60 + S2
        dp[start] += 1
        dp[end] -= 1

    
    for time in range(1, play_time+1):
        dp[time] += dp[time-1]
    
    # 0에서 광고를 시작했을때
    maxTime, maxTimeIdx = 0, 0
    nowTime = sum(dp[:adv_time])
    for i in range(adv_time-1, play_time+1):
        nowTime -= dp[i-adv_time]
        nowTime += dp[i]
        if nowTime > maxTime:
            maxTime = nowTime
            maxTimeIdx = i
    
    maxTimeIdx -= (adv_time-1)
    h = str(maxTimeIdx // 3600).zfill(2)
    maxTimeIdx %= 3600
    m = str(maxTimeIdx // 60).zfill(2)
    maxTimeIdx %= 60
    s = str(maxTimeIdx).zfill(2)

    return h + ":" + m + ":" + s