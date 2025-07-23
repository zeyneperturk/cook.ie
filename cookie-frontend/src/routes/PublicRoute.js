import {Navigate} from "react-router-dom";
import {isLoggedIn} from '../utils/auth';

const PublicRoute = ({children, user}) => {
    return user ? <Navigate to="/home" replace /> : children;
};

export default PublicRoute;