def solution(s):
    answer = len(s)

    for l in range(1, len(s)//2+1):
        stack = []

        count = 1
        result = 0
        for i in range(0, len(s), l):
            word = s[i: i+l]
            if len(stack) == 0:
                stack.append(word)
                result += l
            else:
                if stack[-1] == word:
                    count += 1
                else:
                    if count != 1:
                        result += len(str(count))
                    count = 1
                    result += len(word)
                    stack.append(word)
                    
        if count != 1:
            result += len(str(count))

        answer = min(result, answer)
    return answer