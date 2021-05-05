function sumArray(array){
    
    let sum = 0;
    for (const num of array) {
        sum += Number(num);
    }
    return sum;
}
module.exports = sumArray;