$(function() {
    $('a.open-in-new-tab').on('click', function() {
        $(this).parents('.dropdown.open').find('[data-toggle=dropdown]').dropdown('toggle');
        var tab = window.open($(this).attr('href'), $(this).attr('href'));
        tab.focus();
        return false;
    });
});