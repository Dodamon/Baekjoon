def next_permutation(s):
    # next permutation을 할때는 for 문이 아닌 while 문을 사용한다 
    i = len(s) - 1
    while i > 0 and s[i - 1] >= s[i]:
        i -= 1

    if i == 0:
        return "".join(s)

    j = len(s) - 1
    while s[i - 1] >= s[j]:
        j -= 1

    s[i - 1], s[j] = s[j], s[i - 1]
    return "".join(s[:i] + sorted(s[i:]))


def solution(n):
    binary = list(bin(n)[2:])
    answer = int("0b" + next_permutation(binary), 2)
    
    # next permutation을 이용해서 다음 오는 수중 가장 큰수를 구한다
    # 만약 nex permuatation으로 만든 숫자와 처음 숫자가 같다면 '0'을 추가하고 그 이후를 오름차순으로 정렬한다.
    
    if answer == n:
        answer = int("0b10" + "".join(sorted(binary[1:])), 2)
    return answer

