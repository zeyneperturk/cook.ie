import SignupForm from "../components/SignupForm";
import Footer from '../components/Footer';
import { Link } from 'react-router-dom';
function Signup(){
    return(
        <div id="signup">
            <h1><Link to="/home">cook.ie</Link></h1>
            <SignupForm/>
        </div>
    );
}
export default Signup;