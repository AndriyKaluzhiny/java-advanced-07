
$('button.register').click(function () {
    let user = {
        name: $('input.name').val(),
        lastName: $('input.lastName').val(),
        email: $('input.email').val(),
        password: $('input.password').val()
    };

    if (user.name == '' || user.lastName == '' || user.email == '' || user.password == '') {
        alert("Please fill the fields!");
    }

    if (user.password < 8) {
        alert("password must be more than 8 symbols");
    }

    $.post("registration",
        user, function (data) {
            if (data == "Success") {
                $('form')[0].reset();
                alert(data);
            }
        }
    );
});

$("button.login").click(function () {
    var email = $("form.login-form input.emailLg").val();
    var password = $("form.login-form input.passwordLg").val();

    if (email == '' || password == '') {
        alert("Please fill login form!");
    } else {
        var userLogin = {
            email: email,
            password: password
        };

        $.post("login", userLogin, function (data) {
            if (data !== '') {
                var customUrl = '';
                var urlContent = window.location.href.split('/');
                for (var i = 0; i < urlContent.length - 1; i++) {
                    customUrl += urlContent[i] + '/'
                }

                customUrl += data.destinationUrl;
                window.location = customUrl;
            }
            $("form")[1].reset();
        });
    }
});

