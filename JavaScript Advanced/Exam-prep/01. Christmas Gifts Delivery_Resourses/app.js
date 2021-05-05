function solution() {
    
    let firstSection = document.getElementsByClassName('card')[0];
    let secondSection = document.getElementsByClassName('card')[1];
    let thirdSection = document.getElementsByClassName('card')[2];
    let forthSection = document.getElementsByClassName('card')[3];

    let inputDiv = firstSection.lastElementChild;
    let input = inputDiv.children[0];
    let addBtn = inputDiv.children[1];

    addBtn.addEventListener('click', (e) => {
        e.preventDefault();
        let li = document.createElement('li');
        li.textContent = input.value;
        li.className = 'gift';

        let btnSent = document.createElement('button');
        btnSent.innerText = 'Send'
        btnSent.id = 'sendButton';

        btnSent.addEventListener('click', (e) => {
            e.preventDefault;
            let target = e.target;
            let parent = target.parentElement;
            let discord = parent.lastElementChild;
            parent.removeChild(target);
            parent.removeChild(discord);
            thirdSection.lastElementChild.appendChild(parent);
           
        });
        let discardBtn = document.createElement('button');
        discardBtn.innerText = 'Discard';
        discardBtn.id = 'discardButton';

        discardBtn.addEventListener('click', (e) => {
            e.preventDefault;
            let target = e.target;
            let parent = target.parentElement;
            parent.removeChild(target);
            let sent = parent.lastElementChild;
            parent.removeChild(sent);
            forthSection.lastElementChild.appendChild(parent);
           
        });
       
        li.appendChild(btnSent);
        li.appendChild(discardBtn);

        let ulListOfGifts = secondSection.lastElementChild;
        ulListOfGifts.appendChild(li);

        let arrayListItems = Array.from(ulListOfGifts.querySelectorAll('li'));
        let sortedItems = arrayListItems.sort((a,b) => a.innerText.localeCompare(b.innerText));
        
        for (const gift of sortedItems) {
            ulListOfGifts.appendChild(gift);
        }

        input.value = '';
    });
    //Take ul node and return array with sorted li elements by textContent
        function sortList(ul) {
        
            let ulArray = Array.from(ul.querySelectorAll("li"));
            let sortedItems = ulArray.sort((a,b) => a.innerText.localeCompare(b.innerText));
            
            return sortedItems;

            //for (const gift of sortedItems) {
           //ulListOfGifts.appendChild(gift);
           //}
    }
}