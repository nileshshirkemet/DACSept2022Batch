const fs=require("fs");
const http =require("http");
const server=http.createServer(function(req,res){
    // console.log(req.url)
    if(req.url=="/"){
        filename="./home.html"
    }
    if(req.url=="/about"){
        filename="./about.html"
    }
    if(req.url=="/service"){
        filename="./service.html"
    }

    fs.readFile(filename,'utf-8',function(error,data){
        res.end(data)
    })
});
server.listen(8000)