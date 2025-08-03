import { useEffect, useState } from "react";
import {format} from 'date-fns';
import { Link } from "react-router-dom";

function HomeLeft(){
    const [latestRecipes, setLatestRecipes] = useState([]);
    const [latestCookbooks, setLatestCookbooks] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/recipes/latest")
        .then(res => res.json())
        .then(data => setLatestRecipes(data))
        .catch(err => console.error("Failed to fetch latest recipes"));

        fetch("http://localhost:8080/cookbooks/latest")
        .then(res => res.json())
        .then(data => setLatestCookbooks(data))
        .catch(err => console.error("Failed to fetch latest cookbooks"));
    }, [])

    return(
        <div id="left">
            <div id="latestRecipes">
                <h3>latest recipes</h3>
                {latestRecipes.map((recipe)=>(
                    <li key={recipe.rid}>
                        <h4><Link>{recipe.title}</Link></h4>
                        <p>{recipe.description}</p>
                        <span>{format(new Date(recipe.creation_date), 'MMM dd, yyyy')}</span>
                    </li>
                ))}
            </div>
            <div id="latestCookbooks">
                <h3>latest cookbooks</h3>
                {latestCookbooks.map((cookbook)=>(
                    <li key={cookbook.cid}>
                        <h4><Link>{cookbook.title}</Link></h4>
                        <p>{cookbook.description}</p>
                    </li>
                ))}
            </div>
        </div>
    );
}

export default HomeLeft;