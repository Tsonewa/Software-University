function evenPositions(n, k) {
    let arr = [1];

    for (let i = 1; i < n; i++) {
        let startIndex = Math.max(0, i - k);
        let currentElement = arr.slice(startIndex, startIndex + k).reduce((a, b) => a + b, 0);
        arr.push(currentElement);
    }
    return arr
}
function sumFirstLast(numbers) {
    let result = [];
    for (let i = 0; i < numbers.length; i++) {
        if (Math.sign(numbers[i]) == -1) {
            result.unshift(numbers[i]);
        } else {
            result.push(numbers[i]);
        }
    }
    return result
}
function twoSmallestOnes(input) {

    let res = input.sort((a, b) => b - a).slice(0, Math.ceil(input.length / 2)).reverse();

    return res;
}

function doubleNumbers(arrayNumbers) {

    let stringNumbers = arrayNumbers
        .filter((e, i) => i % 2 != 0)
        .map(e => e * 2)
        .reverse()
        .join(' ')

    return stringNumbers
}
function biggestElement(matrix) {
    let biggestNumbers = Number.MIN_SAFE_INTEGER;
  
    for(i = 0; i < matrix.length; i++){
        let current = Math.max(...matrix[i]);
        if(current > biggestNumbers){
            biggestNumbers = current;
        }
    }
    return biggestNumbers
}

