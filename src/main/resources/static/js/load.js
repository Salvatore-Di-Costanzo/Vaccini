$(document).ready(function () {

$("#formData").on("submit",function(e) {
    e.preventDefault();
    $.ajax({
        type: "GET",
        url: "/regioniContagi",
        data: {data: $("#data").val()

        },

        success: function(result) {
            $('#chartdiv').load(result);
            console.log(result)
        },
        error: function(result) {
            alert('error');
        }

    });
});
});

//$('#inviaData').on("click",caricaChartDiv());