import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Bar, Line} from "react-chartjs-2";



const CaricaDati = () => {
        const [chartData, setChartData] = useState([]);
        const [nomeRegioni, setNomiRegioni] = useState([]);
        const [contagi, setContagi] = useState([]);

        const chart = () =>{
            let nomiRegioni = [];
            let contagiRegioni = [];
            axios.get('http://localhost:8080/regioniContagi')
                .then(res =>{
                    for(const dataObj of res.data){
                        nomiRegioni.push(dataObj.nomeRegione)
                        contagiRegioni.push(dataObj.numeroContagi)
                    }
                    setChartData({
                        labels: nomiRegioni,

                        datasets: [
                            {
                                label: 'Numero Contagi',
                                backgroundColor: 'rgb(255,219,8)', //Barre
                                borderColor: 'rgb(46,88,46)', // Contorno Barre
                                borderWidth: 1, // Spessore contorno
                                data: contagiRegioni
                            }
                        ]

                    })
                })
                .catch(err => {
                    console.log("BOOOOOO")
                })


        }

        useEffect(() => {
            chart();
        }, []);
    return (
        <div className="App">
            <h1>Contagi</h1>
            <div>
                <Bar
                    data={chartData}
                    options={{
                        responsive: true,
                        title: { text: "Contagi", display: true },
                        scales: {
                            yAxes: [
                                {
                                    ticks: {
                                        autoSkip: true,
                                        maxTicksLimit: 10,
                                        beginAtZero: true
                                    },
                                    gridLines: {
                                        display: false
                                    }
                                }
                            ],
                            xAxes: [
                                {
                                    gridLines: {
                                        display: false
                                    }
                                }
                            ]
                        }
                    }}
                />
            </div>
        </div>
    );
};


export default CaricaDati;