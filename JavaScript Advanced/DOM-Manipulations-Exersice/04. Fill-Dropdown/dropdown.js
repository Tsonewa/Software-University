function addItem() {
    let  inputText = document.getElementById('newItemText');
    let  inputValue = document.getElementById('newItemValue');
    let dropMenu = document.getElementById('menu');

    let optionTag = document.createElement("OPTION");
    optionTag.textContent = inputText.value;
    optionTag.setAttribute('value', inputValue.value);

    dropMenu.appendChild(optionTag);

    inputText.value = '';
    inputValue.value = '';

}