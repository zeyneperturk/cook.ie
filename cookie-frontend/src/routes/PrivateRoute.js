import {Navigate} from "react-router-dom";
import {isLoggedIn} from '../utils/auth';

const PrivateRoute = ({children, user}) => {
    return user ? children : <Navigate to="/home" replace />;
};

export default PrivateRoute;