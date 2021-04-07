from datetime import datetime


def brent(input_data):
    power = lam = 1
    i_tortoise = 0
    i_hare = 1
    tortoise = input_data[i_tortoise]
    hare = input_data[i_hare]

    while tortoise != hare:
        if power == lam:
            tortoise = hare
            power *= 2
            lam = 0
        i_hare += 1
        hare = input_data[i_hare]
        lam += 1

    tortoise = hare = input_data[0]
    i_hare = 0
    i_tortoise = 0
    for i in range(lam):
        i_hare += 1
        hare = input_data[i_hare]

    print('lam calculation', tortoise, '-', hare, '-', lam)
    print('lam calculation i', i_tortoise, '-', i_hare, '-', lam)
    mu = 0
    while tortoise != hare:
        print("mu i", i_tortoise, i_hare)
        i_tortoise += 1
        i_hare += 1
        tortoise = input_data[i_tortoise]
        hare = input_data[i_hare]
        mu += 1

    print("Index of the first element in the cycle mu", mu)
    print("Length of the shortest cycle", lam)
    return lam, mu


before = datetime.now(tz=None)
print(before)
print(brent([2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1]))
print(brent([1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]))

for i in range(1000):
    print(brent(
        [1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6,
         5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6,
         6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]))

after = datetime.now(tz=None)
print(after)
print(after - before)
