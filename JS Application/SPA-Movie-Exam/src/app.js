import page from '../node_modules/page/page.mjs';
import { render } from '../node_modules/lit-html/lit-html.js';
import { logout } from '../api/data.js';

import { homePage } from '../views/home.js';
import { loginPage } from '../views/login.js';
import { registerPage } from '../views/register.js';
import { createPage } from '../views/create.js';
import { catalogPage } from '../views/catalog.js';
import { detailsPage } from '../views/details.js';
import { editPage } from '../views/edit.js';
import { myPage } from '../views/myPage.js';
import { bonusPage } from '../views/bonus.js';

const main = document.getElementById('site-content');

page('/', decorateContext , homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, createPage);
page('/catalog',decorateContext, catalogPage);
page('/details/:id', decorateContext, detailsPage);
page('/edit/:id',decorateContext, editPage);
page('/myPage', decorateContext, myPage);
page('/bonus', decorateContext, bonusPage);

setUserNav();
page.start();

document.getElementById('logoutBtn').addEventListener('click', async () => {
    await logout();
    setUserNav();
    page.redirect('/');
});

function usersOnly(ctx, next){
    const token = sessionStorage.getItem('authToken');

    if(token == null){
        return ctx.page.redirect('/')
    }

    next();
}


export function decorateContext(ctx, next){
    ctx.render = (content) => render(content, main);
    ctx.setUserNav = setUserNav;
    next();
}

function setUserNav(){
    const email = sessionStorage.getItem('email');

    if(email != null){
        document.querySelector('#welcome-msg').textContent = `Welcome, ${email}`;
        document.querySelectorAll('.user').forEach(e => e.style.display = 'inline-block');
        document.querySelectorAll('.guest').forEach(e => e.style.display = 'none');
        } else {
            document.querySelectorAll('.guest').forEach(e => e.style.display = 'inline-block');
            document.querySelectorAll('.user').forEach(e => e.style.display = 'none');
        }
} 