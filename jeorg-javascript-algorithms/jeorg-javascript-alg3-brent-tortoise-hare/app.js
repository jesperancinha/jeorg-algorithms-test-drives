let before = new Date();
console.log(before)
console.log(brent([2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1]));
console.log(brent([1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]));
for (let i = 0; i < 1000; i++) {
    console.log(brent(
        [1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6,
            5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6,
            6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]))
}
let after = new Date();
console.log(after)
console.log(after - before)