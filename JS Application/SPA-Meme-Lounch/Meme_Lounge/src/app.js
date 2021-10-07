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
import { profilePage } from '../views/profile.js';

const main = document.getElementsByTagName('main')[0];

page('/', decorateContext , guestUsersOnly, homePage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, createPage);
page('/catalog',decorateContext, catalogPage);
page('/details/:id', decorateContext, detailsPage);
page('/edit/:id',decorateContext, editPage);
page('/profile', decorateContext, profilePage);

setUserNav();
page.start();

document.getElementById('logoutBtn').addEventListener('click', async () => {
    await logout();
    setUserNav();
    page.redirect('/');
});

 function guestUsersOnly(ctx, next){
    const token = sessionStorage.getItem('authToken');

    if(token != null){
        return ctx.page.redirect('/catalog')
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
        document.querySelector('div.profile > span').textContent = `Welcome, ${email}`;
        document.querySelector('.user').style.display = 'block';
        document.querySelector('.guest').style.display = 'none';
        } else {
            document.querySelector('.user').style.display = 'none';
        document.querySelector('.guest').style.display = 'block';
        }
}