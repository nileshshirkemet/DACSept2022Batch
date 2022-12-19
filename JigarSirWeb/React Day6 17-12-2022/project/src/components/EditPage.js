import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

export default function EditPage() {
    var navigate = useNavigate();

    // create state variable to hold values from node js 
    var[userinfo,setuserinfo] = useState({});

    //get value (userid) from url using useParams()
    
    var ans_url = useParams();
    console.log(ans_url);

    //etch values from node js route in useEffect HOOK
    useEffect(()=>{

        fetch(`http://localhost:9000/api/users/${ans_url.userid}`)
        .then(res=>res.json())
        .then(val_from_nodejs=>{
            console.log('DATA FROM NODE JS BY ID');
            console.log(val_from_nodejs);

            //send ur data to textboxes , before that hold ur values in state variable

            setuserinfo(val_from_nodejs);
        })

    } , []);

    var M1 = (e)=>{
        // console.log(e);
        
        console.log(e.target.value);
        console.log(userinfo);

        setuserinfo({...userinfo , name:e.target.value})
    }

    var M2 = (e)=>{
        // console.log(e);
        
        console.log(e.target.value);
        console.log(userinfo);

        setuserinfo({...userinfo , age:e.target.value})
    }

    var updateData = ()=>{
        // alert('update button called')
        // console.log(userinfo);

        fetch(`http://localhost:9000/api/users/${ans_url.userid}` , {
            method:"PUT",
            headers:{
                'Content-Type':'application/JSON'
            },
            body:JSON.stringify(userinfo)
        })
        .then(res=>res.json())
        .then(val=>{
            console.log(val);
            navigate("/user-page")
        })
    }

  return (
    <div>
      <h1>Edit Page</h1>
      <input 
      type="text" 
      value={userinfo.name}
      onChange={M1}
      />
      <br />
      <input type="text" value={userinfo.age} onChange={M2}/>
        <br />
     <button onClick={updateData}> update </button>

    </div>
  )
}
