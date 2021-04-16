function solve() {
    const outputDiv = document.querySelector(".modules");
    const lectureName = document.querySelector('input[name="lecture-name"]');
    const lectureDate = document.querySelector('input[name="lecture-date"]');
    const module = document.querySelector('select[name="lecture-module"]');
    const addBtn = document.querySelector("button");
    const addedModules = [];
 
addBtn.addEventListener("click", addLectureToTrainings);

function addLectureToTrainings(e) {
    e.preventDefault();
    if (lectureDate.value !== '' && lectureName.value !== '' && module.value !== 'Select module') {
        const moduleDiv = document.createElement("div");
        moduleDiv.className = "module";
        const li = document.createElement("li");
        const h4 = document.createElement("h4");
        li.className = "flex";
        let [date, hours] = lectureDate.value.split("T");
        date = date.replace("-", "/");
        date = date.replace("-", "/");
        h4.innerText = `${lectureName.value} - ${date} - ${hours}`;
        const delBtn = document.createElement("button");
        delBtn.className = "red";
        delBtn.innerText = "Del";
        delBtn.addEventListener("click", removeModule);

        if (!addedModules.includes(module.value)) {
            const ul = document.createElement("ul");
            const h3 = document.createElement("h3");
            h3.innerText = `${module.value.toUpperCase()}-MODULE`;
            moduleDiv.appendChild(h3);
            ul.appendChild(li);
            li.appendChild(h4);
            li.appendChild(delBtn);
            moduleDiv.appendChild(ul);
            outputDiv.appendChild(moduleDiv);
            addedModules.push(module.value);
        } else {
            const allModules = Array.from(document.querySelectorAll("h3"));
            const neededModule = allModules.find((x) => x.innerText === `${module.value.toUpperCase()}-MODULE`);
            neededModule.nextElementSibling.appendChild(li)
            li.appendChild(h4);
            li.appendChild(delBtn);
            const arrLi = Array.from(document.querySelectorAll('li'));
            const sortedDatesArr = arrLi.sort((a, b) => {
                let aDate = getDate(a.innerText)
                let bDate = getDate(b.innerText)
                return aDate.localeCompare(bDate)
            })

            while (neededModule.nextElementSibling.firstChild) {
                neededModule.nextElementSibling.firstChild.remove()
            }

            for (const liEl of sortedDatesArr) {
                neededModule.nextElementSibling.appendChild(liEl)
            }
        }
    }
}

function getDate(currentString) {
    let [subject, date, hour] = currentString.split(' - ');
    while (date.includes('/')) {
        date = date.replace('/', '-')
    }
    return date
}

function removeModule(e) {
    const ulParent = e.target.parentElement.parentElement
    e.target.parentElement.remove()
    const childrenArr = Array.from(ulParent.childNodes)
    if (childrenArr.length === 0) {
        ulParent.parentElement.remove()
    }
}

module.addEventListener("change", function (e) {
    module.value = e.target.value;
});
}


