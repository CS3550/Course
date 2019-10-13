var http = require('http'),
httpProxy = require('http-proxy');
 
//
// From: https://www.npmjs.com/package/http-proxy
//
var proxy = httpProxy.createProxyServer({});
 


 
var server = http.createServer(function(req, res) {
  console.log("Proxying");
console.log(req.headers.host);

if(req.headers.host.startsWith("a")){
  proxy.web(req, res, {
    target: 'http://127.0.0.1:3000'
  });
}
else {
  proxy.web(req, res, {
    target: 'http://127.0.0.1:4000'
  });
}
});
 
console.log("listening on port 80")
server.listen(80);
