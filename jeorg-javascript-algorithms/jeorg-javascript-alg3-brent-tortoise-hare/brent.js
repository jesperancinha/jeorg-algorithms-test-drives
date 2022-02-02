let brent = (input_data) => {
    let lam;
    let power = lam = 1
    let i_tortoise = 0
    let i_hare = 1
    let tortoise = input_data[i_tortoise]
    let hare = input_data[i_hare]

    while (tortoise !== hare) {
        if (power === lam) {
            tortoise = hare
            power *= 2
            lam = 0
        }
        i_hare += 1
        hare = input_data[i_hare]
        lam += 1
    }

    tortoise = hare = input_data[0]
    i_hare = 0
    i_tortoise = 0
    for (let i = 0; i < lam; i++) {
        i_hare += 1
        hare = input_data[i_hare]
    }

    console.log('lam calculation', tortoise, '-', hare, '-', lam)
    console.log('lam calculation i', i_tortoise, '-', i_hare, '-', lam)
    let mu = 0
    while (tortoise !== hare) {
        console.log("mu i", i_tortoise, i_hare)
        i_tortoise += 1
        i_hare += 1
        tortoise = input_data[i_tortoise]
        hare = input_data[i_hare]
        mu += 1
    }

    console.log("Index of the first element in the cycle mu", mu)
    console.log("Length of the shortest cycle", lam)
    return {
        lam: lam,
        mu: mu
    }
}

module.exports = brent