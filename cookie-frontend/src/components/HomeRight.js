import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

function HomeRight(){

    const [categories, setCategories] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/categories/popularCategories")
        .then(res => res.json())
        .then(data => setCategories(data))
        .catch(err => console.error("Failed to fetch popular categories."));
    },[]);
    return(
        <div id="right">
            <div id="popularCategories">
                <h3>popular categories</h3>
                {categories.map((categories)=>(
                    <li key="{categories.cid}">
                        <Link>{categories.name}</Link>
                    </li>
                ))}
            </div>
        </div>
    );
}

export default HomeRight;