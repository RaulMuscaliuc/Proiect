import React from 'react';
import {Nav, Navbar, Form, FormControl, Button} from 'react-bootstrap';
import styled from 'styled-components';
import './NavigationBar.css'
import logo from '../../images/logo2.png'
const Styles = styled.div``;

const data = localStorage;
let show = false;
let user;
console.log(data);
if(data.length === 1) {
     show = true;
     user = JSON.parse(localStorage.getItem('user'));
}
export default class NavigationBar extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Styles>
                <Navbar expand="lg" fixed="top">
                    <Navbar.Brand href="/">
                        <img src={logo} width='70px'/>
                        <a>Health Monitor</a>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    {show ? <Navbar.Collapse className="justify-content-end"><h4>{user.username}</h4><Button onClick={() => {localStorage.clear(); window.location.replace('/')}}>Logout</Button></Navbar.Collapse> : ""}
                </Navbar>
            </Styles>
        )
    }
}

