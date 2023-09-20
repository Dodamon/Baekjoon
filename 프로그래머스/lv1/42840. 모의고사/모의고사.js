function solution(answers) {
    var answer = [];
    let p1 = [1, 2, 3, 4, 5], p2 = [2, 1, 2, 3, 2, 4, 2, 5],
        p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    let cnt = [0, 0, 0]
    
    for (let i = 0; i < answers.length; i++){
        if (p1[i%5] == answers[i]){
            cnt[0] += 1;
        }
        if (p2[i%8] == answers[i]){
            cnt[1] += 1;
        }
        if (p3[i%10] == answers[i]){
            cnt[2] += 1;
        }
    }
    let max = Math.max(...cnt);
    for (let i = 0; i < 3; i++){
        if (cnt[i] == max) {
            answer.push(i+1)
        }
    }

    return answer;
}