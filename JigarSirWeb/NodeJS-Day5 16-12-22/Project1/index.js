// console.log("hello world");

/* db connection*/

const mongoose = require('mongoose');
async function connection(){
    var db = await mongoose.connect('mongodb://127.0.0.1:27017/MET');
    console.log(db);
}
connection()
/* db connection*/
