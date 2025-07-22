import {Navigate} from "react-router-dom";
import {isLoggedIn} from '../utils/auth';

const PublicRoute = ({children}) => {
    return isLoggedIn() ? <Navigate to="/home" replace /> : children;
};

export default PublicRoute;