function addItem() {
    let input = document.getElementById('newItemText').value;
    let listRef = document.getElementById('items');

    let li = document.createElement("LI");
    li.textContent += input;
    listRef.appendChild(li);
}