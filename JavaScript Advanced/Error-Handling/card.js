function printDeckOfCards(cardsArray){
function createCard(face,suit){
    const validCases = ['2','3','4','5', '6','7','8','9','10','J','Q','K','A'];
    let faceToSting = {
        'S': '\u2660',
        'H': '\u2665',
        'D': '\u2666',
        'C': '\u2663',
    };

    if(validCases.includes(face) == false){
        throw new Error('Invalid face');
    } else if (Object.keys(faceToSting).includes(suit) == false){
        throw new Error('Invalid suit');
    }
    return {
        face,
        suit,
        toString() {
            return `${face}${faceToSting[suit]}`;
        }
    };
}

let result = [];

for (const card of cardsArray) {
    try {
        if(card[0] == 1){
            result.push(createCard(card[0] + '0', card[2]).toString());
        } else {
       result.push(createCard(card[0], card[1]).toString());
        }
    } catch (ex) {
        result = 'Invalid card: ' + card;
        
    }
}
 return console.log(result);
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);

