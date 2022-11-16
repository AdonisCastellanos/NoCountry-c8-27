import { Container, Navbar, Nav } from 'react-bootstrap';
import Link from 'next/link';
import style from './Navbar.module.css';

function NavBar() {
    return (
        <Navbar expand="lg" className="p-4">
            <Container fluid>
                <Navbar.Brand>No Country</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Link className={style['links']} href="/">
                            Home
                        </Link>
                        <Link className={style.links} href="/about">
                            Acerca del proyecto
                        </Link>
                    </Nav>
                    <Link className={style.links} href="/login">
                        Ingresa como empresa
                    </Link>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}
export default NavBar;
