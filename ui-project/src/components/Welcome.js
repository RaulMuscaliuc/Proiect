import React from 'react';
import logo from '../images/logo2.png'
import './Welcome.css'

import {InputGroup} from 'react-bootstrap';

export default class Welcome extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div className={"welcome"}>
                <InputGroup className="justify-content-md-center" >
                    <h1>iCare</h1>
                    <img className={"homeImg"} src={logo}/>
                </InputGroup>
                <br/>
                <p className={"descriere"}><b>Compania S.C. iCare S.R.L a fost înființată la Timișoara, în data de 5 Martie 2020 ca societate cu răspundere limitată, de către o echipă formată din studenți sub îndrumarea cadrelor didactice ai Universității Politehnica din Timișoara. Domeniul de activitate al companiei îl reprezintă realizarea de aplicații de tip Ambient Assisted Living (AAL) pentru diverse spitale, cabinete medicale, respectiv pacienți care necesită supraveghere în timp real. Societatea noastră a achiziționat aparatura necesară desfășurării activității în urma obținerii unei finanțări din fonduri alocate de către Facultatea de Automatică și Calculatoare.
                    Proiectul conceput va consta în supravegherea și îngrijirea pacienților la distanță și va ușura munca personanului medical, dar și a pacientului care, din căldura propriului cămin, poate să urmărească datele despre starea sa de sănătate. Scopul nostru este să oferim produse și servicii de calitate, care să adauge un plus de confort în viața clienților noștri, în timp ce bunăstarea și integritatea persoanelor este pus pe primul loc.</b></p>
            </div>
        )
    }
}
