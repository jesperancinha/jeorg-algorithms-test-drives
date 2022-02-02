const {msg} = require("@babel/core/lib/config/validation/option-assertions");
let maxActivities = (start, end) => {
    let i, j, tasks = 0, n = start.length;
    i = 0;
    for (j = 1; j < n; j++) {
        if (start[j] >= end[i]) {
            i = j;
            tasks++;
        }
    }
    return tasks;
}

let nonGreedy = (start, end) => {
    let map = new Map();
    for (let i = 0; i < start.length; i++) {
        let newList = map.get(end[i]);
        if (!newList) {
            newList = [];
        }
        newList.push(start[i]);
        map.set(end[i], newList);
    }
    end = [...map.keys()].map(key => map.get(key).map(() => key)).flatMap(i => i).sort()
    start = end.map(key => map.get(key).pop())
    return maxActivities(start, end);
}

module.exports = {
    maxActivities: maxActivities,
    nonGreedy: nonGreedy
}