const {expect} = require('chai');
let createCalculator = require('./createCalculator');

describe("createCalculator()", function () {
    let calc;
 
    beforeEach(function () {
        calc = createCalculator();
    });
    // add -> '2' '3' -> 5
        it('add valid input add(2), add(3)', () => {
            calc.add(2);
            calc.add(3);
            let value = calc.get();
            expect(value).to.equal(5);
        });

    // add -> '-2' '5' -> 3
        it('add positive and negative number', () => {
           calc.add(-2);
           calc.add(5);
           let value = calc.get();
           expect(value).to.equal(3);     
        });
        // add -> "hello" -> NaN
        it('add invalid value', () => {
            // let value = calc.get();
            calc.add("hello");
            let value = calc.get(); 
            expect(value).to.be.NaN;
        });
        // add -> () -> 0
        it('zero output - no parameters', () => {
            let value = calc.get();
            expect(value).to.equal(0);
        });
        // add 5, subtract 2 -> 3;
        it('should return 3 add(5) and subtract(2)', () => {
            calc.add(5);
            calc.subtract(2);
            let value = calc.get();
            expect(value).to.equal(3);
        });
        // subtract -> 4, 5 -> -9
        it('subtract two positive numbers', () => {
            calc.subtract(4);
            calc.subtract(5);
            let value = calc.get();
            expect(value).to.equal(-9);
        });
        //subtract -> () -> 0;
        it('subtract 0', () => {
            calc.subtract(0);
            let value = calc.get();
            expect(value).to.equal(0);
        });
        // subtract -5, -2 -> -7;
        it('subtract two negative numbers', () => {
            calc.subtract(-5);
            calc.subtract(-2);
            let value = calc.get();
            expect(value).to.equal(7);
        });
    // subtract "fail" -> NaN
    it('subtract invalid value', () => {
        // let value = calc.get();
        calc.subtract("fail");
        let value = calc.get();
        expect(value).to.be.NaN;
    });
    //subtract -5, 5 -> -10;
    it('subtract negative and positive number', () => {
        calc.subtract(-5);
        calc.subtract(5);
        let value = calc.get();
        expect(value).to.equal(0);
    });
    it('check double values', () => {
        calc.add(2.1);
        calc.subtract(1.1);
        let value = calc.get();
        expect(value).to.equal(1);
    });

    it("should return 4.2 after add(5.3); subtract(1.1);", function () {
        calc.add(5.3);
        calc.subtract(1.1);
        let value = calc.get();
        expect(value).to.be.equal(5.3 - 1.1);
    });
    it("should return 2 after add(10); subtract('7'); add('-2'); subtract(-1)", function () {
        calc.add(10);
        calc.subtract('7');
        calc.add('-2');
        calc.subtract(-1);
        let value = calc.get();
        expect(value).to.be.equal(2);
    });
});
