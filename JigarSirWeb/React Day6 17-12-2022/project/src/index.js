import React from 'react';
import ReactDOM from 'react-dom/client';
import Menu from './components/Menu';

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Login from './components/Login';
import User from './components/User';
import Home from './components/Home';

// Create routes using createBrowserRouter()
// localhost:3000/c
const router1 = createBrowserRouter([
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

const record = ReactDOM.createRoot(document.getElementById('root'));

// record.render(<Menu />);
record.render(
  <RouterProvider router={router1} />
)