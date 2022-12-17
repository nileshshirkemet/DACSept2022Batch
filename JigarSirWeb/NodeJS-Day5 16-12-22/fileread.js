const fs = require("fs")
// console.log(fs);
console.log("start");
// var result=fs.readFileSync("./topics.txt",'utf-8');
fs.readFile("./topics.txt",'utf-8',function(err,data){
    if(!err){
        console.log(data);
    }
})
// console.log(result);
console.log("end");