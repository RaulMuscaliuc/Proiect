import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom';

import Footer from './components/footer/Footer';
import Pacienti from "./components/pacienti/Pacienti";
import NavigationBar  from './components/navigation/NavigationBar';
import Sidebar from "./components/navigation/side/Sidebar";
import Pacient from "./components/pacienti/pacient/Pacient";
import Grafic from "./components/pacienti/grafice/Grafic";
import Tratamente from "./components/pacienti/pacient/tratamente/Tratamente";
import EditeazaTratament from "./components/pacienti/pacient/tratamente/EditeazaTratament";
import Welcome from "./components/Welcome";
import Login from "./components/auth/Login";
import {PrivateRoute} from "./components/auth/PrivateRoute"
import CreareTratament from "./components/pacienti/pacient/tratamente/CreareTratament";

export default class App extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Router>
                <NavigationBar/>
                <Sidebar/>
                <Container className={'content'} fluid>
                    <Row>
                        <Col lg={12} className={"margin-top"}>
                            <Switch>
                                <PrivateRoute path="/" exact={true} component={Welcome}/>
                                <PrivateRoute path="/pacienti" exact={true} component={Pacienti}/>
                                <PrivateRoute path="/pacienti/:id" exact={true} component={Pacient}/>
                                <PrivateRoute path="/pacienti/:id/grafice" exact={true} component={Grafic}/>
                                <PrivateRoute path="/pacienti/:id/tratament" exact={true} component={CreareTratament}/>
                                <PrivateRoute path="/pacienti/:id/tratamente" exact={true} component={Tratamente}/>
                                <PrivateRoute path="/pacienti/:id/tratamente/:tratamentId" exact={true} component={EditeazaTratament}/>
                                <Route path="/login" component={Login} />
                            </Switch>
                        </Col>
                    </Row>
                </Container>
                <Footer/>
            </Router>
        );
    }
}
