let { Repository } = require("./solution.js");
const {expect} = require('chai');

describe("Repository", function () {
    let repo;
	beforeEach(function() {
        let data = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };
		repo = new Repository(data);
	})
    describe("check input", function () {

        it("check if the input is object", function () {
            expect(repo.props).to.deep.equal({name: "Pesho", age: 22, birthday: new Date(1998, 0, 7)});
            expect(repo.data).to.be.eql(new Map);
           // expect(repo.id).to.be.equal(0);
            expect(repo.nextId()).to.be.equal(0);
            expect(repo.count).to.be.equal(0);
        });
    });
    describe("add(entity)", function () {

        it("check add(entity)", function () {
            expect(repo.props).to.deep.equal({name: "Pesho", age: 22, birthday: new Date(1998, 0, 7)});
            expect(repo.data).to.be.eql(new Map);
           // expect(repo.id).to.be.equal(0);
            expect(repo.nextId()).to.be.equal(0);
            expect(repo.count).to.be.equal(0);
        });
    });  
  
    // TODO: …
});
