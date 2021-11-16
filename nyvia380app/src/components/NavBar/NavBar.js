import "./NavBar.css"
import logo from "../../assets/placeholder-image.png"
import { useContext } from "react";
import AuthContext from "context/auth";
import { Link } from "react-router-dom";
import { Container, Navbar, Nav } from "react-bootstrap";
import apiClient from "services/apiClient";


function NavBar () {

    const {user, setUser} = useContext(AuthContext)

    const signout = () => {
        setUser(null)
        apiClient.disconnect()
    }

    return (
        <div className="NavBar">
            <Navbar expand="lg">
                <Container>
                    <Navbar.Brand className="logo">
                        <img className="logo-image" src={logo} alt="Nvyia logo" />
                        <span className="logo-title">Nyvia380</span>
                    </Navbar.Brand>

                    <Navbar.Toggle />

                    <Navbar.Collapse>
                        <Nav className="links" navbarScroll>
                            <Nav.Link as={Link} to="/home" className="link">
                                <h6>
                                    Home
                                </h6>
                            </Nav.Link>

                            {
                                /**TODO change to === */
                                user === null ?
                                    <>
                                    </>

                                    :

                                    <Nav.Link as={Link} to="/messages" className="link">
                                        <h6>
                                            Messages
                                        </h6>
                                    </Nav.Link>
                            }

                            <Nav.Link className="link">
                                <h6>
                                    About
                                </h6>
                            </Nav.Link>

                            {
                                user === null ?
                                    <>
                                        <Nav.Link as={Link} to="/login" className="link">
                                            <h6>
                                                Login
                                            </h6>
                                        </Nav.Link>
                                        <Nav.Link as={Link} to="/register" className="link">
                                            <h6>
                                                Register
                                            </h6>
                                        </Nav.Link>
                                    </>
                                :

                                <Nav.Link onClick={signout} as={Link} to="/login" className="link">
                                    <h6>
                                        Sign Out
                                    </h6>
                                </Nav.Link>

                            }
                            
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    )
}

export default NavBar;