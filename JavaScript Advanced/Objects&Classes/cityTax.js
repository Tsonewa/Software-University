function cityTaxes(name, population, treasury) {
    return {
        name,
        population,
        treasury,
        taxRate: 10,
        //collectTaxes() - Increase treasury by  population * taxRate 
        collectTaxes() { this.treasury += this.population * this.taxRate; },
        //applyGrowth(percentage) - Increase population by given percentage 
        applyGrowth(percentage) {
            this.population += Math.floor(this.population * percentage / 100);
        },
        //applyRecession(percentage) - Decrease treasury by given percentage
        applyRecession(percentage) {
            this.treasury -= Math.floor(this.treasury * percentage / 100);
        }
    }
}

