import { Col, Container, Row } from 'react-bootstrap';
import Oferta from '../components/Card/Oferta';

import { useState } from "react";
import AppFooter from "../components/AppFooter";
import JobCard from "../components/JobCard";
import NavigationBar from "../components/NavigationBar";
import { PrimaryBgLightColor } from "../components/Theme";
export default function Home() {
  const [jobs, SetJobs] = useState([]);

  return (
    <div>
      <NavigationBar />
      <section className="container-fluid text-center " 
      style={{backgroundColor:PrimaryBgLightColor,
            height:"85vh",
            backgroundImage: `url(/background.jpg)`, //${backImg}
            backgroundSize:"100% 100%"
      }}>

        <h4>Ofertas laborales</h4>
        <div>filtros</div>
        {
          !jobs          
          ?jobs.map(job => <JobCard key={job.id}></JobCard>)
          :<JobCard key={1} cadImg="/../public/no-image.png" cardContent="loading...."></JobCard>
        }
        
      </section>
      <Container>
            <Row className="justify-content-center">
                <Col md={4}>
                    <Oferta />
                    <Oferta />
                </Col>
            </Row>
        </Container>
      <AppFooter/>
    </div>
  );
}
