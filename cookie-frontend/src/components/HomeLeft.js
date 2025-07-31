import { useEffect, useState } from "react";

function HomeLeft(){
    const [latestRecipes, setLatestRecipes] = useState("");
    const [latestCookbooks, setLatestCookbooks] = useState("");

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

            </div>
            <div id="latestCookbooks"></div>
        </div>
    );
}

export default HomeLeft;