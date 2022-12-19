import React, { Children } from "react";
import  ReactDOM  from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
}from "react-router-dom";

import Menu from './components/Menu'
import Home from './components/Home'
import Login from './components/Login'
import User from './components/User'
import EditPage from "./components/EditPage";
import Register from "./components/Register";
import Parent from "./components/Parent";

const router1=createBrowserRouter([
  {
    path:"/",
    element:<Menu/>,
    children:[
        {
          path:"/",
          element:<Home/>
        },
        {
          path:"/login-page",
          element:<Login a="10" b="20"/>

        },
        {
          path:"/user-page",
          element:<User/>
        },
        {
          path:"/edit-page-comp/:userid",
          element:<EditPage />
        },
        {
          path:"/Register",
          element:<Register/>
        },
        {
          path:"/Parent",
          element:<Parent/>
        }



    ]
  }
])
ReactDOM.createRoot(document.getElementById("root")).render(
  
    <RouterProvider router={router1} />
  
);