function LoginForm(){
    return(
        <form method="post" id="loginForm">
            <h2>Login</h2>
            <table>
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password"></input></td>
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