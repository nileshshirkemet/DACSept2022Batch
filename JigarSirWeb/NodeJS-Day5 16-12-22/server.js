const http=require('http');
// console.log(http);
const server=http.createServer(function(req, res){
    res.end("CDAC")
});

server.listen(8000,"localhost")

// var x=10;
// var x=20;