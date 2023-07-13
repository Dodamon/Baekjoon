def solution(sequence, k):
    answer = []

    left, right = 0, 0
    total = 0
    answer_left, answer_right = 0, len(sequence)

    while left <= right:
        if total == k:
            if answer_right - answer_left > right - left - 1:
                answer_left = left
                answer_right = right - 1
            total -= sequence[left]
            left += 1
        
        elif total < k:
            if right == len(sequence): break
            total += sequence[right]
            right += 1
        
        else:
            total -= sequence[left]
            left += 1

    return [answer_left, answer_right]

