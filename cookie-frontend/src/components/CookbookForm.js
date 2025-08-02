import { useState, useEffect } from "react";

function CookbookForm(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [recommendedRecipes, setRecommendedRecipes] = useState("");

    useEffect(()=>{
            fetch("http://localhost:8080/recipes/recommendedForCookbook")
            .then(res => res.json())
            .then(data => setRecommendedRecipes(data))
            .catch(err => console.error("Failed to fetch recommendations."));
        },[]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const cookbook = {
            title,
            description
        };

        try{
            const response = await fetch("http://localhost:8080/cookbooks", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                credentials: "include",
                body: JSON.stringify(cookbook)
            });

            console.log(JSON.stringify(cookbook));

            if(!response.ok){
                throw new Error("failed to create cookbook");
            }

            const data = await response.json();
        }catch{
            console.error("error creating cookbook");
        }
    }

    return(
        <div>
        <form id="cookbookForm" onSubmit={handleSubmit}>
            <h2>New Cookbook</h2>
            <div id="fields">
            <input placeholder="Cookbook Title" id="cookbookTitle" type="text" value={title} onChange={(e) => setTitle(e.target.value)}></input>
            <br></br> 
            <label id="descLabel">Description</label>
            <br></br>
            <textarea id="cookbookDesc" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
            <br/>
            <button id="submit" type="submit">create cookbook</button>
            </div>
        </form>

        <div>

        </div>
                </div>
    );
}

export default CookbookForm;