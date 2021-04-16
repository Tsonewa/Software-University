let mathEnforcer = require('./mathEnforcer.js');
const {expect} = require('chai');

describe('mathEnforcer()', () => {

    describe('addFive(num)', () => {

        it('invalid param string', () => {
            expect(mathEnforcer.addFive('stringParam')).to.be.undefined;
        }),
        it('invalid param array', () => {
            expect(mathEnforcer.addFive([2,5,8])).to.be.undefined;
        }),
        it('invalid param object', () => {
            expect(mathEnforcer.addFive({2:2})).to.be.undefined;
        }),
        it('invalid param boolean', () => {
            expect(mathEnforcer.addFive(true)).to.be.undefined;
        }),
        it('invalid param string digit', () => {
            expect(mathEnforcer.addFive('9')).to.be.undefined;
        }),
        it('valid param positive number', () => {
            expect(mathEnforcer.addFive(5)).to.equal(10);
        }),
        it('valid param negative number', () => {
            expect(mathEnforcer.addFive(-5)).to.equal(0);
        }),
        it('valid param 0', () => {
            expect(mathEnforcer.addFive(0)).to.equal(5);
        }),
        it('valid param double', () => {
            expect(mathEnforcer.addFive(5.5)).to.be.closeTo(10.50, 10.51);
        }),
        it('valid param double with equal', () => {
            expect(mathEnforcer.addFive(5.5)).to.be.equal(10.50);
        }),
        it('no input', () => {
            expect(mathEnforcer.addFive()).to.be.undefined;
        });
    });
    describe('subtractTen(num)', () => {
        it('invalid param string', () => {
            expect(mathEnforcer.subtractTen('stringParam')).to.be.undefined;
        }),
        it('invalid param array', () => {
            expect(mathEnforcer.subtractTen([2,5,8])).to.be.undefined;
        }),
        it('invalid param boolean', () => {
            expect(mathEnforcer.subtractTen(false)).to.be.undefined;
        }),
        it('invalid param string digit', () => {
            expect(mathEnforcer.subtractTen('9')).to.be.undefined;
        }),
        it('valid param positive number', () => {
            expect(mathEnforcer.subtractTen(15)).to.equal(5);
        }),
        it('valid param negative number', () => {
            expect(mathEnforcer.subtractTen(-5)).to.equal(-15);
        }),
        it('valid param 0', () => {
            expect(mathEnforcer.subtractTen(0)).to.equal(-10);
        }),
        it('valid param double', () => {
            expect(mathEnforcer.subtractTen(10.5)).to.be.closeTo(0.5, 0.6);
        }),
        it('valid param double equal', () => {
            expect(mathEnforcer.subtractTen(10.5)).to.equal(0.5);
        }),
        it('no input', () => {
            expect(mathEnforcer.subtractTen()).to.be.undefined;
        });
    });
    describe('sum(num1, num2)', () => {
        it('invalid first param string', () => {
            expect(mathEnforcer.sum('string', 2)).to.be.undefined;
        }),
        it('invalid second param string double', () => {
            expect(mathEnforcer.sum(6.3, '6')).to.be.undefined;
        }),
        it('invalid params both string', () => {
            expect(mathEnforcer.sum('9', 'fail')).to.be.undefined;
        }),
        it('valid param positive number', () => {
            expect(mathEnforcer.sum(10,10)).to.equal(20);
        }),
        it('valid param negative number', () => {
            expect(mathEnforcer.sum(-5, -10)).to.equal(-15);
        }),
        it('valid param 0', () => {
            expect(mathEnforcer.sum(0, 23)).to.equal(23);
        }),
        it('valid param double', () => {
            expect(mathEnforcer.sum(10.5, 10.2)).to.be.closeTo(20.70, 20.71);
        }),
        it('valid param double and int', () => {
            expect(mathEnforcer.sum(10, 10.2)).to.be.closeTo(20.20, 20.21);
        }),
        it('valid param both zero', () => {
            expect(mathEnforcer.sum(0, 0)).to.be.equal(0);
        }),it('difference more than 0.01', () => {
            expect(mathEnforcer.sum(2.209, 2.209)).to.equal(4.418);
        }),
        it('no input', () => {
            expect(mathEnforcer.sum()).to.be.undefined;
        }),
        it('valid param negative double', () => {
            expect(mathEnforcer.sum(-10.5, -10.2)).to.be.equal(-20.70);
        });
    });
});