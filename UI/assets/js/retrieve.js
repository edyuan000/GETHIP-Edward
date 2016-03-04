function AJAX() {
    "use strict";
    $.ajax({url: "https://raw.githubusercontent.com/GETHIP-Classroom/get-hip-project-2016-christmas-tree-rental/master/UI/assets/data/products.json", success: function(result){
        sortEl(result);
    }});
}

function sortEl(result) {
    "use strict";
    var json, obj, i, ny, vd, hw, ch;
    ny = [];
    vd = [];
    hw = [];
    ch = [];
    json = result,
    obj = JSON.parse(json);
    for (i = 0; i < obj.products.length; i++) {
        switch (obj.products[i].holiday) {
            case "New Years":
                ny.push([obj.products[i].name, obj.products[i].id, obj.products[i].price]);
                break;
            case "Valentines Day":
                vd.push([obj.products[i].name, obj.products[i].id, obj.products[i].price]);
                break;
            case "Halloween":
                hw.push([obj.products[i].name, obj.products[i].id, obj.products[i].price]);
                break;
            case "Christmas":
                ch.push([obj.products[i].name, obj.products[i].id, obj.products[i].price]);
                break;
            default:
                console.error("Error: No holiday.");
                break;
        }
    }
    console.log(obj.products[1].name);
}

window.onload = function () {
    "use strict";
    AJAX();
};
//nyinsert