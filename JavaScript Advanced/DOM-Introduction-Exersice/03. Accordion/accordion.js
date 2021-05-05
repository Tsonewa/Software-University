function toggle() {
    let actionDiv = document.querySelector('#extra');
    let button = document.querySelector('.button');

if(button.textContent === 'More'){
    actionDiv.style.display = 'block';
    button.textContent = 'Less';
} else {
    actionDiv.style.display = 'none';
    button.textContent = 'More';
}
}