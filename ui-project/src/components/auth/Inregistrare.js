import React from "react";
import {InputGroup} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from 'axios';

export default class Inregistrare extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            username: "",
            password: "",
            confirmPassword: "",
            role: ""
        }
    }

    render() {
        const {username, password, confirmPassword, role} = this.state;

        function inregistreaza() {
            axios({
                method: 'post',
                url: "http://localhost:8080/inregistreaza",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: 0,
                    username: username,
                    password: password,
                    role: role
                }
            })
        }

        return (
            <InputGroup className="justify-content-md-center">
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label><b>Nume de utilizator</b></Form.Label>
                        <Form.Control name="username" value={username} onChange={data => this.setState({username: data.target.value})} type="text" placeholder="Introdu numele de utilizator"/>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label><b>Parola</b></Form.Label>
                        <Form.Control name="password" value={password} onChange={data => this.setState({password: data.target.value})} type="password" placeholder="Introdu parola"/>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label><b>Confirma parola</b></Form.Label>
                        <Form.Control name="confirmPassword" value={confirmPassword} onChange={data => this.setState({confirmPassword: data.target.value})} type="password" placeholder="Introdu parola"/>
                    </Form.Group>

                    <Form.Group controlId="formBasicEmail">
                        <Form.Label><b>Rol</b></Form.Label>
                        <Form.Control name="username" value={role} onChange={data => this.setState({role: data.target.value})} type="text" placeholder="Introdu rolul"/>
                    </Form.Group>

                    <Button variant="primary" type="submit" onClick={() => inregistreaza()}>
                        Inregistrare
                    </Button>
                </Form>
            </InputGroup>
        )
    }
}
