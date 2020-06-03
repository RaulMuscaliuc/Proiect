import React from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from 'axios';
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import './Adaugare.css'

export default class AdaugarePacient extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            username: "",
            password: "",
            confirmPassword: "",
            nume: "",
            prenume: "",
            varsta: "",
            adresa: "",
            cnp: "",
            ingrijitor: "",
            supraveghetor: "",
            medic: 0
        }
    }

    render() {
        const {username, password, confirmPassword, nume, prenume, varsta, adresa, cnp, ingrijitor, supraveghetor, medic} = this.state;


        function inregistreaza() {
            axios({
                method: 'post',
                url: "http://localhost:8080/api/inregistreaza?username=" + username + "&password=" + password,
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: 0,
                    nume: nume,
                    prenume: prenume,
                    varsta: varsta,
                    adresa: adresa,
                    cnp: cnp,
                    ingrijitor: ingrijitor,
                    supraveghetor: supraveghetor,
                    medic: localStorage.getItem("user").id

                }
            })
        }

        return (
            <div className="adaugare">
                <h1>Adaugare pacient</h1>
                <br/>
            <Form>
                <Row>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Nume de utilizator</b></Form.Label>
                            <Form.Control name="username" value={username}
                                          onChange={data => this.setState({username: data.target.value})}
                                          type="text" placeholder="Introdu numele de utilizator"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Nume</b></Form.Label>
                            <Form.Control name="nume" value={nume}
                                          onChange={data => this.setState({nume: data.target.value})} type="text"
                                          placeholder="Introdu numele"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Adresa</b></Form.Label>
                            <Form.Control name="adresa" value={adresa}
                                          onChange={data => this.setState({adresa: data.target.value})} type="text"
                                          placeholder="Introdu adresa"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Ingrijitor</b></Form.Label>
                            <Form.Control name="ingrijitor" value={ingrijitor}
                                          onChange={data => this.setState({ingrijitor: data.target.value})} type="text"
                                          placeholder="Introdu ingrijitor"/>
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Form.Group controlId="formBasicPassword">
                            <Form.Label><b>Parola</b></Form.Label>
                            <Form.Control name="password" value={password}
                                          onChange={data => this.setState({password: data.target.value})}
                                          type="password" placeholder="Introdu parola"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Prenume</b></Form.Label>
                            <Form.Control name="prenume" value={prenume}
                                          onChange={data => this.setState({prenume: data.target.value})} type="text"
                                          placeholder="Introdu prenume"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>CNP</b></Form.Label>
                            <Form.Control name="cnp" value={cnp}
                                          onChange={data => this.setState({cnp: data.target.value})} type="text"
                                          placeholder="Introdu cnp"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Supraveghetor</b></Form.Label>
                            <Form.Control name="supraveghetor" value={supraveghetor}
                                          onChange={data => this.setState({supraveghetor: data.target.value})}
                                          type="text"
                                          placeholder="Introdu supraveghetor"/>
                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <Form.Group controlId="formBasicPassword">
                            <Form.Label><b>Confirma parola</b></Form.Label>
                            <Form.Control name="confirmPassword" value={confirmPassword}
                                          onChange={data => this.setState({confirmPassword: data.target.value})}
                                          type="password" placeholder="Introdu parola"/>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label><b>Varsta</b></Form.Label>
                            <Form.Control name="username" value={varsta}
                                          onChange={data => this.setState({varsta: data.target.value})} type="text"
                                          placeholder="Introdu varsta"/>
                        </Form.Group>
                    </Col>
                    <Col></Col>
                    <Col>
                        <Button variant="primary" type="submit" onClick={() => inregistreaza()}>
                            Inregistrare
                        </Button>
                    </Col>
                </Row>
            </Form>
            </div>
        )
    }
}
