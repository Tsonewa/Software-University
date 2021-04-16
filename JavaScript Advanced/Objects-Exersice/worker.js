function constructionCrew(worker){

    if(worker.dizziness == true){
       worker.dizziness = false;
       worker.levelOfHydrated += worker.weight * worker.experience / 10;     
    }
    return worker;
} 

console.log(constructionCrew({ weight: 120, 
    experience: 20, 
    levelOfHydrated: 200, 
    dizziness: true } ));