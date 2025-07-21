function LoginForm(){
    return(
        <form method="post">
            <h2>Login</h2>
            <table>
                <tbody>
                    <tr>
                        <td>username</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td colSpan="2"><button>log in</button></td>
                    </tr>
                </tbody>
            </table>
        </form>

        //return to home page link 
    )
}

export default LoginForm;