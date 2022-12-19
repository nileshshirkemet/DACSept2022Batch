import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function Login(props) {

  var xyz=useNavigate()

  const[name1,updateName1]=useState("kiran")
  const[age1,setAge1]=useState("23")
  // console.log(props);

  var myFunction=()=>{
    // alert()
    // props.a=100;

    console.log(name1,age1);

    //https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
    
    fetch("http://localhost:9000/api/users",{
      method: 'POST',
      headers:{
        'Content-Type': 'application/json'
      },
      body:JSON.stringify({
        name:name1, age:age1
      })
    })
    .then((response) => response.json())
    .then((data) => {
      console.log(data)
      xyz("/user-page")
    });

  }

    var M1=(e)=>{
      // console.log(Math.random());
      // console.log(e);
      // console.log(e.target.value);
      updateName1(e.target.value)
    }
    var M2=(e)=>{
      // console.log(Math.random());
      // console.log(e);
      // console.log(e.target.value);
      setAge1(e.target.value)
    }


  return (
    <div>
      Login
      {props.a},
      {props.b}

      
      <hr />
      <input type="text" onChange={M1} /> <br />
      <input type="text" onChange={M2} /> <br />
      <button onClick={myFunction}>
        Enter
      </button>
      {name1},
      {age1}

    </div>
  )
}

