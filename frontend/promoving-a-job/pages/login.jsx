import { Col, Container, Row } from 'react-bootstrap';
import FormLogin from '../components/Form';

const empresa = () => {
    return (
        <Container className="mt-5">
            <Row className="justify-content-center">
                <Col md={5}>
                    <FormLogin />
                </Col>
            </Row>
        </Container>
    );
};

export default empresa;
