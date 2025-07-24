import { Link } from "react-router-dom";
import RecipeForm from "../components/RecipeForm";

function NewRecipe(){
    return(
        <div id="newRecipe">
            <h1><Link to="/home">cook.ie</Link></h1>
            <RecipeForm/>
        </div>
    );
}

export default NewRecipe;