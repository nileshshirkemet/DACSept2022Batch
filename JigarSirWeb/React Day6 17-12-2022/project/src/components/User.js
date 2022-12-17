import React, { useEffect } from 'react'


export default function User() {

  
  useEffect(()=>{
    // console.log('CALL API ONLY ONCE');

    fetch('http://localhost:9000/api/users/')
    .then(res=>res.json())
    .then(val=>console.log(val))
    .catch(err=>console.log(err))
  } , []);

  return (
    <div>
      USER COMPO
    </div>
  )
}
