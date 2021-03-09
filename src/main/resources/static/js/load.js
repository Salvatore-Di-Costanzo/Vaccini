$(document).ready(function () {
    $("#formData").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "/regioniContagi",
            data: {data: $("#data").val()},

            success: function (result) {
                caricaDati();
                document.getElementById('ultimiDati').style.display = "none";
                let dataVisualizzata = document.getElementById('dataVisualizzata');
                let dataInput = document.createTextNode($("#data").val());
                dataVisualizzata.innerHTML = 'Data: ';
                dataVisualizzata.appendChild(dataInput);

            }

        });
    });
});

function caricaDati() {
    fetch('http://localhost:8080/regioniContagi')
        .then(response => response.json())
        .then(data => {
                am4core.ready(function () {

// Themes begin
                    am4core.useTheme(am4themes_dark);
                    am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
                    var chart = am4core.create("chartdiv", am4charts.XYChart);
                    chart.scrollbarX = new am4core.Scrollbar();

// Add data
                    chart.data = data;

// Create axes
                    var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
                    categoryAxis.dataFields.category = "nomeRegione";
                    categoryAxis.renderer.grid.template.location = 0;
                    categoryAxis.renderer.minGridDistance = 30;
                    categoryAxis.renderer.labels.template.horizontalCenter = "right";
                    categoryAxis.renderer.labels.template.verticalCenter = "middle";
                    categoryAxis.renderer.labels.template.rotation = 270;
                    categoryAxis.tooltip.disabled = true;
                    categoryAxis.renderer.minHeight = 110;

                    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
                    valueAxis.renderer.minWidth = 50;

// Create series
                    var series = chart.series.push(new am4charts.ColumnSeries());
                    series.sequencedInterpolation = true;
                    series.dataFields.valueY = "numeroContagi";
                    series.dataFields.categoryX = "nomeRegione";
                    series.tooltipText = "[{categoryX}: bold]{valueY}[/]";
                    series.columns.template.strokeWidth = 0;

                    series.tooltip.pointerOrientation = "vertical";

                    series.columns.template.column.cornerRadiusTopLeft = 10;
                    series.columns.template.column.cornerRadiusTopRight = 10;
                    series.columns.template.column.fillOpacity = 0.8;

// on hover, make corner radiuses bigger
                    var hoverState = series.columns.template.column.states.create("hover");
                    hoverState.properties.cornerRadiusTopLeft = 0;
                    hoverState.properties.cornerRadiusTopRight = 0;
                    hoverState.properties.fillOpacity = 1;

                    series.columns.template.adapter.add("fill", function (fill, target) {
                        if (target.dataItem && (target.dataItem.valueY > 2000)) {
                            return am4core.color("#ff0000");
                        } else if (target.dataItem && (target.dataItem.valueY > 1000)) {
                            return am4core.color("#ff4800");
                        } else {
                            return am4core.color("#ffd500");
                        }
                    });
// Cursor
                    chart.cursor = new am4charts.XYCursor();

                }); // end am4core.ready()
            }
        );
}