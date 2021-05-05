function solve() {
  let task = document.getElementById('task');
  let description = document.getElementById('description');
  let date = document.getElementById('date');
  let addBtn = document.getElementById('add');

  addBtn.addEventListener('click', (event) => {
      event.preventDefault();

      if(task.value == '' || description.value == '' || date.value == ''){
          return;
      }

      let openSectionDiv = document.getElementsByTagName('section')[1].lastElementChild;
      //create the element
      let article = document.createElement('article');
      let h3 = createE('h3', undefined, task.value);
      let descriptionParagraph  = createE('p', undefined, `Description: ${description.value}`);
      let dateParagraph = createE('p', undefined, `Due Date: ${date.value}`);
      
      let buttonsWrapper = createE('div', 'flex', undefined);
      let startBtn = createE('button', 'green', 'Start');
      let deleteBtn = createE('button', 'red', 'Delete');
      let finishBtn = createE('button', 'orange', 'Finish');

      article.appendChild(h3);
      article.appendChild(descriptionParagraph);
      article.appendChild(dateParagraph);

      buttonsWrapper.appendChild(startBtn);
      buttonsWrapper.appendChild(deleteBtn);

      article.appendChild(buttonsWrapper);
      openSectionDiv.appendChild(article);

      startBtn.addEventListener('click', (ev) => {
          ev.preventDefault();
        //btn wrapper
          let target = ev.target;
          let parent = target.parentElement;
          parent.firstElementChild.remove();

          parent.appendChild(finishBtn);
        let progressSection = document.getElementsByTagName('section')[2].lastElementChild;
        let currentArticle = parent.parentElement;
        parent.parentElement.remove();
        progressSection.appendChild(currentArticle);        
      });

      deleteBtn.addEventListener('click', (e) => {
          e.preventDefault();

          let targetDiv = e.target.parentElement.parentElement;
          targetDiv.remove();
      });

      finishBtn.addEventListener('click', (even) => {
          even.preventDefault();

          let btnWrapper = even.target.parentElement;
          let targetDiv = btnWrapper.parentElement;
          btnWrapper.remove();

          let completeSection = document.getElementsByTagName('section')[3].lastElementChild;
          completeSection.appendChild(targetDiv);
      });

      task.value = '';
      description.value = '';
      date.value = '';
  });

  function createE (type, className, content){
    
    let element = document.createElement(type);
    if(className){
        element.className = className;
    }

    if(content){
        element.textContent = content;
    }

    return element;
  }
}