function solve() {
  //Take the input and parse to string
  let input = document.querySelector('#input').value;
  // Div to append the <p> to
  let output = document.querySelector('#output');

// Split the text in sentences and remove the empty strings
  let sentences = input.split('.').filter(e => e !== '');
  const myNode = document.getElementById("output");
  myNode.innerHTML = '';

while(sentences.length){
  let result = `<p>${sentences.splice(0, 3).join('. ')}</p>`;
  let paragraph = document.createElement("P");                 // Create a <p> node
  let text = document.createTextNode(result);                  // Create a text node
  paragraph.appendChild(text);                                 // Append the text to <p>
  output.appendChild(paragraph); 
}
}