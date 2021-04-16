let color = require('./simetry.js');
let assert = require('chai').assert;
//0…255 color range

describe('color inputs validity ', () => {

    it('check input type red', () => {
        assert.equal(color(2,3,7), '#020307', 'red is a number');
        assert.equal(color("2",5,8), undefined, 'red isn`t a number');
    },
    it('check input type green', () => {
        let inputTypeGreen = color(2,3,7);
        let inputTypeGreenFalse = color(2,"5",8);
        assert.equal(inputTypeGreenFalse, undefined, 'green is a number');
        assert.equal(inputTypeGreen, '#020307', 'green is a number');
    },
    it('check input type blue', () => {
        let inputTypeBlue = color(2,3,7);
        let inputTypeBlueFalse = color(2,5,"8");
        assert.equal(inputTypeBlueFalse, undefined, 'green is a number');
        assert.equal(inputTypeBlue, "#020307", 'green is a number');
    },
    it('check red range', () => {
        let rangeRed = color(-2,3,7);
        assert.equal(rangeRed, undefined, 'red is out of range');
    },
    it('check red range', () => {
        let rangeRed = color(256,3,7);
        assert.equal(rangeRed, undefined, 'red is out of range');
    },
    it('check green range', () => {
        let rangeGreen = color(2,-3,7);
        assert.equal(rangeGreen, undefined, 'green is out of range');
    },
    it('check green range', () => {
        let rangeGreen = color(2,256,7);
        assert.equal(rangeGreen, undefined, 'green is out of range');
    },
    it('check blue range', () => {
        let rangeBlue = color(2,3,-7);
        assert.equal(rangeBlue, undefined, 'blue is out of range');
    },
    it('check blue range', () => {
        let rangeBlue = color(2,3,256);
        assert.equal(rangeBlue, undefined, 'blue is out of range');
    },
    it('checkempty values', () => {
        assert.equal(color(), undefined, 'the function is empty');
    },
    it('check invalid value', () => {
        let doubleValue = color(2.3,3,7);
        assert.equal(doubleValue, undefined, 'invalid value');
    },
   
 )))))))))));
})
