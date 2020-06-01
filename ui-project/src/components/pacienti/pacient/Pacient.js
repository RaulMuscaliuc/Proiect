import React from "react";
import axios from "axios";
import './Pacient.css'
import {Col, Row} from "react-bootstrap";

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

        axios.get('http://localhost:8080/api/pacienti/' + this.props.match.params.id)
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
                    dateAmbientale: response.data.dateAmbientale
                })
            });
    }

    render() {
        const {seIncarca, nume, prenume, varsta, cnp, adresa, diagnostice, tratamente, alergii, recomandari,dateFiziologice, dateAmbientale } = this.state;
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
                            </table>
                        </Col>
                        <Col>
                            <h1>Diagnostice</h1>
                            <table>
                                <tr>
                                    <ul>{listaDiagnostice}</ul>
                                </tr>
                            </table>
                        </Col>
                        <Col>
                            <h1>Alergii</h1>
                            <table>
                                <tr>
                                    <ul>{listaAlergii}</ul>
                                </tr>
                            </table>
                        </Col>
                        <Col>
                            <h1>Date fiziologice</h1>
                            <table>
                                <tr>
                                    <ul>
                                        <li><b>Tensiune: </b> {dateFiziologice[dateFiziologice.length - 1].tensiune}</li>
                                        <li><b>Puls: </b>{dateFiziologice[dateFiziologice.length - 1].puls}</li>
                                        <li><b>Temperatura: </b>{dateFiziologice[dateFiziologice.length - 1].temperatura}</li>
                                        <li><b>Greutate: </b>{dateFiziologice[dateFiziologice.length - 1].greutate}</li>
                                        <li><b>Glicemie: </b>{dateFiziologice[dateFiziologice.length - 1].glicemie}</li>
                                    </ul>
                                </tr>
                                <tr>
                                    <button>Vezi grafic istoric</button>
                                </tr>
                            </table>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <h1>Date ambientale</h1>
                            <table>
                                <tr>
                                    <td><b>Diagnostice: </b></td>
                                </tr>
                            </table>
                        </Col>
                        <Col>
                            <h1>Tratamente</h1>
                            <table>
                                <tr>
                                    <td><b>Diagnostice: </b></td>
                                </tr>
                            </table>
                        </Col>
                        <Col>
                            <h1>Recomadari</h1>
                            <table>
                                <tr>
                                    <td><b>Diagnostice: </b></td>
                                </tr>
                            </table>
                        </Col>
                    </Row>
                </div>
            </div>
        )
    }
}
