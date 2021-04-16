function solve(){
   let author = document.getElementById('creator');
   let title = document.getElementById('title');
   let category = document.getElementById('category');
   let content = document.getElementById('content');
   let btnCreate = document.querySelector('form').lastElementChild;
let posts = document.querySelector('main').lastElementChild;
let archiveSection = document.querySelector('ol');

   btnCreate.addEventListener('click', (event) => {
      event.preventDefault();

     if(author.value === '' || title.value === '' || category.value === '' || content.value === ''){
        return
     }
     
      let article = createE('article', undefined, undefined);
      let h1 = createE('h1', undefined, title.value);

      let categoryPara = createE ('p', undefined, 'Category:');
      let strong = createE('strong', undefined, category.value);
      categoryPara.append(strong);

      let creatorParagraph = createE('p', undefined, 'Creator:');
      let cStrong = createE('strong', undefined, author.value);
      creatorParagraph.append(cStrong);

      let contentP = createE('p', undefined, content.value);

      let btnWrapper = createE('div', 'buttons', undefined);
      let deleteBtn = createE('button', 'btn delete', 'Delete');
      let archiveBtn = createE('button', 'btn archive', 'Archive');
      btnWrapper.appendChild(deleteBtn);
      btnWrapper.appendChild(archiveBtn);

      article.appendChild(h1);
      article.appendChild(categoryPara);
      article.appendChild(creatorParagraph);
      article.appendChild(contentP);
      article.appendChild(btnWrapper);

      posts.appendChild(article);

      deleteBtn.addEventListener('click', (ev) => {
         ev.preventDefault();

         let target = ev.target.parentElement;
         let parent = target.parentElement;
         parent.remove();
      });

      archiveBtn.addEventListener('click', (e) => {
         e.preventDefault();

         let div = e.target.parentElement;
         let parent = div.parentElement;
         let title = parent.getElementsByTagName('h1')[0];
         parent.remove();
         let li = createE('li', undefined, title.textContent);
         archiveSection.appendChild(li);

         let sortedList = sortList(archiveSection);
      for (const lesson of sortedList) {
           archiveSection.appendChild(lesson);
           
		   }
      });

      author.value = '';
      title.value = '';
      category.value = '';
      content.value = '';

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

    function sortList(ul) {
        
      let ulArray = Array.from(ul.querySelectorAll("li"));
      let sortedItems = ulArray.sort((a,b) => a.textContent.localeCompare(b.textContent));
      
      return sortedItems;
  }
}

