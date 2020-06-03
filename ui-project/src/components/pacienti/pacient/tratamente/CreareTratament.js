import React from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";
import './Editeaza.css'

export default class CreareTratement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            pacient: this.props.match.params.id,
            observatiiMedic: "",
            observatiiIngrijitor: "",
            oraRezolvare: "",
        }
    }

    render() {
        const {id, pacient ,observatiiMedic, observatiiIngrijitor, oraRezolvare} = this.state;

        function salveazaTratamentul() {
            axios({
                method: 'post',
                url: "http://localhost:8080/api/pacienti/" + pacient + "/tratament",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: id,
                    pacient: pacient,
                    observatiiMedic: observatiiMedic,
                    observatiiIngrijitor: observatiiIngrijitor,
                    oraRezolvare: oraRezolvare,
                    rezolvat: false
                }
            })
        }

        return(
            <div className={"editeazaTratemente"}>
                <h3>Tratament Nou</h3>
                <Form.Group>
                    <Form.Label>Observatiile medicului</Form.Label>
                    <Form.Control as="textarea" row="3" value={observatiiMedic} onChange={data => this.setState({observatiiMedic: data.target.value}) }/>
                </Form.Group>
                <Button variant="primary" type="submit" onClick={() => {salveazaTratamentul(); window.location.replace("/pacienti/" + pacient + "/tratamente")} }>
                    Salveaza
                </Button>
            </div>
        )
    }
}
