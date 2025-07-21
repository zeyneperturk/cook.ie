import React, {useEffect, useState} from "react";
import './pages/pages.css';
import './components/components.css';

function App() {
  const [users, setUsers] = useState([]);

  // useEffect(()=>{
  //   fetch("http://localhost:8080/users")
  //   .then((res)=>res.json())
  //   .then((data)=>setUsers(data))
  //   .catch((err)=>console.error("Error: ", err));
  // }, []); 

  return(
    <body>
      <Login />
    </body>
  );
}

export default App;
