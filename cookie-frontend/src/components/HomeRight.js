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
                {categories.map((cookbook)=>(
                    <li key="{categories.cid}">
                        <h4><Link>{categories.name}</Link></h4>
                    </li>
                ))}
            </div>
        </div>
    );
}

export default HomeRight;