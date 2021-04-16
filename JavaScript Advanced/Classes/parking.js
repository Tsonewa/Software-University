class Parking{
constructor(capacity){
    this.capacity = capacity;
    this.vehicles = [];
}

addCar(carModel, carNumber){
    if(this.capacity <= this.vehicles.length){
        throw new Error ('Not enough parking space.');
    }
    this.vehicles.push({carModel, carNumber, payed: false});
    return `The ${carModel}, with a registration number ${carNumber}, parked.`
}

removeCar(carNumber){
    let found = this.vehicles.find(car => car.carNumber === carNumber);

    if(!found){
        throw new Error ('The car, you\'re looking for, is not found.');
    }
        if(found.payed == false){
            throw new Error (`${carNumber} needs to pay before leaving the parking lot.`)
        }

        this.vehicles.splice(this.vehicles.indexOf(found), 1);
        //this.vehicles = this.vehicles.filter(a => a.carNumber !== carNumber);
        return `${carNumber} left the parking lot.`
    
}
pay(carNumber){
    let isFound = this.vehicles.find(v => v.carNumber === carNumber);

    if(!isFound){
        throw new Error (`${carNumber} is not in the parking lot.`);
    }

    if(isFound.payed == true){
        throw new Error (`${carNumber}'s driver has already payed his ticket.`);
    }

    isFound.payed = true;
    return `${carNumber}'s driver successfully payed for his stay.`
}
getStatistics(carNumber){

    if(carNumber){
        let result = this.vehicles.find(r => r.carNumber === carNumber);
        return `${result.carModel} == ${result.carNumber} - ${result.payed ? 'Has payed' : 'Not payed'}`;
    }else {
        let output = [`The Parking Lot has ${this.capacity - this.vehicles.length} empty spots left.`];
        
        this.vehicles
        .sort((a, b) => a.carModel.localeCompare(b.carModel))
        .forEach(vehicle => {
            output.push(`${vehicle.carModel} == ${vehicle.carNumber} - ${vehicle.payed ? 'Has payed' : 'Not payed'}`)
        });

        return output.join('\n');
    }
}
}

