function sumTable() {
let rows = Array.from(document.querySelectorAll('tbody tr')).slice(1,-1);

let sum = rows.reduce((acc, row) => acc + Number(row.lastElementChild.textContent) , 0); 

document.getElementById('sum').textContent = sum;

}