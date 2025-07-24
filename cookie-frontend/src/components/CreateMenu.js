import { Link } from "react-router-dom";

function CreateMenu(){
    return(
        <div id="createMenu">
            <ul>
                <li><Link to="/newRecipe">new recipe</Link></li>
                <li><Link to="/newCookBook">new cookbook</Link></li>
            </ul>
        </div>
    );
}

export default CreateMenu;