function search() {
  let searchText = document.querySelector('#searchText').value;
  let collectionLi = Array.from(document.querySelectorAll('#towns li'));

      let matches = 0;

      for(i = 0; i < collectionLi.length; i++){
        let current = collectionLi[i].textContent;
        if(current.includes(searchText)){
          matches++;
          collectionLi[i].style.fontWeight = "bold";
          collectionLi[i].style.textDecoration = "underline";
        }
      }
document.getElementById('result').textContent += `${matches} matches found`
}
