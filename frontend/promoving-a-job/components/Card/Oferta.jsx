import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Link from 'next/link';

function Oferta() {
    return (
        <Card className="card">
            <Card.Img variant="top" src="https://picsum.photos/585/400" />
            <Card.Body style={{ backgroundColor: '#05102C', color: 'white' }}>
                <Card.Title>Puesto: Camarero</Card.Title>
                <Card.Text>Ubicación: Buenos Aires</Card.Text>
                <Card.Text className="card-empresa">El galeón</Card.Text>
                <Button className="primario">
                    <Link className="link-btn" href="/oferta/1">
                        Ver info
                    </Link>
                </Button>
            </Card.Body>
        </Card>
    );
}

export default Oferta;
