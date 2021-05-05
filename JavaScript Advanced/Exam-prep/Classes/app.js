class Hotel {
    constructor(name, capacity) {
        this.name = name;
        this.capacity = capacity;
        this.bookings = [];
        this.currentBookingNumber = 1;
        this.roomsCapacity = {
            single: capacity / 2,
            double: capacity * 30 / 100,
            maisonette: capacity * 20 / 100
        };
      
}
get roomsPricing(){

    return {
        single: 50,
    double: 90,
    maisonette: 135
}
}

    rentARoom(clientName, roomType, nights) {

    if(this.roomsCapacity[roomType] <= 0){
        let rooms = Object.keys(this.roomsCapacity).filter(r => r != roomType);
        const firstRoomType = rooms[0];
        const secondRoomTye = rooms[1];
        const firstRoom = this.roomsCapacity[rooms[0]];
        const secondRoom = this.roomsCapacity[rooms[1]];
        throw new Error(`No ${roomType} rooms available!. Available ${firstRoomType} rooms: ${firstRoom}. Available ${secondRoomTye} rooms: ${secondRoom}.`)
    } 

    const rentNumber = Number(this.currentBookingNumber);
    const curr = {
        clientName: clientName,
        roomType: roomType,
        nights: Number(nights),
        rentNumber: rentNumber
    }

    this.bookings.push(curr);
    this.currentBookingNumber += 1;
    this.roomsCapacity[roomType] -= 1;

    return `Enjoy your time here Mr./Mrs. ${clientName}. Your booking is ${this.currentBookingNumber}.`;
    }

    checkOut(currentBookingNumber){

        const r = Object.values(this.bookings).find(r => r.rentNumber == currentBookingNumber);
    if(r == undefined){
        return `The booking ${currentBookingNumber} is invalid.`
    }

        const roomPrice = this.roomsPricing[r.roomType];
        const clientName = r.clientName;
        const totalMoney = r.nights * roomPrice;
        this.roomsCapacity[r.roomType] += 1;

        const d = Object.values(this.bookings).filter(r => r.rentNumber != currentBookingNumber);
        this.bookings = d;

        return `We hope you enjoyed your time here, Mr./Mrs. ${clientName}. The total amount of money you have to pay is ${totalMoney} BGN.`
    }

    report(){
let dashes = '--------------------';
let name = this.name.toUpperCase();
        let output = `${name} DATABASE:\n` + dashes;

     this.bookings.forEach(c => {

        let result = '----------'; 

            result += `\nbookingNumber - ${c.rentNumber}\nclientName - ${c.clientName}\nroomType - ${c.roomType}\nnights - ${c.nights}\n `;
        

        output += result;
     });

     return output;
    }
}
let hotel = new Hotel('HotUni', 10); 

console.log(hotel.rentARoom('Peter', 'single', 4)); 
console.log(hotel.rentARoom('Robert', 'double', 4)); 
console.log(hotel.rentARoom('Geroge', 'maisonette', 6)); 

console.log(hotel.report()); 