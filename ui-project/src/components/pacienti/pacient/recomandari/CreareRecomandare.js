import React from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";
import './Editeaza.css'

export default class CreareRecomandare extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            pacient: this.props.match.params.id,
            durataZilnica: "",
            indicatii: "",
            tipRecomandare: "",
        }
    }

    render() {
        const {id, pacient ,durataZilnica, indicatii, tipRecomandare} = this.state;

        function salveazaRecomandare() {
            axios({
                method: 'post',
                url: "http://localhost:8080/api/pacienti/" + pacient + "/recomandare",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: id,
                    pacient: pacient,
                    durataZilnica: durataZilnica,
                    indicatii: indicatii,
                    tipRecomandare: tipRecomandare
                }
            })
        }

        return(
            <div className={"editeazaTratemente"}>
                <h3>Tratament Nou</h3>
                <Form.Group>
                    <Form.Label>Tip Recomandare</Form.Label>
                    <Form.Control as="textarea" row="3" value={tipRecomandare} onChange={data => this.setState({tipRecomandare: data.target.value}) }/>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Durata zilnica</Form.Label>
                    <Form.Control as="textarea" row="3" value={durataZilnica} onChange={data => this.setState({durataZilnica: data.target.value}) }/>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Indicatii</Form.Label>
                    <Form.Control as="textarea" row="3" value={indicatii} onChange={data => this.setState({indicatii: data.target.value}) }/>
                </Form.Group>
                <Button variant="primary" type="submit" onClick={() => {salveazaRecomandare(); window.location.replace("/pacienti/" + pacient + "/recomandari")} }>
                    Salveaza
                </Button>
            </div>
        )
    }
}
