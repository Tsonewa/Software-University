import { deleteMovie, getMovieById } from '../api/data.js';
import { html } from '../node_modules/lit-html/lit-html.js';

const detailsTemplate = (movie, onDelete) => html`
<section id="movie-details">
                <div class="container">
                    <div class="row bg-light text-dark">
                        <h1>Movie title: ${movie.title}</h1>

                        <div class="col-md-8">
                            <img class="img-thumbnail"
                                src=${movie.img} alt="Movie">
                        </div>
                        <div class="col-md-4 text-center">
                            <h3 class="my-3 ">Movie Description</h3>
                            <p>${movie.description}</p>
                            <a @click=${onDelete}class="btn btn-danger" href="javascript:void(0)">Delete</a>
                            <a class="btn btn-primary" href="/bonus">Like</a>
                            <span class="enrolled-span">Liked ${likes}</span>
                        </div>
                    </div>
                </div>
            </section>`;

export async function detailsPage(ctx){

    
}