import { html } from '../node_modules/lit-html/lit-html.js';
import { getMostRecentArticles } from '../api/data.js';

const homeTemplate = (articles) => html`
 <section id="home-page" class="content">
        <h1>Recent Articles</h1>
       ${articles.length == 0 ? html`<h3 class="no-articles">No articles yet</h3>` : articles.map(articleTemplate)}
   `;

   const articleTemplate = (article)=> html`
   <section class="recent js">
            <h2>${article.category}</h2>
            <article>
                <h3>${article.title}</h3>
                <p>${article.content}</p>
                <a href="/details/${article._id}" class="btn details-btn">Details</a>
            </article>
        </section>`;

export async function homePage(ctx){
   const articles = await getMostRecentArticles();
  ctx.render(homeTemplate(articles));
}