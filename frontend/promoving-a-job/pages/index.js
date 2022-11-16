import { Col, Container, Row } from 'react-bootstrap';
import Oferta from '../components/Card/Oferta';

export default function Home() {
    return (
        <Container>
            <Row className="justify-content-center">
                <Col md={4}>
                    <Oferta />
                    <Oferta />
                </Col>
            </Row>
        </Container>
    );
}
