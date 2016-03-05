function AJAX() {
    "use strict";
    $.ajax({url: "localhost:9998/api/decoration/all", success: function(result){
        //https://raw.githubusercontent.com/GETHIP-Classroom/get-hip-project-2016-christmas-tree-rental/master/UI/assets/data/products.json
        sortEl(result);
    }});
}

function new_years(items) {
    function addItems(els) {
        document.getElementsByClassName("nyinsert")[0].appendChild(els[0]);
        document.getElementsByClassName("nyinsert")[0].appendChild(els[1]);
        document.getElementsByClassName("nyinsert")[0].appendChild(els[2]);
    }
    var k, node, elements;
    node = document.createElement("tr");
    elements = [];
    for (k = 0; k <= items.length - 1; k++) {
        console.log("K is " + k);
        if (k >= 3) {
            console.log("Hello World!");
            addItems(elements);
            elements = [];
        }
        var itemName = document.createElement("p");
        var itemPrice = document.createElement("p");
        itemPrice.setAttribute("class", "itemPrice")
        itemName.setAttribute("class", "itemName");
        itemPrice.innerHTML = "Item Price: " + items[k][2];
        itemName.innerHTML = "Item Name: " + items[k][0];
        var node0 = document.createElement("td");
        node0.appendChild(itemName);
        node0.appendChild(itemPrice);
        node0.setAttribute("class", "item");
        elements.push(node0);
    }
    addItems(elements);
}
function valentines(items) {
    function addItems(els) {
        document.getElementsByClassName("vdinsert")[0].appendChild(els[0]);
        document.getElementsByClassName("vdinsert")[0].appendChild(els[1]);
        document.getElementsByClassName("vdinsert")[0].appendChild(els[2]);
    }
    var k, node, elements;
    node = document.createElement("tr");
    elements = [];
    for (k = 0; k <= items.length - 1; k++) {
        console.log("K is " + k);
        if (k >= 3) {
            console.log("Hello World!");
            addItems(elements);
            elements = [];
        }
        var itemName = document.createElement("p");
        var itemPrice = document.createElement("p");
        itemPrice.setAttribute("class", "itemPrice")
        itemName.setAttribute("class", "itemName");
        itemPrice.innerHTML = "Item Price: " + items[k][2];
        itemName.innerHTML = "Item Name: " + items[k][0];
        var node0 = document.createElement("td");
        node0.appendChild(itemName);
        node0.appendChild(itemPrice);
        node0.setAttribute("class", "item");
        elements.push(node0);
    }
    addItems(elements);
}
function halloween(items) {
    function addItems(els) {
        document.getElementsByClassName("hwinsert")[0].appendChild(els[0]);
        document.getElementsByClassName("hwinsert")[0].appendChild(els[1]);
        document.getElementsByClassName("hwinsert")[0].appendChild(els[2]);
    }
    var k, node, elements;
    node = document.createElement("tr");
    elements = [];
    for (k = 0; k <= items.length - 1; k++) {
        console.log("K is " + k);
        if (k >= 3) {
            console.log("Hello World!");
            addItems(elements);
            elements = [];
        }
        var itemName = document.createElement("p");
        var itemPrice = document.createElement("p");
        itemPrice.setAttribute("class", "itemPrice")
        itemName.setAttribute("class", "itemName");
        itemPrice.innerHTML = "Item Price: " + items[k][2];
        itemName.innerHTML = "Item Name: " + items[k][0];
        var node0 = document.createElement("td");
        node0.appendChild(itemName);
        node0.appendChild(itemPrice);
        node0.setAttribute("class", "item");
        elements.push(node0);
    }
    addItems(elements);
}
function christmas(items) {
    function addItems(els) {
        document.getElementsByClassName("chinsert")[0].appendChild(els[0]);
        document.getElementsByClassName("chinsert")[0].appendChild(els[1]);
        document.getElementsByClassName("chinsert")[0].appendChild(els[2]);
    }
    var k, node, elements;
    node = document.createElement("tr");
    elements = [];
    for (k = 0; k <= items.length - 1; k++) {
        console.log("K is " + k);
        if (k >= 3) {
            console.log("Hello World!");
            addItems(elements);
            elements = [];
        }
        var itemName = document.createElement("p");
        var itemPrice = document.createElement("p");
        itemPrice.setAttribute("class", "itemPrice")
        itemName.setAttribute("class", "itemName");
        itemPrice.innerHTML = "Item Price: " + items[k][2];
        itemName.innerHTML = "Item Name: " + items[k][0];
        var node0 = document.createElement("td");
        node0.appendChild(itemName);
        node0.appendChild(itemPrice);
        node0.setAttribute("class", "item");
        elements.push(node0);
    }
    addItems(elements);
}

function sortEl(result) {
    "use strict";
    var json, obj, i, ny, vd, hw, ch, j;
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
            case "Easter":
                break;
            case "Fourth of July":
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
    new_years(ny);
    valentines(vd);
    halloween(hw);
    christmas(ch);
}

window.onload = function () {
    "use strict";
    AJAX();
};
//nyinsert