$(document).ready(function () {
    setImageOne();
});
function setImageOne() {
    var imageUrl = "assets/images/slideshow/valentines.jpg";
    $('#slides').fadeIn(700).css('background-image', 'url(' + imageUrl + ')').delay(10000).fadeOut(700, function () { setImageTwo(); });
}
function setImageTwo() {
    var imageUrl = "assets/images/slideshow/halloween.jpg";
    $('#slides').fadeIn(700).css('background-image', 'url(' + imageUrl + ')').delay(10000).fadeOut(700, function () { setImageThree(); });
}
function setImageThree() {
    var imageUrl = "assets/images/slideshow/christmas.jpg";
    $('#slides').fadeIn(700).css('background-image', 'url(' + imageUrl + ')').delay(10000).fadeOut(700, function () { setImageOne(); });
}

var hashTagActive = "";
$(".scroll").click(function (event) {
    if(hashTagActive != this.hash) {
        event.preventDefault();
        var dest = 0;
        if ($(this.hash).offset().top > $(document).height() - $(window).height()) {
            dest = $(document).height() - $(window).height();
        } else {
            dest = $(this.hash).offset().top;
        }
        $('html,body').animate({
            scrollTop: dest
        }, 2000, 'swing');
        hashTagActive = this.hash;
    }
});