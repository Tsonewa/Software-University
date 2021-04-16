    class List{
        constructor(array = []){
            this.array = array.sort((a, b) =>  a - b);
            this.size = this.array.length;
        }
        //add(elemenent) - adds a new element to the collection 
        add(element){
            this.size++;
            this.array.push(element); 
            return this.array.sort((a, b) =>  a - b);
        }
    //remove(index) - removes the element at position index
    remove(index){
        if(index >= 0 && index < this.array.length){
            let element = this.array[index];
            this.array.splice(index, 1);
            this.array.sort((a,b) => a - b);
            this.size--;
            return element;
        }else {
            throw new Error ('Invalid index');
        }
    } 
    //get(index) - returns the value of the element at position index 
    get(index){
        if(index >= 0 && index < this.array.length){
            return this.array[index];
        } else {
            throw new Error ('Invalid index');
        }
    }
    //size - number of elements stored in the collection 
}
let list = new List(); 

list.add(5); 
list.add(6); 
list.add(7); 

console.log(list.get(1));  
list.remove(1); 
console.log(list.get(1));
console.log(list.size);