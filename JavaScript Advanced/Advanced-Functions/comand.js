/*function solution(){
    let str = '';

        return {
            append,
            removeStart,
            removeEnd,
            print
        }
    function append(strToAppend){
        str += strToAppend;
    }

    function removeStart(n){
        str = str.substring(n);
    }

    function removeEnd(n){
        str = str.slice(0, -n);
    }

    function print(){
    console.log(str);
    }
}*/
 function solution(arrayString){
    let innerArray = [];
     arrayString.forEach(element => {
        let [operation, value]= element.split(' ');

        if(operation == 'add'){
            add(value);
        } else if (operation == 'remove'){
            remove(value);
        } else if(operation == 'print'){
            print();
        }
     });;
    
return {
    add,
    remove,
    print
}
     function add(string){
       return innerArray.push(string);
     }
     function remove(string){
        for(i = 0; i <innerArray.length; i++){
            if(innerArray[i] == string) {
              innerArray.splice(innerArray.indexOf(string), 1);
            }
          }
          return innerArray;
     }
     function print(){
        console.log(`${innerArray.join(',')}`);
     }
 } 
solution(['add hello', 'add again', 'remove hello', 'add again', 'print']);