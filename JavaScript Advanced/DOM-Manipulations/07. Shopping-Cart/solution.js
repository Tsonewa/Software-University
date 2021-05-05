function solve() {
  let array = Array.from(document.getElementsByClassName("add-product"));
  array.forEach(button => button.addEventListener('click', onClick));
   let total = 0;
   let products = [];
  function onClick(ev){
     
     let title = ev.target.parentNode.parentNode.querySelector(".product-title").textContent;
     let price = ev.target.parentNode.parentNode.querySelector(".product-line-price").textContent;
     let priceDigits = Number(price);
     total += priceDigits;
     products.push(title);
     
     document.querySelector('textarea').innerHTML += `Added ${title} for ${priceDigits.toFixed(2)} to the cart.\n`
  }
  document.querySelector('.checkout').addEventListener('click', checkOut);

  function checkOut(e){
   document.querySelector('textarea').innerHTML += `You bought ${products.join(', ')} for ${total.toFixed(2)}.\n`
  }
}