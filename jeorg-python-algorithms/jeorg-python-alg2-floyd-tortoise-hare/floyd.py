from datetime import datetime


def floyd(function_data):
    print('checking repetitions in', function_data)
    i_tortoise = 1
    i_hare = 2
    tortoise = function_data[i_tortoise]
    hare = function_data[i_hare]
    print(tortoise, '-', hare)
    while tortoise != hare:
        i_tortoise += 1
        i_hare += 2
        tortoise = function_data[i_tortoise]
        hare = function_data[i_hare]
        print(tortoise, '-', hare)

    print("tortoise i", i_tortoise, "hare i", i_hare)
    mu = 0
    i_tortoise = 0
    tortoise = function_data[i_tortoise]
    print('mu calculation', tortoise, '-', hare, '-', mu)
    while tortoise != hare:
        i_tortoise += 1
        i_hare += 1
        tortoise = function_data[i_tortoise]
        hare = function_data[i_hare]
        mu += 1
        print('mu calculation', tortoise, '-', hare, '-', mu)

    lam = 1
    hare = function_data[i_tortoise + 1]
    print('lam calculation', tortoise, '-', hare, '-', lam)
    print('lam calculation i', i_tortoise, '-', i_hare, '-', lam)
    i_hare = i_tortoise + 1
    while tortoise != hare:
        i_hare += 1
        hare = function_data[i_hare]
        lam += 1
        print('lam calculation', tortoise, '-', hare, '-', lam)

    print("Index of the first element in the cycle mu", mu)
    print("Length of the shortest cycle", lam)
    return lam, mu - 1


before = datetime.now(tz=None)
print(before)
print(floyd([2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1]))
print(floyd([1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]))

for i in range(1000):
    print(floyd(
        [1, 2, 3, 4, 5, 6, 5, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6,
         6,
         5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5, 6, 6, 5,
         6,
         6, 5, 6, 5, 6, 5, 6, 6, 7, 5, 3, 4, 2, 4, 5, 7]))

after = datetime.now(tz=None)
print(after)
print(after - before)
