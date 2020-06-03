import React from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";

export default class Recomandari extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            recomandari: []
        }
    }

    componentDidMount() {
        this.setState({seIncarca: true});

        axios.get("http://localhost:8080/api/pacienti/" + this.props.match.params.id + "/recomandari")
            .then(response => {
                this.setState({
                    seIncarca: false,
                    recomandari: response.data
                })
            })
    }

    render() {
        const {seIncarca, recomandari} = this.state;

        if (seIncarca) {
            return <p align={"center"}>Se incarca...</p>
        }

        const listaRecomandari = recomandari.map(recomandare => {

            return <div>
                <h3>Recomandare {recomandare.id}</h3>
                <Form.Group>
                    <Form.Label><b>Tip recomandare</b></Form.Label>
                    <p>{recomandare.tipRecomandare}</p>
                </Form.Group>
                <Form.Group>
                    <Form.Label><b>Durata zilnica</b></Form.Label>
                    <p>{recomandare.durataZilnica} de minute</p>
                </Form.Group>
                <Form.Group>
                    <Form.Label><b>Indicatii</b></Form.Label>
                    <p>{recomandare.indicatii}</p>
                </Form.Group>
                <br/>
                <br/>
            </div>
        });

        return (
            <div>
                <h1 align="center">Recomandari</h1>
                <div align={"center"}>{listaRecomandari}</div>
                <br/>
                <br/>
            </div>

        )
    }
}
