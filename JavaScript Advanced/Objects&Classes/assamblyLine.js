function createAssemblyLine(){
return {
    hasClima: (myCar) => {
        myCar.temp = 21;
        myCar.tempSettings = 21;
        myCar.adjustTemp = () => {
            if(myCar.temp < myCar.tempSettings){
                myCar.temp += 1;
            } else if (myCar.temp > myCar.tempSettings){
                myCar.temp -= 1;
            }
        };
    },
    hasAudio: (myCar) => {
        myCar.currentTrack = {'name': '', 'artist': ''};
        myCar.nowPlaying = () => {
          if (cmyCr.currentTrack !== null) {
            console.log(`Now playing '${car.currentTrack.name}' by ${car.currentTrack.artist}`);
          }
        };
      },
      hasParktronic: (myCar) => {
        myCar.checkDistance = (distance) => {
          if (distance < 0.1) {
            console.log('Beep! Beep! Beep!');
          } else if (distance >= 0.1 && distance < 0.25) {
            console.log('Beep! Beep!');
          } else if (distance >= 0.25 && distance < 0.5) {
            console.log('Beep!');
          } else {
            console.log('');
          }
        };
      }
    };
}

const assemblyLine = createAssemblyLine(); 
const myCar = { 
    make: 'Toyota', 
    model: 'Avensis' 
}; 

assemblyLine.hasClima(myCar); 
console.log(myCar.temp); 
myCar.tempSettings = 18; 
myCar.adjustTemp(); 
console.log(myCar.temp); 