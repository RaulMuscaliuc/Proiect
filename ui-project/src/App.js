import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import Welcome from './components/Welcome';
import UserList from './components/UserList';
import Footer from './components/footer/Footer';
import Pacienti from "./components/pacienti/Pacienti";
import { NavigationBar } from './components/navigation/NavigationBar';
import Sidebar from "./components/navigation/side/Sidebar";
import Pacient from "./components/pacienti/Pacient";

export default function App() {

    const heading = "Batranii sunt ai nostri";
    const quote = "......SomeText........";
    const footer = ".......SomeText.......";

    return (
        <Router>
            <NavigationBar/>
            <Sidebar/>
            <Container>
                <Row>
                    <Col lg={12} className={"margin-top"}>
                        <Switch>
                            <Route path="/pacienti" component={Pacienti}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}
