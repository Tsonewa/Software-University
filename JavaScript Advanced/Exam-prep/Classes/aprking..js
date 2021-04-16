class Parking {
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = [];
    }
    addCar(carModel, carNumber) {

        if (this.capacity <= 0) {
            throw new Error('Not enough parking space.');
        }
        this.capacity--;
        this.vehicles.push({ carModel: carModel, carNumber: carNumber, payed: false });

        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    }

    removeCar(carNumber) {
        let foundCar = this.vehicles.find(car => car.carNumber === carNumber);

        if (!foundCar) {
            throw new Error('The car, you`re looking for, is not found.');
        }

        if (foundCar.payed == false) {
            return `${carNumber} needs to pay before leaving the parking lot.`
        }

        this.vehicles = this.vehicles.filter(x => x !== foundCar);
        this.capacity++;
        return `${carNumber} left the parking lot.`

    }
    pay(carNumber) {
        let foundCar = this.vehicles.find(car => car.carNumber === carNumber);

        if (!foundCar) {
            throw new Error(`${carNumber} is not in the parking lot.`);
        }

        if (foundCar.payed == true) {
            return `${carNumber}'s driver has already payed his ticket.`
        }

        foundCar.payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`
    }

    getStatistics(carNumber) {
        let needCar = this.vehicles.find(car => car.carNumber === carNumber);
        if (carNumber) {
            return `${needCar.carModel} == ${needCar.carNumber} - ${needCar.payed ? `Has payed` : `Not payed`
                }`;
        }

        let result = [`The Parking Lot has ${this.capacity} empty spots left.`];

        this.vehicles
            .sort((a, b) => {
                return a.carModel.localeCompare(b.carModel);
            })
            .map((x) => {
                result.push(`${x.carModel} == ${x.carNumber} - ${x.payed ? `Has payed` : `Not payed`}`);
            });

        return result.join('\n');
    }
}

const parking = new Parking(12);

console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.addCar("Toyota Corrola", "CO4235AX"));
console.log(parking.getStatistics());
console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA")); 