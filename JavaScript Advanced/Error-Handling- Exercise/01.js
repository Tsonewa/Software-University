function requestValidator(inputObject){
if(inputObject.method === undefined || !['GET', 'POST', 'DELETE', 'CONNECT'].includes(inputObject.method)){
    throw new Error (`Invalid request header: Invalid Method`);
}
if(inputObject.url === undefined || !(/\*|^[A-Za-z.]+$/g.test(inputObject.uri))){
    throw new Error (`Invalid request header: Invalid URI`);
}

if(inputObject.version === undefined || !['HTTP/0.9','HTTP/1.0','HTTP/1.1','HTTP/2.0'].includes(inputObject.version)){
    throw new Error (`Invalid request header: Invalid Version`);
}

if(inputObject.message === undefined || (/^[^<>\\&'"]*$/g.test(inputObject.message))){
    throw new Error (`Invalid request header: Invalid Message`);
}
    return inputObject;
}

console.log(requestValidator({ 
    method: 'GET', 
    uri: 'svn.public.catalog', 
    version: 'HTTP/1.1', 
    message: '' 
  }));