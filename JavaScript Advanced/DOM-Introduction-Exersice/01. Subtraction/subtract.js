function subtract() {
    let firstNumber = document.querySelector('#firstNumber').value;
    let secondNumber = document.querySelector('#secondNumber').value;

    let result = Number(firstNumber) - Number(secondNumber);

    document.getElementById('result').textContent = result;
}