function focus() {
    let array = Array.from(document.getElementsByTagName('input'));
    array.forEach(element => {
        element.addEventListener('focus', onFocus);
        element.addEventListener('blur', onBlur);
    });

    function onFocus(ev){
        ev.target.parentNode.className = "focused"
    }
    function onBlur(ev){
        ev.target.parentNode.className = "";
    }
    }