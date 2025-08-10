import { useState, useEffect } from "react";

function HomeMain(){
    const user = JSON.parse(sessionStorage.getItem("user"));
    const [usersRecipes, setUsersRecipes] = useState([]);
    const [usersCookbooks, setUsersCookbooks] = useState([]);
    const uid = user?.uid;

    useEffect(()=>{
        if(!uid) return;

        async function fetchData(){
            try{
                const recipesRes = await fetch(`http://localhost:8080/recipes/usersLatestRecipes/${uid}`,{
                    credentials: "include",
                });

                const cookbooksRes = await fetch(`http://localhost:8080/recipes/usersLatestCookbooks/${uid}`,{
                    credentials: "include",
                });

                const recipesData = await recipesRes.json();
                const cookbooksData = await cookbooksRes.json();

                setUsersRecipes(recipesData || []);
                setUsersCookbooks(cookbooksData || []);
            }catch(error){
                console.error("failed to fetch user content", error);
            }
        }
        fetchData();
    }, [uid]);

    return(
        <div id="homeMain">
            
            {user ? 
            (<div><h3>welcome back {user.username} !</h3></div>) : 
            (<div><h3>welcome to cook.ie!</h3></div>) }

            {
                user ?
                <div id="mainContentUser">
                    <div id="userRecipes">
                        <h3>your recipes</h3>
                        <div class="list">
                            {!Array.isArray(usersRecipes) && usersRecipes.length === 0 ?(
                                <p>you don't have any recipes yet!</p>
                            ) : (
                                <ul>
                                    {usersRecipes.map((recipe) =>(
                                        <li key={recipe.rid}>{recipe.title}</li>
                                    ))}
                                </ul>
                            )}
                        </div>
                    </div>
                    <div id="userCookbooks">
                        <h3>your cookbooks</h3>
                        <div class="list">
                             {/* {!Array.isArray(usersCookbooks) && usersCookbooks.length === 0 ?(
                                <p>you don't have any cookbooks yet!</p>
                            ) : (
                                <ul>
                                    {usersCookbooks.map((cookbook) =>(
                                        <li key={cookbook.cid}>{cookbook.title}</li>
                                    ))}
                                </ul>
                            )}    */}
                        </div>
                    </div>
                </div> : 
                <div id="mainContent">

                </div>
            }
        </div>
    );
}

export default HomeMain;