import { useState } from "react";

function CookbookForm(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

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
        <form id="cookbookForm">
            <h2>New Cookbook</h2>
            <label>Title: </label>
            <input type="text" value={title} onChange={(e) => setTitle(e.target.value)}></input>
            <label>Description</label>
            <textarea value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
            <button onSubmit={handleSubmit} type="submit">create cookbook</button>
        </form>
    );
}

export default CookbookForm;