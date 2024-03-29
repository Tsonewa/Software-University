
import { getArticles } from '../api/data.js';
import { html } from '../node_modules/lit-html/lit-html.js';

const catalogTemplate = (articles) => html`
 <section id="catalog-page" class="content catalogue">
        <h1>All Articles</h1>

      ${articles.length == 0 ? html`<h3 class="no-articles">No articles yet</h3>` : articles.map(articleTemplate)}
        
    </section>`;

    const articleTemplate = (article) => html`
     <a class="article-preview" href="/details/${article._id}">
            <article>
                <h3>Topic: <span>${article.title}</span></h3>
                <p>Category: <span>${article.category}</span></p>
            </article>
        </a>`;


export async function catalogPage(ctx){
    const data = await getArticles();

   ctx.render(catalogTemplate(data));
    
}