$(document).ready(function () {
    $("#formData").on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "/regioniContagi",
            data: {data: $("#data").val()},

            success: function (result) {
                caricaDati(result);
                document.getElementById('ultimiDati').style.display = "none";
                let dataVisualizzata = document.getElementById('dataVisualizzata');
                let dataInput = document.createTextNode($("#data").val());
                dataVisualizzata.innerHTML = 'Data: ';
                dataVisualizzata.appendChild(dataInput);
            }

        });
    });
});

function caricaDati(data) {
    if (data.length > 21)
        window.location = "waitingPage";
    else {
        chart.addData(data, 21);
        chart.invalidate();
        chart.appear();
    }
}
