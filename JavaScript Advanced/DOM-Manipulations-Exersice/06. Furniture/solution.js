function solve() {
// Get input field
 let furnitureList = document.querySelectorAll('textarea')[0];
// Get generate btn
let generateBtn = document.querySelectorAll('button')[0];
//Get productsStorage

//Get buyButton
let buyBtn = document.querySelectorAll('button')[1];
//Set click event to Generate btn
generateBtn.addEventListener('click', () => generate());
//function generate({create an object from json file and add it to the table(tr)}
function generate(){
  // Stringify JSON file
  let itemsArray = JSON.parse(furnitureList.value);
  // Put all the products inCart
  for (const item of itemsArray) {
    let {img, name, price, decFactor} = item;
    let itemInfo = `<tr>
    <td>
        <img src="${img}">\n
    </td>\n
    <td>
        <p>${name}</p>
    <td>
        <p>${price}</p>
    </td>\n
    <td>
        <p>${decFactor}</p>
    </td>\n
    <td>
        <input type="checkbox" checked/>
    </td>\n
</tr>`;

document.querySelectorAll('tbody')[0].insertAdjacentHTML('beforEend',itemInfo);
furnitureList.value = '';
  }
}

// Set click event to Buy btn 
buyBtn.addEventListener('click',finishPurchase);

function finishPurchase(){
 let rows = document.querySelectorAll('tbody tr');
 let products = [];
  let total = 0;
  let avrFactor = 0;
 
 rows.forEach(row => {
    if(row.querySelectorAll('input')[0].checked){
      let td = row.querySelectorAll('td');
        products.push(td[1].textContent.trim());
        total += Number(td[2].textContent.trim());
        avrFactor += Number(td[3].textContent.trim());
    }
    });
    document.querySelectorAll('textarea')[1].textContent = 
    `Bought furniture: ${products.join(', ')}.\nTotal price: ${total.toFixed(2)}\nAverage decoration factor: ${(avrFactor / 2).toFixed(2)}`;
  }
} 
