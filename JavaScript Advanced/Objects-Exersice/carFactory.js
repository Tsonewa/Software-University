function carFactory(car) {
    function getEngine(power) {
        const engines = [
            { power: 90, volume: 1800 },
            { power: 120, volume: 2400 },
            { power: 200, volume: 3500 }];
        for (const engine of engines) {
            if (engine.power >= power) {
                return {
                    power: engine.power,
                    volume: engine.volume,
                }
            }
        }
    }
    function getWheels(wheels) { return Math.floor(wheels) % 2 != 0 ? Array(4).fill(wheels, 0) : Array(4).fill(wheels - 1, 0) };
    return {
        model: car.model,
        engine: getEngine(car.power),
        carriage: {
            type: car.carriage,
            color: car.color
        },
        wheels: getWheels(car.wheelsize)
    }
}
console.log(carFactory({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
}));