function solve() {
  let acc =[];
  let text = document.getElementById('text');
  let convention = document.getElementById('naming-convention');
  let result = document.getElementById('result');
  acc = text.value.split(' ');
 
 
  if (convention.value ==='Camel Case') {
    acc = text.value.split(' ');
 
    acc.forEach((word,i) => {
      let changed = word.toLowerCase();
      if (i > 0) {
        changed = changed[0].toUpperCase() + changed.slice(1, changed.length);
      }
      result.textContent += changed;
    });
  }else if(convention.value ==='Pascal Case'){
    acc = text.value.split(' ');
 
    acc.forEach((word,i) => {
      let changed = word.toLowerCase();
      changed = changed[0].toUpperCase() + changed.slice(1, changed.length);
      result.textContent += changed;
    });
  }else{
    result.textContent += 'Error!';
  }
}