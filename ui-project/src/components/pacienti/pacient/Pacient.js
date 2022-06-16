import React from "react";
import axios from "axios";
import './Pacient.css'
import {Col, Row} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export default class Pacient extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            nume: "",
            prenume: "",
            varsta: "",
            cnp: "",
            adresa: "",
            diagnostice: [],
            tratamente: [],
            alergii: [],
            recomandari: [],
            dateFiziologice: [],
            dateAmbientale: []
        }
    }

    componentDidMount() {
        this.setState({seIncarca: true});

        axios.get('http://localhost:8080/pacienti/' + this.props.match.params.id)
            .then(response => {
                console.log(response.data);
                this.setState({
                    seIncarca: false,
                    nume: response.data.nume,
                    prenume: response.data.prenume,
                    varsta: response.data.varsta,
                    cnp: response.data.cnp,
                    adresa: response.data.adresa,
                    diagnostice: response.data.diagnostice,
                    tratamente: response.data.tratamente,
                    alergii: response.data.alergii,
                    recomandari: response.data.recomandari,
                    dateFiziologice: response.data.dateFiziologice,
                })
            });
    }

    render() {
        const id = this.props.match.params.id;
        let role = "";
        if (localStorage.length === 1) {
            role = JSON.parse(localStorage.getItem("user")).role;
        }
        const {seIncarca, nume, prenume, varsta, cnp, adresa, diagnostice, tratamente, alergii, recomandari, dateFiziologice, dateAmbientale} = this.state;


        if (seIncarca) {
            return <p align='center'>Se incarca...</p>
        }

        const listaDiagnostice = diagnostice.map(diagnostic => {
            const nume = diagnostic.nume;
            return <li><p>{nume}</p></li>
        });

        const listaAlergii = alergii.map(alergie => {
            const nume = alergie.nume;
            return <li><p>{nume}</p></li>
        });

        return (
            <div>
                <div className='date-personale'>
                    <Row>
                        <Col>
                            <h1> Date personale</h1>
                            <table>
                                <tr>
                                    <td><b>Nume: </b><i>{nume}</i></td>
                                </tr>
                                <tr>
                                    <td><b>Prenume: </b><i>{prenume}</i></td>
                                </tr>
                                <tr>
                                    <td><b>Varsta: </b><i>{varsta}</i></td>
                                </tr>
                                <tr>
                                    <td><b>CNP: </b><i>{cnp}</i></td>
                                </tr>
                                <tr>
                                    <td><b>Adresa: </b><i>{adresa}</i></td>
                                </tr>
                                {role === "medic" || role === "ingrijitor" ? <tr>
                                    <Button onClick={() => this.props.history.push(id + "/editare")}>Editeaza date</Button>
                                </tr> : ""}
                            </table>
                        </Col>
                        <Col>
                            <h1>Date fiziologice</h1>
                            <table>
                                <tr>
                                    <ul>
                                        <li><b>Tensiune: </b> {dateFiziologice[dateFiziologice.length - 1].tensiune}
                                        </li>
                                        <li><b>Puls: </b>{dateFiziologice[dateFiziologice.length - 1].puls}</li>
                                        <li>
                                            <b>Temperatura: </b>{dateFiziologice[dateFiziologice.length - 1].temperatura}
                                        </li>
                                        <li><b>Umiditate: </b>{dateFiziologice[dateFiziologice.length - 1].greutate}%</li>
                                    </ul>
                                </tr>
                                <tr>
                                    <Button onClick={() => this.props.history.push(id + "/grafice")}>Vezi grafic
                                        istoric</Button>
                                </tr>
                            </table>
                        </Col>
                        <Col>
                            <h1>Tratamente</h1>
                            <table>
                                <tr>
                                    <Button onClick={() => this.props.history.push(id + "/tratamente")}>Vezi tratamente
                                        pacient</Button>
                                </tr>
                                <br/>
                                {role === "medic" ? <tr>
                                    <Button onClick={() => this.props.history.push(id + "/tratament")}>Tratament
                                        nou</Button>
                                </tr> : ""}
                            </table>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <h1>Diagnostice</h1>
                            <table>
                                <tr>
                                    <ul>{listaDiagnostice}</ul>
                                </tr>
                                {role === "medic" || role === "ingrijitor" ? <tr>
                                    <Button onClick={() => this.props.history.push(id + "/diagnostic")}>Editeaza diagnostice</Button>
                                </tr> : ""}
                            </table>
                        </Col>
                        <Col>

                        </Col>
                        <Col>
                            <h1>Recomandari</h1>
                            <table>
                                <tr>
                                    <Button onClick={() => this.props.history.push(id + "/recomandari")}>Vezi
                                        recomandari pacient</Button>
                                </tr>
                                <br/>
                                {role === "medic" ? <tr>
                                    <Button onClick={() => this.props.history.push(id + "/recomandare")}>Recomandare
                                        noua</Button>
                                </tr> : ""}

                            </table>
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}
