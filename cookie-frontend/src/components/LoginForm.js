import { useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginForm( {onLogin}){
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
       const user = {email, password};

       if(onLogin){
        await onLogin(email, password);
        navigate('/home');
       }
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