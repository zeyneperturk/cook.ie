import React, {useEffect, useState} from "react";
import './pages/pages.css';
import './components/components.css';
import {Routes, Route, BrowserRouter} from "react-router-dom";
import PrivateRoute from "./routes/PrivateRoute";
import PublicRoute from "./routes/PublicRoute";
import Home from './pages/Home';
import Login from './pages/Login';
import Profile from "./pages/Profile";
import { Navigate } from "react-router-dom";
import Signup from "./pages/Signup";
import NewRecipe from "./pages/NewRecipe";
import NewCookBook from "./pages/NewCookBook";

 async function login(email, password) {
    const response = await fetch('http://localhost:8080/users/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      credentials: 'include',
      body: JSON.stringify({email, password}),
    });

    if(!response.ok)
    {
      throw new Error('invalid email or password')
    }

    const user = await response.json();
    return user;
  }

  async function fetchCurrentUser(){
    const response = await fetch('http://localhost:8080/users/session', 
      {method: 'GET', 
        headers: {"Content-Type": "application/json"},
        credentials: 'include',});
    
    if(!response.ok)
      return null;

    return await response.json();
  }

  async function logout(){
    await fetch('http://localhost:8080/users/logout',{
      method: 'POST',
      credentials: 'include',
    });

    sessionStorage.removeItem("user");
  }

function App() {
  const [user, setUser] = useState(null);
  const [error, setError] = useState(null);

  useEffect(()=>{
    fetchCurrentUser().then((user)=>{
      if(user)
      {
        setUser(user);
        sessionStorage.setItem("user", JSON.stringify(user));
      }
    }).catch(()=>{setUser(null);
        sessionStorage.removeItem("user");
    })
  }, []);

  async function handleLogin(email, password)
  {
    try{
      const loggedUser = await login(email, password);
      setUser(loggedUser);
      setError(null);
      sessionStorage.setItem("user", JSON.stringify(loggedUser));
    }catch(e){
      setError(e.message);
    }
  }

  async function handleLogout(){
      await logout();
      setUser(null);
    }

  return(
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element= {<Navigate to="/home" />}
        />
        <Route
          path="/login"
          element= {<PublicRoute user={user}> <Login onLogin={handleLogin}/> </PublicRoute>}
        />
        <Route
          path="/signup"
          element= {<PublicRoute user={user}> <Signup/> </PublicRoute>}
        />
        <Route
          path="/home"
          element= {<Home onLogout={handleLogout}/>}
        />
        
        <Route
          path="/profile"
          element= {<PrivateRoute user={user}> <Profile onLogout={handleLogout}/> </PrivateRoute>}
        />
        <Route 
          path="/newRecipe"
          element= {<PrivateRoute user={user}><NewRecipe/></PrivateRoute>}
        />
        <Route
          path="/newCookbook"
          element={<PrivateRoute user={user}><NewCookBook/></PrivateRoute>}
        />
          
      </Routes>
    </BrowserRouter>
  );
}

export default App;
