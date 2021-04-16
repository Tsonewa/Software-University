let numberOperations = require('./03. Number Operations_Resources');
let {expect} = require('chai');

//module.exports = pizzUni;

describe('numberOperation', () => {
    describe('powNumber() input number', () => {

        it('check integer', () => {
            expect(numberOperations.powNumber(2)).to.equal(4);
            expect(numberOperations.powNumber(2.2)).to.equal(4.84);
            expect(numberOperations.powNumber(0)).to.equal(0);
            expect(numberOperations.powNumber(-2)).to.equal(4);
        });

    });

    describe('numberChecker() input value number', () => {

        it('check input value', () => {
            expect(() => numberOperations.numberChecker('string')).to.throw('The input is not a number!');
            expect(() => numberOperations.numberChecker([2])).to.throw('The input is not a number!');
        });

        it('input less than 100', () => {
            expect(numberOperations.numberChecker(50)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(-50)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(0)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(99.9)).to.equal('The number is lower than 100!');
        
        });

        it('input  more or equal than 100', () => {
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(101)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(150)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(100.5)).to.equal('The number is greater or equal to 100!');
        
        });
    });
    describe('sumArrays:()', () => {

        it('first array is longer', () => {
            expect(numberOperations.sumArrays([1,2,3],[1,2])).to.deep.equal([2,4,3]);
            expect(numberOperations.sumArrays([1.1,2.1,3.1],[1.1,2.1])).to.deep.equal([2.2,4.2,3.1]);
            expect(numberOperations.sumArrays([0,0],[0])).to.deep.equal([0,0]);
            expect(numberOperations.sumArrays([1,-2,3],[-1,-1])).to.deep.equal([0,-3,3]);
        });

        it('second array is longer', () => {
            expect(numberOperations.sumArrays([1,2],[1,2,3])).to.deep.equal([2,4,3]);
            expect(numberOperations.sumArrays([1],[1,2])).to.deep.equal([2,2]);
            expect(numberOperations.sumArrays([-1,-2],[-1,-2,-3])).to.deep.equal([-2,-4,-3]);
            expect(numberOperations.sumArrays([1.1,2.1],[1.1,2.1, 3.1])).to.deep.equal([2.2,4.2,3.1]);
        });
    });
});