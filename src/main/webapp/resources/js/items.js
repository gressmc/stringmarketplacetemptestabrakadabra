$(document).ready(function () {
    $("#buy_now").click(function () {
        $("#bid_inc").prop("disabled", $(this).prop("checked"));
    });

    $("#back").click(function () {
        parent.history.back();
    });

    $("[name='itemform']").submit(function () {
        alert("New Item Added");
    });
});