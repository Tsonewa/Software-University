

let pizzUni = require('./pizza.js');
let {expect} = require('chai');

describe('pizzUni', () => {
    describe('makeAnOrder() input obj', () => {

        it('check input value type', () => {
            //input should be type of object or throw new Error(''You must order at least 1 Pizza to finish the order.')
           // expect(() =>{pizzUni.makeAnOrder({})}).to.throw('You must order at least 1 Pizza to finish the order.');
            expect(() => {pizzUni.makeAnOrder('string')}).to.throw('You must order at least 1 Pizza to finish the order.');
            expect(() => {pizzUni.makeAnOrder([2,58])}).to.throw('You must order at least 1 Pizza to finish the order.');
            expect(() => {pizzUni.makeAnOrder(['string','string'])}).to.throw('You must order at least 1 Pizza to finish the order.');
            
            //obj with one param drink -> throw new Error(''You must order at least 1 Pizza to finish the order.')
            expect(() => {pizzUni.makeAnOrder({orderedDrink: 'Coke'})}).to.throw(new Error ('You must order at least 1 Pizza to finish the order.'));
        });
        
        it('check correct input results', () => {
            //obj with one param pizza -> 'You just ordered ${obj.orderedPizza}'
            expect(pizzUni.makeAnOrder({orderedPizza: 'Peperoni'})).to.equal('You just ordered Peperoni');
            //obj with two params pizza and drink -> 'You just ordered ${obj.orderedPizza}' + ' and ${obj.orderedDrink}'
            expect(pizzUni.makeAnOrder({orderedPizza: 'Peperoni', orderedDrink: 'Coke'})).to.equal('You just ordered Peperoni and Coke.');
        });

    });

    describe('getRemainingWork() input value array', () => {

        it('check array only completed order', () => {
            // value array if there are no pending pizzas -> 'All orders are complete!'
            expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'ready'}])).to.equal('All orders are complete!');
            expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'ready'},{pizzaName: 'b', status: 'ready'}])).to.equal('All orders are complete!');
        });

        it('check arrays with pending orders', () => {
            //if there are pending pizzas -> 'The following pizzas are still preparing: ${pizzaNames}'
            expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'ready'},{pizzaName: 'c', status: 'preparing'},{pizzaName: 'b', status: 'ready'}])).to.equal('The following pizzas are still preparing: c.');
            //try with empty array and more than one pending order 
            expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'preparing'},{pizzaName: 'c', status: 'preparing'},{pizzaName: 'b', status: 'preparing'}])).to.equal('The following pizzas are still preparing: a, c, b.');
            //expect(pizzUni.getRemainingWork([])).to.equal('All orders are complete!');

        });
    });
    describe('orderType:() input total sum and type(str)', () => {

        it('check type of order', () => {
            //check 'Carry Out' -> totalSum * 0.1 discount
            expect(pizzUni.orderType(100, 'Carry Out')).to.equal(90);
            //check 'Delivery'
            expect(pizzUni.orderType(100, 'Delivery')).to.equal(100);
        });

        it('check invalid totalSum', () => {
            //negative number || 0 || string to equal undefined
            expect(pizzUni.orderType(-100, 'Delivery')).to.equal(-100);
            expect(pizzUni.orderType(232.2, 'Delivery')).to.equal(232.2);
            expect(pizzUni.orderType('Delivery')).to.be.undefined;
            expect(pizzUni.orderType(200, 'invalidType')).to.be.undefined;
        });
    });
});
