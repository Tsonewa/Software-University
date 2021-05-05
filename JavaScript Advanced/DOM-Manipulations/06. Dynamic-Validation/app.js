function validate() {
    document.getElementById('email').addEventListener('change', onChange);

    function onChange(ev){
       let input =  ev.target.value;

       if(/^[a-z]+@[a-z]+\.[a-z]+$/.test(input)){
        ev.target.className = '';
       } else {
        ev.target.className = 'error';
       }
    }
}