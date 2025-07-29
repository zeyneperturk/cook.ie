import CookbookForm from "../components/CookbookForm";
import { Link } from "react-router-dom";

function NewCookBook(){
    return(
        <div id="newCookbook">
            <h1><Link to="/home">cook.ie</Link></h1>
            <CookbookForm/>
        </div>
    );
}

export default NewCookBook;