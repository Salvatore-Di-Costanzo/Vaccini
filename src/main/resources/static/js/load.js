$("#inviaData").on("click",function(e) {
    e.preventDefault();
    $.ajax({
        type: "GET",
        data: $(this).val(),
        url: "/regioniContagi?data="+data,


        success: function(result) {
            alert('ok');
        },
        error: function(result) {
            alert('error');
        }
    });
});