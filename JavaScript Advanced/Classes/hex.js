class Hex {
    constructor(value){
        this.value = Number(value);
    }
   
    valueOf(){
        this.value++;
        return this.value - 1;
    }
    toString(){
        return `0x${this.value.toString(16).toUpperCase()}`;
    }
    plus(number) {
        this.value += parseInt(number);
        return `0x${this.value.toString(16).toUpperCase()}`;
    } 
    minus(number){
        this.value -= parseInt(number);
        return `0x${this.value.toString(16).toUpperCase()}`;
    } 
    parse(string){
       return parseInt(string, 16);
    } 
}

let FF = new Hex(255); 
console.log(FF.toString()); 
FF.valueOf() + 1 == 256; 
let a = new Hex(10); 
let b = new Hex(5); 
console.log(a.plus(b).toString()); 
console.log(a.plus(b).toString() ==='0xF');