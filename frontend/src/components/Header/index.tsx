import logo from '../../assets/img/logo.svg'

import './styles.css'

function Header() {
    return (
        <>
            <header>
                <div className="dsmeta-logo-container">
                    <img src={logo} alt="DSMeta" />
                    <h1>DSMeta</h1>
                    <a href="https://www.linkedin.com/in/giovane-derenevick-filho">Giovane Derenevick Filho</a>
                </div>
            </header>
        </>
    )
  }
  
  export default Header