import React, {Component} from 'react';

import {Navbar, Container, Col} from 'react-bootstrap';
import './Footer.css'

export default class Footer extends Component {
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <Navbar fixed="bottom">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        <div>{fullYear}-{fullYear+1}</div>
                    </Col>
                </Container>
            </Navbar>
        );
    }
}
