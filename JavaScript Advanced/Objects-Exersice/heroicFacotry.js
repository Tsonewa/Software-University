function heroicFactory(dataArray) {
    let result = [];
    while(dataArray.length){
        let hero = dataArray.shift();
let[name, level, rest] = hero.split(' / ');
level = Number(level);
let items = rest ? rest.split(', ') : [];

result.push({name, level, items});
    }
    return JSON.stringify(result);
}

console.log(heroicFactory(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']));