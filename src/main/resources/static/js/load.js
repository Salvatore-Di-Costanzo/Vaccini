$(document).ready(function () {

$("#formData").on("submit",function(e) {

    $.ajax({
        type: "GET",
        url: "regioniContagi",
        data: {dataF: $("#dataF").val()},

        success: function(result) {
            $("#id-22").html(result);
        },
        error: function(result) {
            alert('error');
        }

    });
});
});