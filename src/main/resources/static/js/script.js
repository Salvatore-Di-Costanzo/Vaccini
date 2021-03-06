let chart;

fetch('/regioniContagi', {
    method: "post",
    headers : {data:""}
})
    .then(response => response.json())
    .then(data => {
        console.log(data)
            am4core.ready(function () {

// Themes begin
                am4core.useTheme(am4themes_dark);
                am4core.useTheme(am4themes_animated);
// Themes end

// Create chart instance
                chart = am4core.create("chartdiv", am4charts.XYChart);
                //chart.scrollbarX = new am4core.Scrollbar();

// Add data
                if(data.length > 21 )
                    data.pop()
                chart.data = data;

// Create axes
                let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
                categoryAxis.dataFields.category = "denominazione_regione";
                categoryAxis.renderer.grid.template.location = 0;
                categoryAxis.renderer.minGridDistance = 30;
                categoryAxis.renderer.labels.template.horizontalCenter = "right";
                categoryAxis.renderer.labels.template.verticalCenter = "middle";
                categoryAxis.renderer.labels.template.rotation = -45;
                categoryAxis.tooltip.disabled = true;
                categoryAxis.renderer.minHeight = 110;

                let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
                valueAxis.renderer.minWidth = 50;

// Create series
                let series = chart.series.push(new am4charts.ColumnSeries());
                series.sequencedInterpolation = true;
                series.dataFields.valueY = "nuovi_positivi";
                series.dataFields.categoryX = "denominazione_regione";
                series.tooltipText = "[{categoryX}: bold]{valueY}[/]";
                series.columns.template.strokeWidth = 0;

                series.tooltip.pointerOrientation = "vertical";

                series.columns.template.column.cornerRadiusTopLeft = 10;
                series.columns.template.column.cornerRadiusTopRight = 10;
                series.columns.template.column.fillOpacity = 0.8;

// on hover, make corner radiuses bigger
                let hoverState = series.columns.template.column.states.create("hover");
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







