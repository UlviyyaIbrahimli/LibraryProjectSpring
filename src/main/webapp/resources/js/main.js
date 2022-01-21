$(document).ready(function () {
    $("#signInBtn").click(function () {
        signIn();
    });


    $("#createNewAccountId").dialog({
        title: 'Create New Account',
        height: 600,
        width: 600,
        resizable: false,
        draggable: true,
        autoOpen: false,
        modal: true,
        buttons: {
            'Create': {
                text: 'Create',
                click: function () {
                    createNewAccountReader();
                }
            },
            'Close': {
                text: 'Close',
                click: function () {
                    $(this).dialog('close');
                    window.location.replace('home');
                }
            }

        }
    });

    $("#signDialogId").dialog({
        title: 'Sign In',
        height: 400,
        width: 400,
        resizable: false,
        draggable: true,
        autoOpen: false,
        modal: true,
        buttons: {
            'Sign In': {
                text: 'Sign In',
                click: function () {
                    checkReader();
                }
            },
            'Close': {
                text: 'Close',
                click: function () {
                    $(this).dialog('close');
                    window.location.replace('home');
                }
            }

        }
    });

});

function signIn() {
    $.ajax({
        url: 'signIn',
        type: 'GET',
        dataType: 'html',
        success: function (resonse) {
            $("#signDialogId").html(resonse);
            $("#signDialogId").dialog('open');
        },
        error: function () {
            Swal.fire({
                type: 'error',
                title: 'Error',
                text: 'Something is wrong!',
            });
        }
    });
}

function checkReader() {
    let userName = $("#cUserName").val();
    let password = $("#cPassword").val();
    let data = {
        userName: userName,
        password: password,
    };
    $.ajax({
        url: 'checkReader',
        dataType: 'html',
        type: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        'data': JSON.stringify(data),
        success: function (response) {
            if (response === '') {
                Swal.fire({
                    type: 'warning',
                    title: 'Warning',
                    text: 'Username or password is wrong!',
                });
            } else {
                $("#userRegId").html(response);
                $("#signDialogId").dialog('close');
                alert("hjfvhjfj");
            }
        },
        error: function () {
            Swal.fire({
                type: 'error',
                title: 'Error',
                text: 'Something is wrong!',
            });
        }
    });
}

function createNewAccount() {
    $.ajax({
        url: 'createNewAccount',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $("#createNewAccountId").html(response);
            $("#createNewAccountId").dialog('open');
        },
        error: function () {

        }
    });
}

function createNewAccountReader() {
    let name = $("#name").val();
    let surname = $("#surname").val();
    let username = $("#userName").val();
    let email = $("#email").val();
    let status = $("#status").val();
    let password = $("#password").val();
    let confPassword = $("#confPassword").val();
    if (password === confPassword) {
        let data = {
            name: name,
            surname: surname,
            username: username,
            email: email,
            status: status,
            password: password,
        }
        $.ajax({
            url: 'createNewAccountReader',
            headers: {
                'Content-Type': 'application/json',
            },
            'data': JSON.stringify(data),
            dataType: 'json',
            type: 'POST',
            success: function (response) {
                Swal.fire({
                    type: 'success',
                    title: 'Success',
                    text: 'You have reader our library!',
                });
            }, error: function () {
                Swal.fire({
                    type: 'error',
                    title: 'Error',
                    text: 'Something is wrong!',
                });
            }
        });
    } else {
        Swal.fire({
            type: 'warning',
            title: 'Warning',
            text: 'Password and confirm password does not match!',
        });
    }
}