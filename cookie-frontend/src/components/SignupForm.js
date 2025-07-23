import { useState } from "react";

function SignupForm(){

    const [first_name, setFirstName] = useState('');
    const [last_name, setLastName] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {


        const user = {first_name, last_name, username, email, password};

        fetch("http://localhost:8080/users", {method: "POST", headers: {"Content-Type": "application/json",}, body:JSON.stringify(user),})
        .then((res) => {
            if(!res.ok){
                throw new Error("Failed to create user");
            }
            return res.json();
        })
        .then((data)=>{
            console.log("User created: ", data);
        })
        .catch((err)=>{
            console.error("Error: ", err);
        });
    }

    return(
        <form onSubmit={handleSubmit} id="signupForm">
            <h2>Sign Up</h2>
            <span>Username:</span>
            <br></br>
            <input type="text" value={username} onChange={(e) => setUsername(e.target.value)}></input>
            <br></br>
            <table>
                <tbody>
                    <tr>
                        <td>
                            First Name:
                        </td>
                        <td>
                            Last Name:
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" value={first_name} onChange={(e) => setFirstName(e.target.value)}></input>
                        </td>
                        <td>
                            <input type="text" value={last_name} onChange={(e) => setLastName(e.target.value)}></input>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br></br>
            <span>Email:</span>
            <br></br>
            <input type="text" value={email} onChange={(e) => setEmail(e.target.value)}></input>
            <br></br>
            <span>Password:</span>
            <br></br>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)}></input>
            <br></br>
            <button type="submit">Sign Up</button>
        </form>
    )
    
}

export default SignupForm;