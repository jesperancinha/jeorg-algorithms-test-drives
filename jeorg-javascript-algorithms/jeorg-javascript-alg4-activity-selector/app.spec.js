import {maxActivities, nonGreedy} from "./activity";


test('should start calculation maxActivities', () => {
    maxActivities([1, 3, 0, 5, 8, 5], [2, 4, 6, 7, 9, 9])
});

test('should start calculation nonGreedy', () => {
    nonGreedy([1, 3, 0, 5, 8, 5], [2, 4, 6, 7, 9, 9])
});
