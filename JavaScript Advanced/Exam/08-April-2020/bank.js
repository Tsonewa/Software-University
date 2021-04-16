class Bank { 
   constructor(bankName){
       this.bankName = bankName;
       this.allCustomers = [];
   }

   get bankName() { 
       return this._bankName;
     }

  set bankName(bankName){
    this._bankName = bankName; 
  }

  newCustomer (customer) {

    this.allCustomers.find((c) => {
        if (c.personalId === customer.personalId) {
            throw new Error(
                `${customer.firstName} ${customer.lastName} is already our customer!`
            );
        }
    });
        this.allCustomers.push(customer);
        return customer;
    }

  depositMoney(personalId, amount) {

    let found = this.allCustomers.find(element => element.personalId === personalId);
    
    if(found === undefined){
        throw new Error ('We have no customer with this ID!');
    } else {
        if(found.hasOwnProperty('totalMoney')){
            found['totalMoney'] += amount;
            if(!found.hasOwnProperty('transactions')){
                found['transactions'] = [];
            }
                found['transactions'].push(`${found.transactions.length + 1}. ${found.firstName} ${found.lastName} made deposit of ${amount}$!`);
        } else {
            found['totalMoney'] = amount;
            if(!found.hasOwnProperty('transactions')){
                found['transactions'] = [];
            }
            found['transactions'].push(`${found.transactions.length + 1}. ${found.firstName} ${found.lastName} made deposit of ${amount}$!`);
        }
    }
    return `${found.totalMoney}$`;
}

withdrawMoney(personalId, amount) {

    let found = this.allCustomers.find(element => element.personalId === personalId);
    
    if(found === 'undefined'){
        throw new Error ('We have no customer with this ID!');
    }else if(found.totalMoney < amount) {
        throw new Error (`${found.transactions.length + 1}. ${found.firstName} ${found.lastName} does not have enough money to withdraw that amount!`);
    } else {
        if(found.hasOwnProperty('totalMoney')){
            found['totalMoney'] -= amount;
            if(!found.hasOwnProperty('transactions')){
                found['transactions'] = [];
            }
            found['transactions'].push(`${found.transactions.length + 1}. ${found.firstName} ${found.lastName} withdrew ${amount}$!`);
    }
    
    return `${found.totalMoney}$`;
}
}
customerInfo(personalId){
    let found = this.allCustomers.find(element => element.personalId === personalId);
    if(found === undefined){
        throw new Error ('We have no customer with this ID!');
    }
    let output = `Bank name: ${this.bankName}\nCustomer name: ${found.firstName} ${found.lastName}\nCustomer ID: ${found.personalId}\nTotal Money: ${found.totalMoney}$\nTransactions:\n`;
    
    for (let index = found.transactions.length - 1; index >= 0; index--) {
        output += found.transactions[index];
        if (index !== 0) {
            output += `\n`;
}
    }
    return output;
}
}

    let bank = new Bank('SoftUni Bank'); 

console.log(bank.newCustomer({firstName: 'Svetlin', lastName: 'Nakov', personalId: 6233267})); 
console.log(bank.newCustomer({firstName: 'Mihaela', lastName: 'Mileva', personalId: 4151596}));
bank.depositMoney(6233267, 250); 
console.log(bank.depositMoney(6233267, 250)); 
bank.depositMoney(4151596,555); 
console.log(bank.withdrawMoney(6233267, 125));
console.log(bank.customerInfo(6233267));