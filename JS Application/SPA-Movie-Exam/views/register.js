import { register } from '../api/api.js';
import { html } from '../node_modules/lit-html/lit-html.js';

const registerTemplate = (onSubmit) => html`
 <section id="form-sign-up">
                <form @submit=${onSubmit} class="text-center border border-light p-5">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" placeholder="Email" name="email" >
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" placeholder="Password" name="password" >
                    </div>

                    <div class="form-group">
                        <label for="repeatPassword">Repeat Password</label>
                        <input type="password" class="form-control" placeholder="Repeat-Password" name="repeatPassword">
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </section>`;

export async function registerPage(ctx){

    ctx.render(registerTemplate(onSubmit));

    async function onSubmit(event){
        event.preventDefault();

        const formData = new FormData(event.target);
        const email = formData.get('email');
        const password = formData.get('password');
        const repeatPassword = formData.get('repeatPassword');

        if(email == '' || password == '' || repeatPassword == ''){
            return alert('All fields are required!');
        }

        if(password != repeatPassword){
            return alert('Passwords don\'t match!')
        }

        if(password.length < 6 ){
            return alert('The password should be at least 6 characters!')
        }
        await register({email, password});
        ctx.setUserNav();
        ctx.page.redirect('/')
    }
}