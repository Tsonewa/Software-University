function attachEventsListeners() {
//Take all input fields
let days = document.getElementById('days');
let hours = document.getElementById('hours');
let minutes = document.getElementById('minutes');
let seconds = document.getElementById('seconds');

document.getElementById('daysBtn').addEventListener('click', () => {timeConverter(days.value * 86400)});
document.getElementById('hoursBtn').addEventListener('click', () => {timeConverter(hours.value * 3600)});
document.getElementById('minutesBtn').addEventListener('click', () => {timeConverter(minutes.value * 60)});
document.getElementById('secondsBtn').addEventListener('click', () => {timeConverter(seconds.value)});


function timeConverter(sec){
    let day = sec / 86400;
    let h = sec / 3600;
    let min = sec / 60;
    
    days.value = day;
    hours.value = h;
    minutes.value = min;
    seconds.value = sec; 
}
}