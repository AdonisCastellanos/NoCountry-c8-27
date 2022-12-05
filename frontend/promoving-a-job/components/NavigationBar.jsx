import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { PrimaryBgColor } from "./Theme";

function NavigationBar() {
  return (
    <Navbar style={{ backgroundColor:PrimaryBgColor, height:"5vh"}} expand="lg">
      <Container fluid >
        <Navbar.Brand href="#">LocalJobs</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="container text-center me-auto my-2 my-lg-0 row "
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Nav.Link className="col" href="/">HOME</Nav.Link>
            <Nav.Link className="col" href="/about">ACERCA DE NOSOTROS</Nav.Link>
            <Nav.Link className="col" href="/login">INGRESE COMO EMPRESA</Nav.Link>
            
          </Nav>
          {/*<Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>*/}

        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
export default NavigationBar;
