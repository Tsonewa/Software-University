import * as api from '../api/api.js';

const host = 'http://localhost:3030';

api.settings.host = host;

export const login = api.login;
export const logout = api.logout;
export const register = api.register;

export async function getAllMovies(){
    return await api.get(host + '/data/movies');
} 

export async function getMovieLikes(){

    const movieId = sessionStorage.getItem('movieId');
    return await api.get(host + `/data/likes?where=movieId%3D%22${movieId}%22&distinct=_ownerId&count`);
} 


export async function getMovieById(id){
    return await api.get(host + `/data/movies/${id}`);
}

export async function getUserLikes(){
    const userId = sessionStorage.getItem('userId');
    const movieId = sessionStorage.getItem('movieId');
    return await api.get(host + `/data/likes?where=movieId%3D%22${movieId}%22%20and%20_ownerId%3D%22${userId}%22`);
}

export async function createMovie(data){
    return await api.post(host + '/data/movies', data);
}

export async function editMovie(id, data){
    return await api.put(host + '/data/movies/' + id, data);
}

export async function deleteMovie(id){
    return await api.del(host + '/data/movies/' + id);
}

export async function deleteLike(id){
    return await api.del(host + '/data/likes/' + id);
}

//Add a like: /data/likes (POST) 
