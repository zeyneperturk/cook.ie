function SignupForm(){

    return(
        <form method="post" id="signupForm">
            <table>
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input></input></td>
                        <td>Last Name:</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input></input></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password"></input></td>
                    </tr>
                    <tr colspan="2">
                        <button>Sign Up</button>
                    </tr>
                </tbody>
            </table>
        </form>
    )
    
}

export default SignupForm;