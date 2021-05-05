(function solve(){

//last() - returns the last element of the array 
Array.prototype.last = () => {
    return this[this.length - 1];
};
    //skip(n) - returns a new array which includes all original elements, except the 
    //first n elements; n is a Number parameter 

    Array.prototype.skip = function(n) {
        let result = [];
        for (let i = n; i < this.length; i++){
            result.push(this[i]);
        }
        return result;
    };
// /take(n) - returns a new array containing the first n elements from the original array; n is a Number parameter 
Array.prototype.take = function(n) {
    let result = [];
    for (let i = 0; i < n; i++){
        result.push(this[i]);
    }
    return result;
};
//sum() - returns a sum of all array elements
Array.prototype.sum = () => {
    let result = this;
    let sum =  result.reduce((acc, number) => acc + number , 0);
    return sum;
};

//average() - returns the average of all array elements */
Array.prototype.average = () => {
    let result = this;
    let sum = result.reduce((acc, number) => acc + number , 0);
    return sum / this.length;
};
}());

