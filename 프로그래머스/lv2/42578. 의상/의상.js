function solution(clothes) {
    var answer = 1;
    let map = new Map();

    for (let i = 0; i < clothes.length; i++) {
        [value, key] = clothes[i];
        map.set(key, (map.get(key) || 0) + 1);
    }

    for ([k, v] of map) {
        answer = answer * (v + 1);
    }

    return answer - 1;
}