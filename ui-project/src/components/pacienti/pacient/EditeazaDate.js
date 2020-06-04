import React from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from 'axios';
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import './Adaugare.css'

export default class EditeazaDate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            nume: "",
            prenume: "",
            varsta: "",
            adresa: "",
            cnp: "",
        }
    }

    componentDidMount() {
        this.setState({seIncarca: true});

        axios.get('http://localhost:8080/api/pacienti/' + this.props.match.params.id)
            .then(response => {
                this.setState({
                    seIncarca: false,
                    nume: response.data.nume,
                    prenume: response.data.prenume,
                    varsta: response.data.varsta,
                    cnp: response.data.cnp,
                    adresa: response.data.adresa,
                })
            });
    }

    render() {
        const {nume, prenume, varsta, adresa, cnp} = this.state;


        function salveaza() {
            axios({
                method: 'post',
                url: "http://localhost:8080/api/pacienti/adauga",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: 1,
                    nume: nume,
                    prenume: prenume,
                    varsta: varsta,
                    adresa: adresa,
                    cnp: cnp,
                    ingrijitor: 2,
                    supraveghetor: 1,
                    medic: 1
                }
            })
        }

        return (
            <div className="adaugare">
                <h1>Editeaza date pacient</h1>
                <br/>
                <Form>
                    <Row>
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
                    </Row>
                    <Row>
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
                    </Row>
                    <Row>
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
                            <Button variant="primary" type="submit" onClick={() => salveaza()}>
                                Salveaza
                            </Button>
                        </Col>
                    </Row>
                </Form>
            </div>
        )
    }
}
