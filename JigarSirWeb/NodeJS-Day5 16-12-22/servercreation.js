const http=require("http");
const server= http.createServer(function(req,res){
    res.end("Welcome");
})
server.listen(8000,"localhost");