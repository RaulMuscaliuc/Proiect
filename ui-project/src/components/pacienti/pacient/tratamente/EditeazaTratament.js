import React from "react";
import axios from "axios";
import {Button, Form} from "react-bootstrap";
import './Editeaza.css'

export default class EditeazaTratament extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            id: 0,
            observatiiMedic: "",
            observatiiIngrijitor: "",
            oraRezolvare: "",
            rezolvat: 0,
        }
    }

    componentDidMount() {
        this.setState({seIncarca: true});

        axios.get("http://localhost:8080/api/tratamente/" + this.props.match.params.tratamentId)
            .then(response => {
                this.setState({
                    seIncarca: false,
                    id: this.props.match.params.tratamentId,
                    pacient: this.props.match.params.id,
                    observatiiMedic: response.data.observatiiMedic,
                    observatiiIngrijitor: response.data.observatiiIngrijitor,
                    oraRezolvare: response.data.oraRezolvare,
                    rezolvat: response.data.rezolvat,
                })
            });
    }

    render() {
        let role = "";
        if (localStorage.length === 1) {
            role = JSON.parse(localStorage.getItem("user")).role;
        }
        const {seIncarca, id, pacient, observatiiMedic, observatiiIngrijitor, oraRezolvare, rezolvat} = this.state;
        let bifat = false;

        if (seIncarca) {
            return <p align={"center"}>Se incarca...</p>
        }

        function modificaTratamentul() {
            console.log(bifat);
            axios({
                method: 'put',
                url: "http://localhost:8080/api/tratamente",
                headers: {
                    'Access-Control-Allow-Origin': '*'
                },
                data: {
                    id: id,
                    pacient: pacient,
                    observatiiMedic: observatiiMedic,
                    observatiiIngrijitor: observatiiIngrijitor,
                    oraRezolvare: oraRezolvare,
                    rezolvat: bifat
                }
            })
        }

        return(
            <div className={"editeazaTratemente"}>
                <h3>Tratament</h3>
                <Form.Group>
                    <Form.Label><b>Observatiile medicului</b></Form.Label>
                    {role === "medic" ? <Form.Control as="textarea" row="3" value={observatiiMedic} onChange={data => this.setState({observatiiMedic: data.target.value}) }/> :
                    <p>{observatiiMedic}</p>}

                </Form.Group>
                <Form.Group>
                    <Form.Label><b>Observatiile ingrijitorului</b></Form.Label>
                    {role === "ingrijitor" ? <Form.Control as="textarea" row="3" value={observatiiIngrijitor} onChange={data => this.setState({observatiiIngrijitor: data.target.value})}/> :
                    <p>{observatiiIngrijitor}</p>}
                </Form.Group>
                <Form className="bifa">
                    <div key={`default-checkbox`} className="mb-3">
                        <Form.Check type="checkbox" id={`default-checkbox`} label="Rezolvat?" onChange={() => bifat = !bifat}/>
                    </div>
                </Form>
                <Form.Control className={"ora"} size="sm" type="text" placeholder="Ora rezolvarii" onChange={data => this.setState({oraRezolvare: data.target.value})}/>
                <br/>
                <Button variant="primary" type="submit" onClick={() => { modificaTratamentul(); window.location.replace("/pacienti/" + pacient + "/tratamente")}}>
                    Salveaza
                </Button>
            </div>
        )
    }
}
