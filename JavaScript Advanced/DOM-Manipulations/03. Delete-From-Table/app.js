function deleteByEmail() {
    let input = document.querySelector('input[name="email"]').value
    let rows = Array.from(document.querySelectorAll('tbody tr'));

    let isDeleted = false;

 for (const row of rows) {
    if(row.children[1].textContent == input){
        row.parentNode.removeChild(row);
        isDeleted = true;
 }
}
 if(isDeleted){
    document.getElementById('result').textContent = "Deleted"
 } else {
    document.getElementById('result').textContent = "Not found"
 }
}