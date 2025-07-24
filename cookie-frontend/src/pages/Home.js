import Header from '../components/Header';
import Footer from '../components/Footer';

function Home({onLogout}){
    return(
        <div>
            <Header onLogout={onLogout}/>
            
            <Footer />
        </div>
    )
}

export default Home;