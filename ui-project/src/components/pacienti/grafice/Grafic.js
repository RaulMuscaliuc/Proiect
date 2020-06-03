import React from 'react';
import axios from "axios";
import CanvasJSReact from '../../../assets/canvasjs.react'
import './Grafic.css'
let CanvasJS = CanvasJSReact.CanvasJS;
let CanvasJSChart = CanvasJSReact.CanvasJSChart;
export default class Grafic extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seIncarca: true,
            dateFiziologice: []
        }
    }

    componentDidMount() {
        this.setState({seIncarca: true});

        axios.get("http://localhost:8080/api/ambientale/" + this.props.match.params.id)
            .then(response => {
                console.log(response.data)
                this.setState({
                    seIncarca: false,
                    dateFiziologice: response.data
                })
            });
    }

    render() {
        const {seIncarca, dateFiziologice} = this.state;
        if(seIncarca){
            return <p align='center'>Se incarca...</p>
        }
        const tensiune = [];
        const puls = [];
        const temperatura = [];
        const greutate = [];
        const glicemie = [];

        dateFiziologice.map(date => {
            tensiune.push({x: new Date(2020, 4, date.id) , y: date.tensiune});
            puls.push({x: new Date(2020, 4, date.id) , y: date.puls});
            temperatura.push({x: new Date(2020, 4, date.id) , y: date.temperatura});
            greutate.push({x: new Date(2020, 4, date.id) , y: date.greutate});
            glicemie.push({x: new Date(2020, 4, date.id) , y: date.glicemie});
        });

        const optionsTensiune = {
            animationEnabled: true,
            title:{
                text: "Istoric tensiune"
            },
            axisX: {
                valueFormatString: "MM/DD"
            },
            axisY: {
                title: "Tensiune",
                includeZero: false
            },
            data: [{
                yValueFormatString: "###",
                xValueFormatString: "MMMM",
                type: "spline",
                dataPoints: tensiune
            }]
        };

        const optionsPuls = {
            animationEnabled: true,
            title:{
                text: "Istoric puls"
            },
            axisX: {
                valueFormatString: "MM/DD"
            },
            axisY: {
                title: "Puls",
                includeZero: false
            },
            data: [{
                yValueFormatString: "###",
                xValueFormatString: "MMMM",
                type: "spline",
                dataPoints: puls
            }]
        };

        const optionsTemperatura = {
            animationEnabled: true,
            title:{
                text: "Istoric temperatura"
            },
            axisX: {
                valueFormatString: "MM/DD"
            },
            axisY: {
                title: "Temperatura",
                includeZero: false
            },
            data: [{
                yValueFormatString: "###",
                xValueFormatString: "MMMM",
                type: "spline",
                dataPoints: temperatura
            }]
        };

        const optionsGreutate = {
            animationEnabled: true,
            title:{
                text: "Istoric greutate"
            },
            axisX: {
                valueFormatString: "MM/DD"
            },
            axisY: {
                title: "Greutate",
                includeZero: false
            },
            data: [{
                yValueFormatString: "###",
                xValueFormatString: "MMMM",
                type: "spline",
                dataPoints: greutate
            }]
        };

        const optionsGlicemie = {
            animationEnabled: true,
            title:{
                text: "Istoric glicemie"
            },
            axisX: {
                valueFormatString: "MM/DD"
            },
            axisY: {
                title: "Glicemie",
                includeZero: false
            },
            data: [{
                yValueFormatString: "###",
                xValueFormatString: "MMMM",
                type: "spline",
                dataPoints: glicemie
            }]
        };

        return (
            <div>
                <CanvasJSChart options = {optionsTensiune}/>
                <br/>
                <CanvasJSChart options = {optionsPuls}/>
                <br/>
                <CanvasJSChart options = {optionsTemperatura}/>
                <br/>
                <CanvasJSChart options = {optionsGreutate}/>
                <br/>
                <CanvasJSChart className={"ultimGraf"} options = {optionsGlicemie}/>
                <br/>
                <br/>
            </div>
        );
    }
}
