function solve(array) {
let[thead, ...table] = array.split('|');
let fields = thead.split('/\s*,\s*/');

let result = {};

while(table.length){
    let row = table.shift();
    let tokens = row.split('/\s*,\s*/');
    let town = tokens[0];
    let latitude = Number(tokens[1]).toFixed(2);
    let longitude = Number(tokens[2]).toFixed(2);

    result.push({town, latitude, longitude});
}
return result
}

console.log(solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']));