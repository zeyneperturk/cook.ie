import { Link } from "react-router-dom";
import ProfileMenu from "./ProfileMenu";

function Header(){
    const user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user);
    return(
        <div id="header">
            <h1><Link to="/home">cook.ie</Link></h1>
            <input type="text"></input>
            <div id="nav">
                
                <Link>Explore</Link>
                {user ? 
                (<div><Link>create new</Link><Link>{user.username}</Link><ProfileMenu/></div>) : 
                (<div><Link to="/login">Log In</Link><Link to="/signup">Sign Up</Link></div>)}
            </div>
        </div>
    )
}

export default Header;