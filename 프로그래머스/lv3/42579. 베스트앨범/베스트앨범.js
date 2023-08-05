function solution(genres, plays) {
    return Object.values(
        genres.reduce((obj, cur, idx) => {
            obj[cur] = obj[cur] ? obj[cur] : {};
            obj[cur][idx] = plays[idx];
            return obj;
        }, {})
    )
        .sort((a, b) => {
            let sum1 = Object.values(a).reduce((a, b) => a + b);
            let sum2 = Object.values(b).reduce((a, b) => a + b);
            console.log(sum1, sum2);
            return sum2 - sum1;
        })
        .reduce((arr, cur) => {
            if (Object.keys(cur).length == 1) {
                arr.push(parseInt(Object.keys(cur)[0]))
            } else {
                const temp = Object.entries(cur).sort(([, a], [, b]) => b - a);
                arr.push(parseInt(temp[0][0]));
                arr.push(parseInt(temp[1][0]));
            }
            return arr;
        }, []);
}