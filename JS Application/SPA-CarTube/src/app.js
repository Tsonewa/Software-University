import page from '../node_modules/page/page.mjs';
import { render } from '../node_modules/lit-html/lit-html.js';
import { logout } from '../api/data.js';

import { homePage } from '../views/home.js';
import { loginPage } from '../views/login.js';
import { registerPage } from '../views/register.js';
import { createPage } from '../views/create.js';
import { allListingPage } from '../views/all-listing.js';
import { detailsPage } from '../views/details.js';
import { editPage } from '../views/edit.js';
import { myListingPage } from '../views/my-listing.js';
import { searchPage } from '../views/search.js';

const main = document.getElementById('site-content');

page('/', decorateContext , homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, usersOnly, createPage);
page('/all-listing',decorateContext, allListingPage);
page('/details/:id', decorateContext, detailsPage);
page('/edit/:id',decorateContext, editPage);
page('/my-listing', decorateContext, myListingPage);
page('/search', decorateContext, searchPage);

setUserNav();
page.start();

document.getElementById('logoutBtn').addEventListener('click', async () => {
    await logout();
    setUserNav();
    page.redirect('/');
});


export function decorateContext(ctx, next){
    ctx.render = (content) => render(content, main);
    ctx.setUserNav = setUserNav;
    next();
}

function setUserNav(){
    const username = sessionStorage.getItem('username');

    if(username != null){
        document.querySelector('div #profile > a').textContent = `Welcome, ${username}`;
        document.querySelector('#profile').style.display = 'block';
        document.querySelector('#guest').style.display = 'none';
        } else {
        document.querySelector('#profile').style.display = 'none';
        document.querySelector('#guest').style.display = 'block';
        }
}