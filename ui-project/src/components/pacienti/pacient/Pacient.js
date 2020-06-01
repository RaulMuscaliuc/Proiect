import React from "react";
import axios from "axios";
import './Pacient.css'

export default class Pacient extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            nume:"",
            prenume:"",
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
                this.setState({
                    seIncarca: false,
                    nume: response.data.nume,
                    prenume: response.data.prenume,
                    varsta: response.data.varsta,
                    cnp: response.data.cnp,
                    adresa: response.data.adresa
                })
            });
        console.log(this.state)
    }

    render() {
        const {seIncarca, nume, prenume, varsta, cnp, adresa} = this.state;

        if (seIncarca) {
            return <p align='center'>Se incarca...</p>
        }

        return (
            <div>
                <div className='date-personale'>
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
                </div>
            </div>
        )
    }
}
