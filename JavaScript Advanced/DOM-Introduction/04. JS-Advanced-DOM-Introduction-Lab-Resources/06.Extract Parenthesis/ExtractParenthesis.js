function extract(content) {
   
let paragraphText = document.getElementById(content).textContent;

let regex = /\((.+?)\)/gm;

let result = [];
let matcher = regex.exec(paragraphText);

while(matcher != null){
    result.push(matcher[1]);

    matcher = regex.exec(paragraphText);
}
document.getElementById('content').textContent = result.join('; ')
}