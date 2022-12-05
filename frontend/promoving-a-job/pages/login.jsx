import { Col, Container, Row } from 'react-bootstrap';
import FormLogin from '../components/Form';
import NavigationBar from "../components/NavigationBar";

const login = () => {
  return (
    <div>
      <NavigationBar />
      <div>ingrese como empresa</div>
      <Container className="mt-5">
            <Row className="justify-content-center">
                <Col md={5}>
                    <FormLogin />
                </Col>
            </Row>
        </Container>
    </div>
  );
};

export default login;