def solution(sequence):
    # 누적합을 사용해서 풀이한다
    # 누적합을 사용하면 O(n^2)의 시간복잡도를 O(n)으로 줄일 수 있다
    arr1 = [num * (-1) ** i for i, num in enumerate(sequence)]
    arr2 = [num * (-1) ** (i+1) for i, num in enumerate(sequence)]

    dp1 = [0]
    dp2 = [0]
    for i in range(len(sequence)):
        dp1.append(max(dp1[i] + arr1[i], arr1[i]))
        dp2.append(max(dp2[i] + arr2[i], arr2[i]))

    answer = max(max(dp1), max(dp2))
    return answer
