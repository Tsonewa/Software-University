function filterEmployee(data, criteria){
    let employees = JSON.parse(data);;
    let [objField, value] = criteria.split('-');
   
    let filteredEmployees = employees.filter((employee) => employee[objField] == value);
    
    return printArray(sortAlphabetically(filteredEmployees));

    function sortAlphabetically(unsortedData){
        let sortedArray = unsortedData.sort((a,b) => a - b);
    
        return sortedArray;
    }

        function printArray(inputArray){
            let output = [];
        
           inputArray.map((e, i) => {
                output.push(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
           });
          return output.join('\n');
        }
    }

console.log(filterEmployee(`[{"id": "1","first_name": "Ardine","last_name": "Bassam","email": "abassam0@cnn.com","gender": "Female"},\
{"id": "2","first_name": "Kizzee","last_name": "Jost", "email": "kjost1@forbes.com","gender": "Female"},\
{"id": "3","first_name": "Evanne","last_name": "Maldin", "email": "emaldin2@hostgator.com", "gender": "Male"}]`, 'gender-Female'));