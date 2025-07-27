import { useState } from "react";

function RecipeForm(){

    const handleSubmit = async (e) => {
        e.preventDefault();
        const recipe = {
            title,
            ingredients,
            instructions: formattedInstructions
        };

        try{

            console.log(JSON.stringify(recipe, null, 2));
            const response = await fetch("http://localhost:8080/recipes", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                credentials: "include",
                body: JSON.stringify(recipe)
            });

            if(!response.ok){
                throw new Error("failed to create recipe");
            }

            const data = await response.json();
        }catch{
            console.error("error creating recipe");
        }
    }

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState([
        { 
            name: "",
            quantity: "",
            unit: ""
        }
    ]);

    const [instructions, setSteps] = useState([
        {
            stepNo: "",
            text: ""
        }
    ]);

    const formattedInstructions = instructions.map((step, idx) =>({
        ...step,
        stepNo: idx + 1,
    }));

    const ingredientChange = (idx, field, val) => {
        const updated = [...ingredients];
        updated[idx][field] = val;
        setIngredients(updated);
    };

    const addIngredient = () => {
        setIngredients([...ingredients, {name: "", quantity: "", unit: ""}]);
        console.log("new ingredient");
    };

    const removeIngredient = () => {
        setIngredients(a => a.slice(0, -1));
    }

    const stepChange = (idx, field, val) => {
        const updated = [...instructions];
        updated[idx][field] = val;
        setSteps(updated);
    }

    const addStep = () => {
        setSteps([...instructions, {stepNo: "", text: ""}]);
    }

    const removeStep = () => {
        setSteps(a => a.slice(0, -1));
    }
    return(
        <form id="recipeForm">
            <h2>New Recipe</h2>
            <span>Recipe Title:</span>
            <input type="text" value={title} onChange={(e) => setTitle(e.target.value)}></input>
            <span>Description: </span>
            <textarea value={description} onChange={(e) => setDescription(e.target.value)}></textarea>

            <div id="ingredients">
            
                <h3>Ingredients</h3>
                {
                    ingredients.map((ing, idx)=>(
                        <div key={idx}>
                            <label>Name: </label>
                            <input type="text" value={ing.name} onChange={(e)=>ingredientChange(idx, "name", e.target.value)}></input>
                            <label>Quantity: </label>
                            <input type="text" value={ing.quantity} onChange={(e)=>ingredientChange(idx, "quantity", e.target.value)}></input>
                            <label>Unit</label>
                            <input type="text" value={ing.unit} onChange={(e)=>ingredientChange(idx, "unit", e.target.value)}></input>
                        </div>
                    ))
                }

                <button type="button" onClick={addIngredient}>add ingredient</button>
                <button type="button" onClick={removeIngredient}>remove ingredient</button>
            </div>

            <div>
                <h3>Instructions</h3>
                {
                    instructions.map((step, idx)=>(
                        <div key={idx}>
                            <label>{idx + 1}</label>
                            <textarea value={step.text} onChange={(e)=>stepChange(idx, "text", e.target.value)}></textarea>
                        </div>
                    ))
                }
                <button type="button" onClick={addStep}>add step</button>
                <button type="button" onClick={removeStep}>remove step</button>
            </div>

            <button onClick={handleSubmit} type="submit">create recipe</button>
            
        </form>   
    )
}

export default RecipeForm;