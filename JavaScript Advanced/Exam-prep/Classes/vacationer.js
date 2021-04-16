class Vacationer{
    constructor(fullName, creditCard){
        this.fullName = fullName;
        this.idNumber = undefined;
        if(creditCard != undefined){
            this.creditCard = {
                cardNumber: Number(creditCard[0]),
                expirationDate: creditCard[1],
                securityNumber: Number(creditCard[2])
                }
        } else {
            this.creditCard = {
                cardNumber: 1111,
                expirationDate: '',
                securityNumber: 111
        }
        
    };
    this.wishList = [];
}
set fullName(fullName){

    if([...fullName].length < 3){
        throw new Error('Name must include first name, middle name and last name.');
    } 

    let[firstName, middleName, lastName] = fullName;
    const regex = /[A-Z][a-z]+/g;
    if(!firstName.match(regex) || !middleName.match(regex) || !lastName.match(regex)) {
        throw new Error('Invalid full name')
    }

    return fullName = {
        firstName: firstName,
        middleName: middleName,
        lastName: lastName
    }
}

get fullName(){
    return this.fullName; 
}

set generateIDNumber(idNumber){

    let firstLetter = this.fullName().charAt(0);
    console.log(firstLetter);
    let genereteId = 231 * firstLetter + 139 * this.fullName[middleName];
    return this.idNumber = genereteId;
}
addDestinationToWishList(country){

}
getVacationerInfo(){

}
}
// Initialize vacationers with 2 and 3 parameters 

let vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]); 
let vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],  
[123456789, "10/01/2018", 777]); 


 vacationer1.generateIDNumber;
 console.log(vacationer);
// Should throw an error (Invalid full name) 
try { 
   let vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]); 
} catch (err) { 
  console.log("Error: " + err.message); 
} 
//Should throw an error (Missing credit card information) 
try { 
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]); 
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]); 
} catch (err) { 
    console.log("Error: " + err.message); 

} 
vacationer1.addDestinationToWishList('Spain'); 
vacationer1.addDestinationToWishList('Germany'); 
vacationer1.addDestinationToWishList('Bali'); 

// Return information about the vacationers 
//console.log(vacationer1.getVacationerInfo()); 
//console.log(vacationer2.getVacationerInfo()); 