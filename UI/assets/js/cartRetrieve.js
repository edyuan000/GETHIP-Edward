function AJAX() {
    "use strict";
    $.ajax({url: "localhost:9998/api/cart/all", success: function(result){
        sortEl(result);
    }});
}
