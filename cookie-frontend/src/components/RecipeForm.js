import { useState } from "react";
import addIcon from '../img/add.svg';
import removeIcon from '../img/remove.svg';

function RecipeForm(){

    const handleSubmit = async (e) => {
        e.preventDefault();
        const recipe = {
            title,
            description,
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
            id: {
                name: "",
                rid: ""
            },
            quantity: "",
            unit: ""
        }
    ]);

    const [instructions, setSteps] = useState([
        {
            id: {
                step_num: "",
                rid: ""
            },
            text: ""
        }
    ]);

    const formattedInstructions = instructions.map((step, idx) =>({
        ...step,
        id: {
            ...step.id,
            step_num: idx + 1,
        },
    }));

    const ingredientChange = (idx, field, val) => {
        const updated = [...ingredients];
        if(field.includes(".")){
            const keys = field.split(".");
            updated[idx][keys[0]][keys[1]] = val;
        }
        else{
            updated[idx][field] = val;
        }
        setIngredients(updated);
    };

    const addIngredient = () => {
        setIngredients([...ingredients, {id: {name: "", rid: ""}, quantity: "", unit: ""}]);
        console.log("new ingredient");
    };

    const removeIngredient = () => {
        setIngredients(a => a.slice(0, -1));
    }

    const stepChange = (idx, field, val) => {
        const updated = [...instructions];
        if(field.includes(".")){
            const keys = field.split(".");
            updated[idx][keys[0]][keys[1]] = val;
        }
        else{
            updated[idx][field] = val;
        }
        setSteps(updated);
    }

    const addStep = () => {
        setSteps([...instructions, {id: {step_num: "", rid: ""}, text: ""}]);
    }

    const removeStep = () => {
        setSteps(a => a.slice(0, -1));
    }
    return(
        <form id="recipeForm">
            <h2>New Recipe</h2>
            <input placeholder="Recipe Title" id="recipeTitle" type="text" value={title} onChange={(e) => setTitle(e.target.value)}></input>
            <br></br>
            <span id="descLabel">Description: </span>
            <br></br>
            <textarea id="recipeDescription" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>

            <div id="otherInfo">
            <div id="ingredients">
            
                
                <div class="ins-section">
                    <h3>Ingredients</h3>
                <div class="scroll-container">
                {
                    ingredients.map((ing, idx)=>(
                        <div key={idx} class="ingredient">
                            <input placeholder="Ingredient Name"class="ingName" type="text" value={ing.id?.name || ""} onChange={(e)=>ingredientChange(idx, "id.name", e.target.value)}></input>
                            <br></br>
                            <input placeholder="Quantity" class="ingQuantity" type="number" value={ing.quantity} onChange={(e)=>ingredientChange(idx, "quantity", e.target.value)}></input>
                            <input placeholder="Unit" class="ingUnit" type="text" value={ing.unit} onChange={(e)=>ingredientChange(idx, "unit", e.target.value)}></input>
                            <hr></hr>
                        </div>
                        
                    ))
                }
                </div>
                </div>

                <div class="button-container">
                <div class="buttons">
                    <button class="add" type="button" onClick={addIngredient}>Add Ingredient</button>
                    <button class="remove" type="button" onClick={removeIngredient}>Remove Ingredient</button>
                </div>
                     </div>
            </div>

            <div id="instructions">
                
                <div class="ins-section">
                    <h3>Instructions</h3>
                <div class="scroll-container">
                {
                    instructions.map((step, idx)=>(
                        <div key={idx} class="instruction">
                            <label>Step {idx + 1})</label><br></br>
                            <textarea class="step" value={step.text} onChange={(e)=>stepChange(idx, "text", e.target.value)}></textarea>
                        </div>
                    ))
                }
                </div>

                
                <div class="buttons">
                    <button class="add" type="button" onClick={addStep}>Add Step</button>
                    <button class="remove" type="button" onClick={removeStep}>Remove Step</button>
                </div>
                </div>
            </div>
            </div>
            <button id="submit" onClick={handleSubmit} type="submit">Create Recipe</button>
            
        </form>   
    )
}

export default RecipeForm;