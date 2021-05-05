function encodeAndDecodeMessages() {
    let encodeBtn = document.querySelectorAll('button')[0];
    let decodeBtn = document.querySelectorAll('button')[1];
    let encodeTextarea = document.querySelectorAll('textarea')[0];
    let decodeTextarea = document.querySelectorAll('textarea')[1];

    encodeBtn.addEventListener('click', encodeMassage);
    decodeBtn.addEventListener('click', decodeMassage);

    function encodeMassage(){
        let inputText = encodeTextarea.value;
        let encodedMsg = '';
        for (let i = 0; i < inputText.length; i++) {
            encodedMsg += String.fromCharCode(ascii(`${inputText[i]}`) + 1);
        }
        encodeTextarea.value = '';
        decodeTextarea.value = encodedMsg;
    }

        function decodeMassage(){
            let inputText = decodeTextarea.value;
            let decodedMsg = '';
            for (let i = 0; i < inputText.length; i++) {
                decodedMsg += String.fromCharCode(ascii(`${inputText[i]}`) - 1);
            }
          
            encodeTextarea.value = decodedMsg;
        }

        function ascii(a) {
            return a.charCodeAt(0);
        }
    }