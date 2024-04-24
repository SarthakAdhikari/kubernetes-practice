$(document).ready(function() {
    $('#password').on('focus', function() {
        $('#bear').removeClass('eyes-open').addClass('eyes-closed');
    }).on('blur', function() {
        $('#bear').removeClass('eyes-closed').addClass('eyes-open');
    });

    function generateRandomUser() {
        var firstNameArray = ["Alice", "Bob", "Carol", "David"];
        var domainArray = ["example.com", "test.com", "demo.com", "sample.com"];
        var firstName = firstNameArray[Math.floor(Math.random() * firstNameArray.length)];
        var email = firstName.toLowerCase() + Math.floor(Math.random() * 100) + "@" + domainArray[Math.floor(Math.random() * domainArray.length)];
        var password = Math.random().toString(36).substring(2, 10);

        return {
            email: email,
            firstName: firstName,
            password: password
        };
    }


    function populateFormWithRandomUser() {
        var user = generateRandomUser();
        $('#email').val(user.email);
        $('#firstName').val(user.firstName);
        $('#password').val(user.password);
    }
    populateFormWithRandomUser();

    function fetchUsers() {
        $.get("/users", function(data) {
            $('#userList').empty();
            $('#userCount').text(`Users (Total=${data.length})`); // Update the displayed count.
            data.forEach(function(user) {
                $('#userList').append(`${user.firstName} (${user.email})<br>`);
            });
        });
    }

    $('#signupForm').submit(function(event) {
        event.preventDefault();
        var user = {
            email: $('#email').val(),
            firstName: $('#firstName').val(),
            password: $('#password').val()
        };
        $.ajax({
            url: "/users/signup",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function(data) {
                fetchUsers();
                populateFormWithRandomUser();
            },
            error: function(xhr) {
                alert("Error registering user: " + xhr.responseText);
            }
        });
    });

    fetchUsers();
});