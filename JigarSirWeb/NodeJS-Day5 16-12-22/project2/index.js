// db connection
const mongoose = require('mongoose');
async function connect(){
    var db=await mongoose.connect('mongodb://127.0.0.1:27017/MET')
    // console.log(db)
}
connect()
// db connection


// db prepare
const Schema = mongoose.Schema;
const usersschema = new Schema({
    name:String,
  age:Number    
})
const userModel = mongoose.model('users', usersschema);
// db prepare

//creat routes in node using express
const express = require('express')
const app = express()
app.get('/api/users', async function (req, res) {
    //fetch record from mongo db 
    try{
        var answer = await userModel.find();
        res.send(answer)
    }
    catch(err){

    }
    
})

/*
app.get('/api/users/:abcd', async function (req, res) {
    //fetch record from mongo db 
    try{
        console.log(req.params); //{abcd:CDAC}
        var answer = await userModel.findOne({name:req.params.abcd});
        res.send(answer)
    }
    catch(err){

    }
    
})
*/
  app.listen(9000)

  //

