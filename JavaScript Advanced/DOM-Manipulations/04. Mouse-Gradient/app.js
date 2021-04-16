function attachGradientEvents() {
document.getElementById('gradient').addEventListener('mousemove', onMove);

  function onMove(ev){
   let xOffset = ev.offsetX;
let percent = Math.floor(xOffset / ev.target.clientWidth * 100);

document.getElementById('result').textContent = `${percent}%`;
  }
}