import {maxActivities, nonGreedy} from "./activity";

console.log("We use a greedy algorithm")
console.log("From Geek4Geeks: At every step, we can make a choice that looks best at the moment, and we get the optimal solution of the complete problem.")
console.log(maxActivities([1, 3, 0, 5, 8, 5], [2, 4, 6, 7, 9, 9]));
console.log(maxActivities([8, 0, 3, 5, 1, 5], [9, 6, 4, 7, 9, 2]));

console.log("We sort the elements first in our convenience to prepare them for the greedy algorithm.")
console.log(nonGreedy([1, 3, 0, 5, 8, 5], [2, 4, 6, 7, 9, 9]));
console.log(nonGreedy([8, 0, 3, 5, 1, 5], [9, 6, 4, 7, 9, 2]));
