function storeCatalog(array) {
    let catalogue = {};

    while (array.length) {
        let row = array.shift();
        let tokens = row.split(' :');
        let product = tokens[0];
        let price = Number(tokens[1]);
        let firstLetter = product[0];

        if (!catalogue[firstLetter]) {
            catalogue[firstLetter] = [];
        }

        catalogue[firstLetter].push({ product, price });
    }
    let result = [];

    Object.entries(catalogue).sort((a, b) => a[0].localeCompare(b[0]))
    .forEach(entry => {
        let values = entry[1]
        .sort((a, b) => (a.product).localeCompare(b.product))
        .map(product => `  ${product.product}: ${product.price}`)
        .join('\n');

        let string = `${entry[0]}\n${values}`;
        result.push(string);
    });
    return result.join('\n');
}

console.log(storeCatalog(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
));