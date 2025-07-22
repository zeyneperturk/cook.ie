export const isLoggedIn = () => {
    return !!localStorage.getItem("userToken");
}