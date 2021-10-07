import { deleteArticle, getArticleById } from '../api/data.js';
import { html } from '../node_modules/lit-html/lit-html.js';

const detailsTemplate = (article, onDelete, isOwner) => html`
 <section id="details-page" class="content details">
        <h1>${article.title}</h1>

        <div class="details-content">
            <strong>Published in category ${article.category}</strong>
            <p>${article.content}</p>
            ${isOwner ? html`
             <div class="buttons">
                <a @click=${onDelete} href="javascript:void(0)" class="btn delete">Delete</a>
                <a href="/edit/${article._id}" class="btn edit">Edit</a>
            </div>` : ''}
            <a href="/" class="btn edit">Back</a>
           
        </div>
    </section>
`;

export async function detailsPage(ctx){

    const userId = sessionStorage.getItem('userId');
    const id = ctx.params.id;
   
    const article = await getArticleById(id); 
    ctx.render(detailsTemplate(article, onDelete, userId === article._ownerId));
    

    async function onDelete(){
        const confirmed = confirm('Are you sure you want to delete this item!?');
        if(confirmed){
            await deleteArticle(article._id);
            ctx.page.redirect('/');
        }
    }

}