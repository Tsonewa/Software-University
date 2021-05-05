    function addDestination(){
        
        let [city, country] = document.getElementsByTagName('input');
        let dropDownMenu = document.getElementById('seasons');
        let optionsArray = document.querySelectorAll('option');
        let destinationList = document.getElementById('destinationList');
        
        dropDownMenu.addEventListener("change", function (e) {
            e.preventDefault();
            dropDownMenu.value = e.target.value;
        });

        let summerLabel = document.getElementById('summer');
        let autumnLabel = document.getElementById('autumn');
        let winterLabel = document.getElementById('winter');
        let springLabel = document.getElementById('spring');
        
        let tr = document.createElement('tr');
        let tdDestination = document.createElement('td');
        let tdSeason = document.createElement('td');
        tdDestination.innerText = `${city.value},${country.value}`;
        tdSeason.innerText = dropDownMenu.value;
        
        tr.appendChild(tdDestination);
        tr.appendChild(tdSeason);

        destinationList.appendChild(tr);

        if(dropDownMenu.value === 'Summer'){
            summerLabel.value += 1;
        }else if(dropDownMenu.value === 'Autumn'){
            autumnLabel.value += 1;
        }else if(dropDownMenu.value === 'Winter'){
            winterLabel.value += 1;
        }else if(dropDownMenu.value === 'Spring'){
            springLabel.value +=1;
        }


        city.textContent = '';
        country.textContent = '';

    }
