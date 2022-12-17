const mongoose = require('mongoose');
const express = require('express')
const bodyParser = require('body-parser')
var cors = require('cors')

const app = express()
app.use(cors())

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

 async function connection(){
    var db = await mongoose.connect('mongodb://127.0.0.1:27017/MET');

 }
connection();
const Schema = mongoose.Schema;
const BlogPost = new Schema({
    name:String ,
    age: Number,

    
  });
  const MyModel = mongoose.model('users', BlogPost);

app.get("/api/users",async function(req,res){
    // res.send("getworking")
    try{
        //  https://mongoosejs.com/docs/api.html#model_Model-find
        var ans = await MyModel.find()
        res.send(ans)     
    
    }
    catch(err){

    }
})
app.post("/api/users",async function(req,res){
    // res.send("postisworking")
    // console.log(req.body);
    try{
        var obj=new MyModel(req.body)
        var ans= await obj.save()
        res.send(ans)
    }
    catch(err){}

})
app.put("/api/users/:abc", async function(req,res){
    // console.log(req.params);
    // console.log(req.body);

    try{
        var ans= await MyModel.findByIdAndUpdate(req.params.abc,req.body)
        res.send("updated")
        
    }
    catch(err){}
    
})


//<a href="/api/users/639d4cc07bbb0367170d95d2">delete</a>
//https://expressjs.com/en/5x/api.html#req.params
app.delete("/api/users/:xyz",async function(req,res){
    console.log(req.params);
    //{xyz:639d4cc07bbb0367170d95d2}
    try{
        var ans= await MyModel.findByIdAndRemove(req.params.xyz)
        console.log(ans);
        res.send("removed")
    }
    catch(err){
        console.log(err);
    }
    
    
})
app.listen(9000)