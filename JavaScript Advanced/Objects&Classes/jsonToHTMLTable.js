function fromJSONtoHTMLTable (input){
    let tableArr = JSON.parse(input);
    let outputArray = ['<table>'];
    outputArray.push(makeKeyRow(tableArr));

  // <tr><td>Stamat</td><td>5.5</td></tr> 
outputArray.push('</table>'); 

function makeKeyRow(tArray) {
    for (const key of keys) {
                    
    }
'<tr><th>Name</th><th>Score</th></tr>' }
} 