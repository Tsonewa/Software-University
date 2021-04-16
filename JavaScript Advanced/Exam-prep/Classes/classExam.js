class Story{
constructor(title, creator, likes = []){
    this.title = title;
    this.creator = creator;
    this.comments = [];
    this.likes = likes;
}

set likes(likes){
    console.log(likes);
    return this._likes = likes;
    }

    get likes(){

        if(this._likes.length == 0){
            return `${this.title} has 0 likes`
        }
    
        if(this._likes.length == 1){
            return `${this._likes[0]} likes this story!`
        }
        let [firstLike, [...restLikes]] = this._likes;
        this._likes = likes;
        return `${firstLike} and ${restLikes.length} others like this story!`;
    }



    like(username){

        if(this.likes.includes(username)){
            throw new Error ('You can`t like the same story twice!')
        }

        if(this.likes.includes(this.creator)){
            throw new Error ('You can`t like your own story!')
        }
        this._likes.push(username);

        return `${username} liked ${this.title}!`
    }

    dislike(username){

        if(!this._likes.includes(username)){
            throw new Error('You can\'t dislike this story!');
        }
        this._likes = this._likes.filter(name => name != username); 
        return `${username} disliked ${this.title}`
    }

    comment(username, content, id){

        if(id === undefined){
            this.comments.push({id: `${this.comments.length + 1}`, username, content});
            return `${username} commented on ${this.title}`
        }

        let found = this.comments.find(user => user.id == id);
        if(found){
            found['replies'] = content;
          
            return  'You replied successfully'
        }
        }

        toString(sortingType){

            let output = [`Title ${this.title}`, `Creator: ${this.creator}`, `Likes: ${this.likes.length}`, `Comments:`];

            if(sortingType == 'asc'){
                this.comments.sort((a,b) => a.id < b.id).map(e => {
                    output.push(`-- ${e.id}. ${e.username}: ${e.content}`);
                });
            }else if(sortingType == 'desc'){
                this.comments.sort((a,b) => a.id > b.id).map(e => {
                    output.push(`-- ${e.id}. ${e.username}: ${e.content}`);
                });
            }else if(sortingType == 'username'){
                this.comments.sort((a,b) => a.username.localeCompare(b.username)).map(e => {
                    output.push(`-- ${e.id}. ${e.username}: ${e.content}`);
                });
            }

            return output.join('\n');
    }
}


let art = new Story("My Story", "Anny"); 

art.like("John"); 
console.log(art.likes); 
art.dislike("John"); 
console.log(art.likes); 
art.comment("Sammy", "Some Content"); 
console.log(art.comment("Ammy", "New Content")); 
art.comment("Zane", "Reply", 1); 
art.comment("Jessy", "Nice :)"); 
console.log(art.comment("SAmmy", "Reply@", 1)); 
console.log(art.toString('username')); 
console.log() 
art.like("Zane"); 
console.log(art.toString('desc')); 