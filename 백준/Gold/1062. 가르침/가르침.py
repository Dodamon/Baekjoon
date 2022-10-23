import sys
input = sys.stdin.readline

N, K = map(int, input().split())
inputs = [list(input().rstrip()) for _ in range(N)] 
result = 0

alphas = set()
words = []
for i in range(N):
    word = inputs[i][4:-4]
    words.append(word)
    for alpha in word:
        if alpha in 'acint':
            continue
        idx = ord(alpha) - ord('a')
        alphas.add(idx)
alphas = list(alphas)

if K < 5:
    print(0)
    exit()
if len(alphas) + 5 < K:
    print(N)
    exit()
K -= 5


def check():
    cnt = 0
    for word in words:
        islearned = True
        for alpha in word:
            idx = ord(alpha) - ord('a')
            if not learned[idx]:
                islearned = False
                break
        if islearned:
            cnt += 1
    return cnt

def backTracking(n, idx):
    global result

    if n == K:
        result = max(result, check())
        return

    for i in range(idx, len(alphas)):
        idx = alphas[i]
        if learned[idx]:
            continue
        learned[idx] = True
        backTracking(n+1, i+1)
        learned[idx] = False

learned = [False] * 26
for aplha in 'acint':
    idx = ord(aplha) - ord('a')
    learned[idx] = True

backTracking(0, 0)
print(result)
