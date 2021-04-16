function create(words) {
   let mainDiv = document.getElementById('content');
  
   for (const word of words) {
      let newDiv = document.createElement('DIV');
      let newParagraph = document.createElement('P');
      newParagraph.textContent = word;
      newParagraph.style.display = 'none';
      newDiv.appendChild(newParagraph);
      mainDiv.appendChild(newDiv);

      newDiv.addEventListener('click', () => {newParagraph.style.display = 'block'});
   }
}