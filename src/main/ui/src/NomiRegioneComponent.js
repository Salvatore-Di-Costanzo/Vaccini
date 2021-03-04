import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Bar} from "react-chartjs-2";



const CaricaDati = () => {
        const [chartData, setChartData] = useState([]);

        const chart = () =>{
            let nomiRegioni = [];
            let contagiRegioni = [];
            let backgroundColor = [];
            let color;
            axios.get('http://localhost:8080/regioniContagi')
                .then(res =>{
                    for(const dataObj of res.data){
                        nomiRegioni.push(dataObj.nomeRegione)
                        contagiRegioni.push(dataObj.numeroContagi)
                    }
                    for (var i = 0; i < contagiRegioni.length; i++) {

                        if(contagiRegioni[i] > 1500)
                            color = 'rgb(255,8,8)';
                        else if (contagiRegioni[i] >= 800)
                            color = 'rgb(255,71,0)';
                        else
                            color = 'rgb(224,195,22)';
                        backgroundColor.push(color);
                    }
                    setChartData({
                        labels: nomiRegioni,

                        datasets: [
                            {
                                label: 'Numero Contagi',
                                backgroundColor: backgroundColor, //Barre
                                //borderColor: 'rgb(46,88,46)', // Contorno Barre
                                //borderWidth: 1, // Spessore contorno
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
            <div style={{ position: "relative", margin: "auto", width: "80vw" }}>
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