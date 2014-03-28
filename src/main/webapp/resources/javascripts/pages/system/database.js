$(function() {
    var loggedIn = false;
    $('iframe').load(function() {
        if (!loggedIn) {
            $('iframe').contents().find('input[name="driver"]').val(DATABASE_DRIVER);
            $('iframe').contents().find('input[name="url"]').val(DATABASE_URL);
            $('iframe').contents().find('input[name="user"]').val(DATABASE_USERNAME);
            $('iframe').contents().find('input[name="password"]').val(DATABASE_PASSWORD);
            $('iframe').contents().find('form').submit();
            loggedIn = true;
        } else {
            // Show iframe after login
            $('iframe').fadeIn("fast");
        }
    });
}); 