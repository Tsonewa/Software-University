
function area(){
    return this.x * this.y;
} 

function vol(){
    return this.x * this.y * this.z;
}
function solve(area, vol, input){
    let arrayObj = JSON.parse(input);

    function calculate(obj){
        let calculateArea = Math.abs(area.call(obj));
        let calculateVol = Math.abs(vol.call(obj));
        return {area: calculateArea, volume: calculateVol};
    }
    return arrayObj.map(calculate);
}

function solution(x){
    return function add(y) {return x + y};
}

function currencyFormatter(separator, symbol, symbolFirst, value) { 
    let result = Math.trunc(value) + separator; 
    result += value.toFixed(2).substr(-2,2); 
    if (symbolFirst) {
        return symbol + ' ' + result; 
    }else {
        return result + ' ' + symbol; 
}
}
function createFormatter(separator, symbol, symbolFirst, formatter){
    return function(value) { 
        return formatter(separator, symbol, symbolFirst,value)};
}

function parseJSON(inputJSON){
    let result = JSON.parse(inputJSON);
    return result;
}

function sortAlphabetically(unsortedData){
    let sortedArray = unsortedData.sort((a,b) => a - b);

    return sortedArray;
}

function filterEmployee(data, criteria){
    let employees = parseJSON(data);
    let [objField, value] = criteria.split('-');
   
    let filteredEmployees = employees.filter((employee) => employee[objField] == value);
    return printArray(sortAlphabetically(filteredEmployees));
}

function printArray(inputArray){
    let output = '';

   inputArray.map((e, i) => {
        output += `${i}. ${e.first_name} ${e.last_name} - ${e.email}\n`;
   });
  return output;
}

console.log(filterEmployee(`[{"id": "1","first_name": "Ardine","last_name": "Bassam","email": "abassam0@cnn.com","gender": "Female"},\
{"id": "2","first_name": "Kizzee","last_name": "Jost", "email": "kjost1@forbes.com","gender": "Female"},\
{"id": "3","first_name": "Evanne","last_name": "Maldin", "email": "emaldin2@hostgator.com", "gender": "Male"}]`, 'gender-Female'));