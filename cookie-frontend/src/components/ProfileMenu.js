import { Link } from "react-router-dom";

function ProfileMenu({onLogout}){
    return(
        <div id="profileMenu">
            <ul>
                <li><Link>settings</Link></li>
                <li><Link>bookmarks</Link></li>
                <li><Link to="/home" onClick={onLogout}>log out</Link></li>
            </ul>
        </div>
    );
}

export default ProfileMenu;