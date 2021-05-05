function addItem() {
    let input = document.getElementById('newText').value;
    let ulRef = document.getElementById('items');

    let createLi = document.createElement("LI");
    createLi.textContent += input;
    ulRef.appendChild(createLi);

    let createAnchor = document.createElement("A");
    createAnchor.href = "#";
    createAnchor.textContent += "[Delete]";
    document.getElementById('items').lastChild.appendChild(createAnchor);

    createAnchor.addEventListener("click", onClick);

    function onClick(ev) {
        return ev.target.parentNode.parentNode.removeChild(ev.target);
    }
}