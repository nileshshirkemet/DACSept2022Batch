1
public/index.html
src/index.js

2
index.html-- pass bootstrp link for css,js

3
create menu comp & export

4) pass navbar from bootstrp into menu comp

5) index.js
import React from "react";
import  ReactDOM  from "react-dom/client";


import Menu from "./components/Menu";
var record = ReactDOM.createRoot(document.getElementById("root"))
record.render(<Menu />)

5-1) 
create 3 components ( home , login ,users)
use this plugin:ES7 React/Redux/GraphQL/

6) https://reactrouter.com/en/main/start/tutorial

npm install react-router-dom
check package.json after installation

7) in index.js lets set routing for
3 components ( home , login ,users)

8) import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom"; in index.js

9) createBrowserRouter() for route creations
const router = createBrowserRouter([
  {
    path:"/",
    element:<Menu />,
    children:[
      {
        path:'/login-page',
        element:<Login />
      },
      {
        path:'/user-page',
        element:<User />
      },
      {
        path:'/',
        element:<Home />
      },
    ]
  } 
])

10) render your const router through
<RouterProvider router={router} />

11) Menu component set 
<outlet  />

12) in Menu Component apply

<Link to="/">Home </Link>
<Link to="/login-page">Home </Link>
<Link to="/user-page">Home </Link>


Fetch values in user Component

1) import React, { useEffect } from 'react'

2) read promise.html file
3) read fetch.html file

4) implement useffect in user component

useEffect(()=>{
    // console.log('CALL API ONLY ONCE');

    fetch('http://localhost:9000/api/users/')
    .then(res=>res.json())
    .then(val=>console.log(val))
    .catch(err=>console.log(err))
  } , []);