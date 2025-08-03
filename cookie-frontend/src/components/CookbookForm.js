import { useState, useEffect } from "react";

function CookbookForm(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [recommendedRecipes, setRecommendedRecipes] = useState([]);
    const [selectedRecipes, setSelectedRecipes] = useState([]);


    useEffect(() => {
     fetch("http://localhost:8080/recipes/recommendedForCookbook")
    .then(res => res.json())
    .then(data => {
      console.log("Fetched recipes:", data); // ✅ check this
      setRecommendedRecipes(data);
    })
    .catch(err => console.error("Failed to fetch recommendations."));
}, []);

    const handleToggle = (recipeId) => {
        setSelectedRecipes(prev =>
        prev.includes(recipeId)
        ? prev.filter(id => id !== recipeId)
        : [...prev, recipeId]
        );
    };


    const handleSubmit = async (e) => {
        e.preventDefault();
        const cookbook = {
            title,
            description,
            recipes: selectedRecipes
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

                    <div id="recommendations">
                        <h3>Recommended Recipes</h3>
                        {recommendedRecipes.map(recipe => (
                            <div key={recipe.rid} style={{ marginBottom: "8px" }}>
                                <label>
                                    <input type="checkbox" checked={selectedRecipes.includes(recipe.rid)} onChange={() => handleToggle(recipe.rid)} />
                                    {recipe.title}
                                </label>
                            </div>
                        ))}
                    </div>

                    <button id="submit" type="submit">create cookbook</button>
                </div>
            </form>
        </div>
    );
}

export default CookbookForm;