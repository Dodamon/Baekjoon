def next_permutation(s):
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

    if answer == n:
        answer = int("0b10" + "".join(sorted(binary[1:])), 2)
    return answer

