let task = document.getElementById('task');
let description = document.getElementById('description');
let date = document.getElementById('date');
 let btnAdd = document.getElementById('add');

btnAdd.addEventListener('click', (event) => {
event.preventDefault();

if(task.value == '' || description.value == '' || date.value == ''){
return;
}

let article = document.createElement('article');
let h3 = document.createElement('h3');
h3.innerText = task.value;
let descriptionParagraph = document.createElement('p');
let dateParagraph = document.createElement('p');
descriptionParagraph.innerText = `Description: ${description.value}`;
dateParagraph.innerText = `Due Date: ${date.value}`;

article.appendChild(h3);
article.appendChild(descriptionParagraph);
article.appendChild(dateParagraph);

let btnWrapper = document.createElement('div');
btnWrapper.className = 'flex';

let startBtn = document.createElement('button');
let deleteBtn = document.createElement('button');
let finishBtn = document.createElement('button');
finishBtn.innerText = 'Finish';
finishBtn.className = 'orange';
startBtn.innerText = 'Start'
deleteBtn.innerText = 'Delete'
startBtn.className = 'green';
deleteBtn.className = 'red';

btnWrapper.appendChild(startBtn);
btnWrapper.appendChild(deleteBtn);
article.appendChild(btnWrapper);

let secondSection = document.getElementsByTagName('section')[1];
let divOpen = secondSection.lastElementChild;
divOpen.appendChild(article);

startBtn.addEventListener('click', (e) => {
e.preventDefault();
let sectionProgress = document.getElementById('in-progress');
article.lastElementChild.children[0].remove();

article.lastElementChild.appendChild(finishBtn);

sectionProgress.appendChild(article);
});

deleteBtn.addEventListener('click', (ev) => {
 ev.preventDefault();
 let target = ev.target;
 target.parentElement.parentElement.remove();
});


finishBtn.addEventListener('click', (event) => {
 event.preventDefault()
 let target = event.target;
 target.parentElement.remove();
 let lastSection = document.getElementsByTagName('section')[3].lastElementChild;
 lastSection.appendChild(article);
});

task.value = '';
description.value = '';
date.value = '';
});