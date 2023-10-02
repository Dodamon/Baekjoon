function solution(citations) {
    var answer = 0;
    let n = citations.length;
    citations.sort((a, b) => a - b);
    for (let h = n; h > 0; h--) {
        if (citations[n-h] >= h){
            return h
        }
    }
    return 0
}