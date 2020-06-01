import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import Footer from './components/footer/Footer';
import Pacienti from "./components/pacienti/Pacienti";
import { NavigationBar } from './components/navigation/NavigationBar';
import Sidebar from "./components/navigation/side/Sidebar";
import Pacient from "./components/pacienti/pacient/Pacient";
import Grafic from "./components/pacienti/grafice/Grafic";

export default function App() {

    const heading = "Batranii sunt ai nostri";
    const quote = "......SomeText........";
    const footer = ".......SomeText.......";

    return (
        <Router>
            <NavigationBar/>
            <Sidebar/>
            <Container className={'content'} fluid>
                <Row>
                    <Col lg={12} className={"margin-top"}>
                        <Switch>
                            <Route path="/pacienti" exact={true} component={Pacienti}/>
                            <Route path="/pacienti/:id" exact={true} component={Pacient}/>
                            <Route path="/pacienti/:id/grafice" exact={true} component={Grafic}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
            <Footer/>
        </Router>
    );
}
