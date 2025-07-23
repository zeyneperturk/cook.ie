import { useState } from "react";

function LoginForm(){
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (e) => {
       

    }

    return(
        <form onSubmit={handleSubmit} id="loginForm">
            <h2>Login</h2>
            <table>
                <tbody>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value={email} onChange={(e)=>setEmail(e.target.value)}></input></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value={password} onChange={(e)=>setPassword(e.target.value)}></input></td>
                    </tr>
                    <tr>
                        <td colSpan="2"><button>Login</button></td>
                    </tr>
                </tbody>
            </table>
        </form>
    )
}

export default LoginForm;