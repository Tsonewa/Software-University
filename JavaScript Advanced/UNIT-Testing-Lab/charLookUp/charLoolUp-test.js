const lookupChar = require('./charLookUp.js');
const {expect} = require('chai');

describe('lookupChar()', () => {
    it('first param - undefined integer', () => {
        expect(lookupChar(2,2)).to.be.undefined;
    });
    it('first param - undefined double', () => {
        expect(lookupChar(2.6,2)).to.be.undefined;
    });
    it('first param - undefined array', () => {
        expect(lookupChar([2,6],2)).to.be.undefined;
    });
    it('invalid index - string', () => {
        expect(lookupChar('string', 'fail')).to.be.undefined;
    });
    it('invalid index - double', () => {
        expect(lookupChar('less', 4.2)).to.be.undefined;
    });
    it('invalid index - array', () => {
        expect(lookupChar('less', [4.2,2])).to.be.undefined;
    });
    it('invalid index - negative number', () => {
        expect(lookupChar('less', -2)).to.equal('Incorrect index');
    });
    it('valid index - zero', () => {
        expect(lookupChar('less', 0)).to.equal('l');
    });
    it('invalid index - equal to the string length', () => {
        expect(lookupChar('less', 4)).to.equal('Incorrect index');
    });
    it('invalid index - more than the length', () => {
        expect(lookupChar('less', 9)).to.equal('Incorrect index');
    });
    it('invalid index - negative index', () => {
        expect(lookupChar('less', -3)).to.equal('Incorrect index');
    });
    it('valid index - length - 1', () => {
        expect(lookupChar('less', 3)).to.equal('s');
    });
    it('valid index - first char', () => {
        expect(lookupChar('less', 1)).to.equal('e');
    });
    it('valid index - whitespace', () => {
        expect(lookupChar('it works', 2)).to.equal(' ');
    });
    it('both params wrong', () => {
        expect(lookupChar('3', 2.5)).to.be.undefined;
    });
});