import React from 'react';
import { Nav, Navbar, Form, FormControl } from 'react-bootstrap';
import styled from 'styled-components';
import './NavigationBar.scss'
import logo from '../../images/logo2.png'
const Styles = styled.div`
`;
export const NavigationBar = () => (
    <Styles>
        <Navbar expand="lg">
            <Navbar.Brand href="/">
                <img src={logo} width='70px'/>
                <a>Batranii sunt ai nostri</a>
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
        </Navbar>
    </Styles>
);
