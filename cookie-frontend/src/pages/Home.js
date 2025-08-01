import Header from '../components/Header';
import Footer from '../components/Footer';
import HomeLeft from '../components/HomeLeft';
import HomeRight from '../components/HomeRight';

function Home({onLogout}){
    return(
        <div>
            <Header onLogout={onLogout}/>
            <article>
                <HomeLeft/>
                <div id="main">

                </div>
                <HomeRight/>
            </article>
            <Footer />
        </div>
    )
}

export default Home;