function rectangle(width, height, color){
    function capitalizeLetter(params) {
        return params[0].toUpperCase() + params.slice(1);
    }

    function calcArea() {
        return this.width * this.height;
    }

    return {
        width,
        height,
        color: capitalizeLetter(color),
        calcArea
    }
}

let rect = rectangle(4, 5, 'red'); 
console.log(rect.width); 
console.log(rect.height); 
console.log(rect.color); 
console.log(rect.calcArea()); 