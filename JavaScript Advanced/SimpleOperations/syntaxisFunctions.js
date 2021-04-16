function calcLength(string1, string2, string3) {

    let first = string1.length;
    let second = string2.length;
    let third = string3.length;

    let lengthSum = first + second + third;
    let averageSum = Math.floor(lengthSum / 3);

    console.log(lengthSum);
    console.log(averageSum);
}

function mathOperations(num1, num2, operator) {
    let res;

    switch (operator) {
        case '+': res = num1 + num2; break;
        case '-': res = num1 - num2; break;
        case '*': res = num1 * num2; break;
        case '/': res = num1 / num2; break;
        case '%': res = num1 % num2; break;
        case '**': res = num1 ** num2; break;
    }
    console.log(res);
}
function sumOfNumbers(num1, num2) {

    let firstNumber = Number(num1);
    let secondNumber = Number(num2);

    let result = 0;
    for (let i = firstNumber; i <= secondNumber; i++) {
        result += i;
    }
    return result;
}
function largestElement(num1, num2, num3) {
    let largestNum = Math.max(num1, num2, num3);
    console.log('The largest number is ' + largestNum + '.');
}

function circleArea(arg) {
    let inputType = typeof arg;
    let result = 0;
    if (inputType === 'number') {
        result = Math.pow(arg, 2) * Math.PI;
        console.log(result.toFixed(2));
    } else {
        console.log('We can not calculate the circle area, because we receive a ' + inputType + '.')
    }
}

function starsSquare(n) {
    if (n == null) {
        n = 5;
    }
    for (i = 0; i < n; i++) {
        console.log('* '.repeat(n));
    }
}

function dayOfWeek(string) {
    let day = 0;
    switch (string) {
        case 'Monday': day = 1; break;
        case 'Tuesday': day = 2; break;
        case 'Wednesday': day = 3; break;
        case 'Thursday': day = 4; break;
        case 'Friday': day = 5; break;
        case 'Saturday': day = 6; break;
        case 'Sunday': day = 7; break;
        default: day = 'error'; break;
    }
    console.log(day);
}

function aggregateElements(array) {
    aggregate(array, 0, (a, b) => a + b);
    aggregate(array, 0, (a, b) => a + 1 / b);
    aggregate(array, '', (a, b) => a + b);

    function aggregate(arr, initVal, func) {
        let val = initVal;
        for (let i = 0; i < arr.length; i++) {
            val = func(val, arr[i]);
        }
        console.log(val);
    }
}
function echoFunction(string) {
    console.log(string.length)
    console.log(string)
}

function stringLength(str1, str2, str3) {
    let sumLength = str1.length + str2.length + str3.length;
    let averageLength = sumLength / 3;

    console.log(sumLength)
    console.log(Math.floor(averageLength))
}

function fruits(fruitStr, weight, price) {
    let weightInKilos = weight / 1000;
    let total = price * weightInKilos;

    console.log(`I need $${total.toFixed(2)} to buy ${weightInKilos.toFixed(2)} kilograms ${fruitStr}.`);
}


function gcd(a, b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

function sameNumbers(number) {
    let numberAsString = number.toString();
    let sum = 0;
    let bool = true;
    let currentNum = Number(numberAsString[0]);

    for (i = numberAsString.length - 1; i >= 0; i--) {
        sum += Number(numberAsString[i]);
        if (Number(numberAsString[i]) !== currentNum) {
            bool = false;
        }
    }
    console.log(bool)
    console.log(sum)
}

function timeToWalk(steps, footstepsLength, speed) {
    let stepsNumber = Number(steps);
    let stepsMetersHr = Number(footstepsLength);
    let studentSpeed = Number(speed);

    let distanceMeters = stepsNumber * stepsMetersHr;
    let speedMetersSec = studentSpeed / 3.6;
    let time = distanceMeters / speedMetersSec;
    let rest = Math.floor(distanceMeters / 500);

    let timeMin = Math.floor(time / 60);
    let timeSec = Math.round(time - (timeMin * 60));
    let timeHr = Math.floor(time / 3600);

    console.log((timeHr < 10 ? "0" : "") + timeHr + ":" + (timeMin + rest < 10 ? "0" : "") + (timeMin + rest) + ":" + (timeSec < 10 ? "0" : "") + timeSec);
}

function roadRadar(speed, area) {
    let carSpeed = Number(speed);
    let typeArea = area.toString();
    let speedLimit = 0;

    if (typeArea == 'motorway') {
        speedLimit += 130;
    } else if (typeArea == 'interstate') {
        speedLimit += 90;
    } else if (typeArea == 'city') {
        speedLimit += 50;
    } else if (typeArea == 'residential') {
        speedLimit += 20;
    }

    let result = speedLimit - carSpeed; // 130 - 140 = - 10
    if (result < 0) {
        result = Math.abs(result);
        if (result <= 20) {
            console.log(`The speed is ${result} km/h faster than the allowed speed of ${speedLimit} - speeding`)
        } else if (result <= 40) {
            console.log(`The speed is ${result} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`)
        } else {
            console.log(`The speed is ${result} km/h faster than the allowed speed of ${speedLimit} - reckless driving`)
        }
    } else {
        console.log(`Driving ${carSpeed} km/h in a ${speedLimit} zone`)
    }
}
function cooking(number, str1, str2, str3, str4, str5) {
    let start = Number(number);
    let array = [str1, str2, str3, str4, str5];

    for (i = 0; i < array.length; i++) {
        let operation = array[i]; // string element
        switch (operation) {
            case 'chop':
                start /= 2;
                console.log(start)
                break;
            case 'dice':
                start = Math.sqrt(start)
                console.log(start)
                break;
            case 'spice':
                start += 1;
                console.log(start)
                break;
            case 'bake':
                start *= 3;
                console.log(start)
                break;
            case 'fillet':
                start -= start * 0.2;
                console.log(start)
                break;
        }
    }
}

function validityCode(x1, y1, x2, y2) {

    function isValid(x1, y1, x2, y2) {
        let distH = x1 - x2;
        let distY = y1 - y2;
        //d=√((x_2-x_1)²+(y_2-y_1)²)
        return Number.isInteger(Math.sqrt(distH**2 + distY**2)) ? 'valid' : 'invalid';
    }
    let first = isValid(x1, x2, 0, 0);
    let second = isValid(x2, y2, 0, 0);
    let third = isValid(x1, y1, x2, y2);
    //x1, y1} to {0, 0}, then {x2, y2} to {0, 0} and finally {x1, y1} to {x2, y2}.  
    return `{${x1}, ${y1}} to {0, 0} is ${first}\n` +
        `{${x2}, ${y2}} to {0, 0} is ${second}\n` +
        `{${x1}, ${y1}} to {${x2}, ${y2}} is ${third}\n`
}

function upperCaseWords(str){
    //extract all word
    let string = str.replace(/[^A-Za-z0-9\s]/g,"").replace(/\s{2,}/g, " ");
    let wordsArray = string.split(" ");
    //to.upperCase
    let result = wordsArray.map(e => {return e.toUpperCase()});
    // print on single line joined by ","
    result = result.map(e => e.trim()).filter(e => e).join(', ');
    
    return result
}
console.log(upperCaseWords('Functions in JS can be nested, i.e. hold other functions'))
