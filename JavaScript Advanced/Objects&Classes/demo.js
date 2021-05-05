function townPopulation (input){
const towns = {};

for (let town of input) {
    let [townName, population] = town.split(' <-> ');
    population = Number(population);

    if(towns[townName] != undefined){
        population += towns[townName];
    }
    towns[townName] = population;
}
for (const town in towns) {
    console.log(`${town} : ${towns[town]}`);
}
}

townPopulation(['Istanbul <-> 100000', 

'Honk Kong <-> 2100004', 

'Jerusalem <-> 2352344', 

'Mexico City <-> 23401925', 

'Istanbul <-> 1000'] );