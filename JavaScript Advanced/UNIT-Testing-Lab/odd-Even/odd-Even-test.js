const isOddOrEven = require('./odd-Even.js');
const {expect} = require('chai');

describe('isOddOrEven()', () => {
    // Check input
    it('input check with number', () =>{
        expect(isOddOrEven(2)).to.be.undefined;
    });
    it('input check with double', () => {
        expect(isOddOrEven(2.6)).to.be.undefined;
    });
    it('input check with array', () => {
        expect(isOddOrEven(["test", 'should','fail'])).to.be.undefined;
    });
    it('check input with even length', () => {
        expect(isOddOrEven('corrects')).to.equal('even');
    });
    it('check input with odd length', () =>{
        expect(isOddOrEven('incorrect')).to.equal('odd');
    });
    it('check input with one letter', () => {
        expect(isOddOrEven('y')).to.equal('odd');
    });
    it('check input with no letter', () =>{
        expect(isOddOrEven('')).to.equal('even');
    });

});