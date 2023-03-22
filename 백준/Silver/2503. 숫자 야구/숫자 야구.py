import sys
input = sys.stdin.readline

list = []
N = int(input())
answer = 0

for i in range(N):
    n, s, b = input().split()
    s = int(s)
    b = int(b)
    list.append([n, s, b])


for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):

            # 숫자 만들기 i,j,k
            if i == j or i == k or j == k : continue

            for num, s, b in list:
                count_s = 0
                count_b = 0
                isok = True

                n = int(num[0])
                if n == i:
                    count_s += 1
                elif n == j or n == k:
                    count_b += 1

                n = int(num[1])
                if n == j:
                    count_s += 1
                elif n == i or n == k:
                     count_b += 1

                n = int(num[2])
                if n == k:
                    count_s += 1
                elif n == i or n == j:
                    count_b += 1


                if count_b != b or count_s != s :
                    isok = False
                    break 

            if isok == True:
                answer += 1


print(answer)
            


                