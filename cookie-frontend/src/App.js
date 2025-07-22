import React, {useEffect, useState} from "react";
import './pages/pages.css';
import './components/components.css';
import {Routes, Route, BrowserRouter} from "react-router-dom";
import PrivateRoute from "./routes/PrivateRoute";
import PublicRoute from "./routes/PublicRoute";
import Home from './pages/Home';
import Login from './pages/Login';
import { Navigate } from "react-router-dom";
import Signup from "./pages/Signup";

function App() {
  const [users, setUsers] = useState([]);

  // useEffect(()=>{
  //   fetch("http://localhost:8080/users")
  //   .then((res)=>res.json())
  //   .then((data)=>setUsers(data))
  //   .catch((err)=>console.error("Error: ", err));
  // }, []); 

  return(
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element= {<Navigate to="/home" />}
        />
        <Route
          path="/login"
          element= {<PublicRoute> <Login/> </PublicRoute>}
        />
        <Route
          path="/signup"
          element= {<PublicRoute> <Signup/> </PublicRoute>}
        />
        <Route
          path="/home"
          element= {<PublicRoute> <Home/> </PublicRoute>}
        />
        
        {/* <Route
          path="/profile"
          element= {<PrivateRoute> <Profile/> </PrivateRoute>}
        /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
