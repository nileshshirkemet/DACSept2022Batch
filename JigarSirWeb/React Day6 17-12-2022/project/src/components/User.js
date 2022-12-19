import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
export default function User() {

  const[xyz,setXyz]=useState([]);

  var navigate=useNavigate()

  var m3= (id)=>{
    // alert(id)
    // return;
    fetch(`http://localhost:9000/api/users/${id}`,{
      method:"delete"
    })
    .then(res=>res.json())
    .then(val=>{
      // console.log(val);
      // navigate("/user-page")
      window.location.reload()
    })
  }
  useEffect(()=>{
    // console.log("fetch");

    fetch("http://localhost:9000/api/users")
    .then(res=> res.json())
    .then(apivalue=>{
       console.log(apivalue);
       setXyz(apivalue)
    })
  },[])
  return (
    <div>
      <table className='table'>
      {
        xyz.length>0 && xyz.map((val)=>
          <tr>
            <td>{val._id}</td>
            <td>{val.name}</td>
            <td>{val.age}</td>
            <td>
              <button onClick={()=>{ m3(val._id)  }}>Delete</button>
            </td>
            <td>
              <Link to={'/edit-page-comp/'+val._id}> Edit</Link>
            </td>
          </tr>
        )
      }
      </table>
      
    </div>
  )
}
