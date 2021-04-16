function tickets([...ticketsArray], string){

    class Ticket {
        constructor(destination, price, status){
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }
        let ticketsInfo = [];
        
       for (let i = 0; i < ticketsArray.length; i++){
           let tokens = ticketsArray[i].split('|');
           ticketsInfo.push(new Ticket(tokens[0], Number(tokens[1]).toFixed(2),tokens[2]));
       }

       if(string === 'destination'){
           return ticketsInfo.sort((a,b) => a.destination.localeCompare(b.destination));
       } else if(string === 'price'){
        return ticketsInfo.sort((a,b) => a.price - b.price);
       } else if(string === 'status'){
        return ticketsInfo.sort((a,b) => a.status.localeCompare(b.status));
       }
}

console.log(tickets(['Philadelphia|94.20|available', 
'New York City|95.99|available', 
'New York City|95.99|sold', 
'Boston|126.20|departed'], 
'status'));