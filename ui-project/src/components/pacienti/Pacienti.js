import React from "react";
import './Pacienti.css'
import Pacient from "./Pacient";

export default class Pacienti extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            pacienti: [],
            pacient: false
        }
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('pacienti')
            .then(response => response.json())
            .then(data => this.setState({pacienti: data, seIncarca: false}));
    }

    renderPacientInfo(pacientId) {
        const {pacienti} = this.state;
        const pacient = pacienti[pacientId - 1]
        console.log(pacient.adresa);
    }

    render() {
        const {pacienti, seIncarca, pacient} = this.state;
        if (seIncarca) {
            return <p>Se incarca...</p>
        }
        var pacientView;
        if(pacient) {
             pacientView = (
                <Pacient/>
            )
        }
        const listaPacienti = pacienti.map(pacient => {
            const numePacient = pacient.nume + ' ' + pacient.prenume;
            const id = pacient.id;
            return <li onClick={() => pacient = true}><i>{numePacient}</i></li>

        });
        return (
            <div>
                <div>
                    <ol>{listaPacienti}</ol>
                </div>
                <div align='center'>
                    {pacientView}
                </div>
            </div>
        )
    }
}
