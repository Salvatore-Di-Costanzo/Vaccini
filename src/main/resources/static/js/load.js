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
            chart.addData(data, 21);
            chart.invalidate();
            chart.appear();
        });
}