let stringOperations = require('./03. Number Operations_Resources');
let {expect} = require('chai');


describe('stringOperations', () => {
    describe('stringSlicer()', () => {

        it('check stringSlicer', () => {
            expect(stringOperations.stringSlicer('aaa')).to.equal('aaa...');
            expect(stringOperations.stringSlicer('abcd')).to.equal('abc...');
            expect(stringOperations.stringSlicer('bb')).to.equal('bb...');
            expect(stringOperations.stringSlicer('b')).to.equal('b...');
        });

    });

    describe('wordChecker()', () => {

        it('wordChecker()', () => {
            expect(stringOperations.wordChecker('Check ', 'check')).to.equal('check');
            expect(() => stringOperations.wordChecker('Check ', 'text')).to.equal('check not found!');
        });

    });
    describe('printEveryNthElement)', () => {

        it('validate input', () => {
            expect(() => stringOperations.printEveryNthElement(2, [])).to.throw('The input is not valid!');
            expect(() => stringOperations.printEveryNthElement('str', {})).to.throw('The input is not valid!');
        });

        it('valid input', () => {
            expect(stringOperations.printEveryNthElement(1,[1,2])).to.deep.equal([1]);
            expect(stringOperations.printEveryNthElement(0,['str', 'str'])).to.deep.equal(['str']);
            expect(stringOperations.printEveryNthElement(2,[1,2,3,4,5,6])).to.deep.equal([3,6]);
        });
    });
});