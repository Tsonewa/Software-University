import { html } from '../node_modules/lit-html/lit-html.js';
import { search } from '../api/data.js';

const searchTemplate = (articles, onSearch, title) => html`
 <section id="search-page" class="content">
        <h1>Search</h1>
        <form @submit=${onSearch} id="search-form">
            <p class="field search">
                <input type="text" placeholder="Search by article title" name="search" .value=${title}>
            </p>
            <p class="field submit">
                <input class="btn submit" type="submit" value="Search">
            </p>
            ${articles.length == 0 ? html`<h3 class="no-articles">No matching articles</h3>` : articles.map(articleTemplate)}
        </form>
    </section>`;
    

    const articleTemplate = (article) => html`
    <a class="article-preview" href="/details/${article._id}">
    <article>
        <h3>Topic: <span>${article.title}</span></h3>
        <p>Category: <span>${article.category}</span></p>
    </article>
</a>`;

        export async function searchPage(ctx){
           
            const title = ctx.querystring.split('=')[1];

            const articles = title ? await search(title) : [];

            ctx.render(searchTemplate(articles, onSearch, title));

            async function onSearch(event){
                event.preventDefault();

                const data = new FormData(event.target);
                const query = data.get('search').trim();

                if(query){
                    ctx.page.redirect('/search?query=' + query);
            }
        }
        }