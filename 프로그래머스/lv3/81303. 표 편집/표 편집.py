def solution(n, k, cmd):
    table = {i: [i - 1, i + 1] for i in range(n)}
    answer = ['O'] * n
    table[0] = [None, 1]
    table[n-1] = [n-2, None]
    removed_stack = []
    cur = k

    for c in cmd:
        if c == "C":
            answer[cur] = "X"
            prev, next = table[cur]
            removed_stack.append([prev, cur, next])

            if next == None:
                cur, table[prev][1] = prev, None
            elif prev == None:
                cur, table[next][0] = next, None
            else:
                cur, table[prev][1], table[next][0] = next, next, prev

        elif c == "Z":
            prev, now, next = removed_stack.pop()
            answer[now] = "O"
            if prev == None:
                table[next][0] = now
            elif next == None:
                table[prev][1] = now
            else:
                table[next][0] = now
                table[prev][1] = now

        else:
            c1, c2 = c.split(' ')
            c2 = int(c2)
            if c1 == 'D':
                for _ in range(c2):
                    cur = table[cur][1]
            else:
                for _ in range(c2):
                    cur = table[cur][0]
    return ''.join(answer)