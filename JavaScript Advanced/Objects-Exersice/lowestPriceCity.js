function solve(array){
    let towns = {};
while(array.length){
    let row = array.shift();
    let tokens = row.split(' | ');
    let town = tokens[0];
    let product = tokens[1];
    let price = Number(tokens[2]);

    if(!towns[product]){
    towns[product] = {town, product, price};
} else {
towns[product] = towns[product].price <= price ? towns[product] : {town, price: price};
}
}
let result = [];
for (const entry in towns) {
  result.push(`${entry} -> ${towns[entry].price} (${towns[entry].town})`);
}
return result.sort((a,b) => a.price - b.price).join('\n');
}
console.log(solve(['Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000']));