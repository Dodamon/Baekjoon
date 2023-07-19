def solution(numbers):
    answer = [-1 for _ in range(len(numbers))]
    stack = []

    for i, num in enumerate(numbers):
        while len(stack) > 0 and numbers[stack[-1]] < num:
            index = stack.pop()
            answer[index] = num
        stack.append(i)

    return answer
