let floyd = (function_data) => {
    console.log('checking repetitions in', function_data);
    let i_tortoise = 1;
    let i_hare = 2;
    let tortoise = function_data[i_tortoise];
    let hare = function_data[i_hare];
    console.log(tortoise, '-', hare);
    while (tortoise !== hare) {
        i_tortoise += 1;
        i_hare += 2;
        tortoise = function_data[i_tortoise];
        hare = function_data[i_hare];
        console.log(tortoise, '-', hare);
    }

    console.log("tortoise i", i_tortoise, "hare i", i_hare);
    let mu = 0;
    i_tortoise = 0;
    tortoise = function_data[i_tortoise];
    console.log('mu calculation', tortoise, '-', hare, '-', mu);
    while (tortoise !== hare) {
        i_tortoise += 1;
        i_hare += 1;
        tortoise = function_data[i_tortoise];
        hare = function_data[i_hare];
        mu += 1;
        console.log('mu calculation', tortoise, '-', hare, '-', mu);
    }

    let lam = 1;
    hare = function_data[i_tortoise + 1];
    console.log('lam calculation', tortoise, '-', hare, '-', lam);
    console.log('lam calculation i', i_tortoise, '-', i_hare, '-', lam);
    i_hare = i_tortoise + 1;
    while (tortoise !== hare) {
        i_hare += 1;
        hare = function_data[i_hare];
        lam += 1;
        console.log('lam calculation', tortoise, '-', hare, '-', lam);
    }

    console.log("Index of the first element in the cycle mu", mu);
    console.log("Length of the shortest cycle", lam);
    return {
        lam: lam,
        mu: mu
    };
}

module.exports = floyd