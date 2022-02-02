import brent from "./brent";

test('should start calculation', () => {
    brent([2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1])
});
