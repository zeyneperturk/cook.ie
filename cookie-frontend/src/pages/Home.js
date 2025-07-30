import Header from '../components/Header';
import Footer from '../components/Footer';
import HomeLeft from '../components/HomeLeft';

function Home({onLogout}){
    return(
        <div>
            <Header onLogout={onLogout}/>
            <article>
                <HomeLeft/>
                <div id="main">

                </div>
                <div id="right">

                </div>
            </article>
            <Footer />
        </div>
    )
}

export default Home;