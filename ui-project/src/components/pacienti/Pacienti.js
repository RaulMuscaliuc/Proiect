import React from "react";
import './Pacienti.css'

export default class Pacienti extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            pacienti: []
        }
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('pacienti')
            .then(response => response.json())
            .then(data => this.setState({pacienti: data, seIncarca: false}));
    }

    render() {
        const {pacienti, seIncarca} = this.state;
        if (seIncarca) {
            return <p>Se incarca...</p>
        }

        const listaPacienti = pacienti.map(pacient => {
            const numePacient = pacient.nume + ' ' + pacient.prenume;
            const id = pacient.id;
            return <li><i><a href={'/pacienti/' + id} id={id}>{numePacient}</a></i></li>

        });
        return (
            <div align='center'>
                <div>
                    <h1>Lista pacientilor</h1>
                </div>
                <div className="listaPacienti" >
                    <ol>{listaPacienti}</ol>
                </div>
            </div>
        )
    }
}
