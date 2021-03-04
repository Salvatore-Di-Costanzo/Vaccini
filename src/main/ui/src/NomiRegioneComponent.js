import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Bar, Line} from "react-chartjs-2";



const CaricaDati = () => {
        const [chartData, setChartData] = useState([]);
        const [nomeRegioni, setNomiRegioni] = useState([]);
        const [contagi, setContagi] = useState([]);
        var setColorPlugin = {

            // We affect the `beforeUpdate` event
            beforeUpdate: function(chart) {
                var backgroundColor = [];
                var borderColor = [];

                // For every data we have ...
                for (var i = 0; i < chart.config.data.datasets[0].data.length; i++) {

                    // We generate a random color
                    if(chart.config.data.datasets[0].get().data)
                    var color = "rgba(" + Math.floor(Math.random() * 255) + "," + Math.floor(Math.random() * 255) + "," + Math.floor(Math.random() * 255) + ",";

                    // We push this new color to both background and border color arrays
                    // .. a lighter color is used for the background
                    backgroundColor.push(color + "0.2)");
                    borderColor.push(color + "1)");
                }

                // We update the chart bars color properties
                chart.config.data.datasets[0].backgroundColor = backgroundColor;
                chart.config.data.datasets[0].borderColor = borderColor;
            }
        };

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

                        // We generate a random color
                        if(contagiRegioni[i] > 1500)
                            color = 'rgb(255,8,8)';
                        else if (contagiRegioni[i] >= 800)
                            color = 'rgb(255,71,0)';
                        else
                            color = 'rgb(224,195,22)';

                        // We push this new color to both background and border color arrays
                        // .. a lighter color is used for the background
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