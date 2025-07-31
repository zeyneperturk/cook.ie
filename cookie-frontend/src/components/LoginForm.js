import { useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginForm( {onLogin}){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
       const user = {username, password};

       if(onLogin){
        await onLogin(username, password);
        navigate('/home');
       }
    }

    return(
        <form onSubmit={handleSubmit} id="loginForm">
            <h2>Login</h2>
            <table>
                <tbody>
                    <tr>
                        <td>username:</td>
                        <td><input type="text" name="username" value={username} onChange={(e)=>setUsername(e.target.value)}></input></td>
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