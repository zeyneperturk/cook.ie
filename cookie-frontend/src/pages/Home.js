import Header from '../components/Header';
import Footer from '../components/Footer';
import HomeLeft from '../components/HomeLeft';
import HomeRight from '../components/HomeRight';
import HomeMain from '../components/HomeMain';

function Home({onLogout}){
    return(
        <div>
            <Header onLogout={onLogout}/>
            <article>
                <HomeLeft/>
                <HomeMain/>
                <HomeRight/>
            </article>
            <Footer />
        </div>
    )
}

export default Home;