let sum = require('./mochaTest.js');
let assert = require('chai').assert;

describe('sum() behavior', () => {

    it('check the return result', () => {
        let result = sum([2,2,5,5]);
        assert.equal(result, 14, 'result should be 14');
    },
    it('check to sum negative numbers', () => {
        let result = sum([-2,-2]);
        assert.equal(result, -4, 'result should be -4');
    },
    it('check if the array is empty', () => {
        let result = sum([]);
        assert.equal(result, 0, 'result should be 0');
    },
    )));
}
)