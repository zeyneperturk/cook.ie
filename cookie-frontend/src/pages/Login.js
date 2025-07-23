import LoginForm from '../components/LoginForm'
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';

function Login({onLogin}){
    return(
        <div id="login">
            <h1><Link to="/home">cook.ie</Link></h1>
            <LoginForm onLogin={onLogin}/>
            <Link to="/signup">sign up</Link>
            <Link to="/home">Home</Link>
            <Footer />
        </div>
    );
}

export default Login;