$(document).ready(function () {

    $(".reg_toggle_log").click(function () {
        $("#register").fadeToggle();
        $("#login").fadeToggle();
        // reset forms
        $("[name='loginform']").trigger('reset');
        $("[name='regform']").trigger('reset');
        $(".message").text("");
    });

    $("[name='regform']").submit(function () {
        if ($("#password_signup").val() != $("#password_signup_confirm").val()) {
            $(".upass").text("Пароли не совпадают");
            return false;
        }
    });

});