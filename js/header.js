$('.menu-toggle').click(function(e){
    e.preventDefault();
    $('.menu-right').toggleClass('is-open');
})

$('.dropdown-menu-head').click(function(e){
    e.preventDefault();
    $('.dropdown-menu').toggleClass('on-click');
})