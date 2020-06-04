import React from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";
import '../tratamente/Editeaza.css'

export default class CreareAlergie extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            pacient: 1,
            nume: ""
        }
    }

    render() {
        const {id, pacient ,nume} = this.state;

        function salveazaAlegia() {
            axios({
                method: 'post',
                url: "http://localhost:8080/api/pacienti/" + pacient + "/alergie",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: id,
                    pacient: 1,
                    nume: nume
                }
            })
        }

        return(
            <div className={"editeazaTratemente"}>
                <h3>Alegie noua</h3>
                <Form.Group>
                    <Form.Label>Nume alergie</Form.Label>
                    <Form.Control as="textarea" row="3" onChange={data => this.setState({nume: data.target.value}) }/>
                </Form.Group>
                <Button variant="primary" type="submit" onClick={() => {salveazaAlegia(); window.location.replace("/pacienti/" + pacient)} }>
                    Salveaza
                </Button>
            </div>
        )
    }
}
