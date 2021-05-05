function extractText() {
    const liElements = document.getElementsByTagName('li');
    const liArray = Array.from(liElements);
    const newText = liArray.map(e => e.textContent);

    document.getElementById('result').value = newText.join('\n');
}