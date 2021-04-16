const dealership = require('./dealership');
const {expect} = require('chai');

describe('dealership', () => {
    describe('newCarCost() function', () => {

        it('check discount', () => {
            expect(dealership.newCarCost('Audi A4 B8', 20000)).to.equal(5000);
        });

        it('check unexciting old car', () => {
            expect(dealership.newCarCost('Toyota Corolla', 50000)).to.equal(50000);
        });
    });

    describe('carEquipment()', () => {
        
        it('get the extras', () => {
            expect(dealership.carEquipment(['a','b','c','d','e'], [0,2,4])).to.deep.equal(['a','c','e']);
            expect(dealership.carEquipment(['a','b','c'], [2])).to.deep.equal(['c']);
            expect(dealership.carEquipment(['a','b'], [0])).to.deep.equal(['a']);
        });
    });

        describe('euroCategory()', () => {
            
            it('category less than 4', () => {
                expect(dealership.euroCategory(2)).to.equal('Your euro category is low, so there is no discount from the final price!');
                expect(dealership.euroCategory(0)).to.equal('Your euro category is low, so there is no discount from the final price!');
                expect(dealership.euroCategory(-2)).to.equal('Your euro category is low, so there is no discount from the final price!');
            });

            it('category more or equal to 4', () => {
        expect(dealership.euroCategory(4)).to.equal('We have added 5% discount to the final price: 14250.');
        expect(dealership.euroCategory(6)).to.equal('We have added 5% discount to the final price: 14250.');
            });
    });
});