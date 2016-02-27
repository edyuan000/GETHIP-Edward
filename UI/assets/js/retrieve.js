function retrieve(method, url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            parse(xhttp.responseText);
        }
    };
    xhttp.open(method,url,true);
    xhttp.send();
}
function parse(data) {
    var json,i;
    json = JSON.parse(data);
    for(i = 0; i <= json.products.length - 1; i++) {
        add(json.products[i].id,json.products[i].name,json.products[i].price,json.products[i].holiday);
    }
}
function add(pid,name,price,holiday) {
    var node0,node1,node2,node3,node4,node5,node6,txt0,txt1,txt2,txt3;
    console.log("Hello World");
    node0 = document.createElement("i");
    txt0 = document.createTextNode(holiday);
    node0.class = "holiday-label";
    node0.appendChild(txt0);                 //<i>Holiday</i>
    node1 = document.createElement("h3");
    node1.appendChild(node0);                   //<h3><i>Holiday</i></h3>
    node2 = document.createElement("h3");
    txt1 = document.createTextNode("$" + parseFloat(Math.round(price * 100) / 100).toFixed(2));
    node2.appendChild(txt1);                   //<h3>Price</h3>
    node3 = document.createElement("h2");
    console.log(name);
    txt2 = document.createTextNode(name);
    node3.appendChild(txt2);                    //<h2>Product Name</h2>
    node6 = document.createElement("button");
    txt3 = document.createTextNode("Add to Cart");
    node6.appendChild(txt3);
    node6.setAttribute('onclick','cart("' + pid + '")');
    node4 = document.createElement("td");
    node4.appendChild(node3);
    node4.appendChild(node2);
    node4.appendChild(node1);
    node4.appendChild(node6);
    node4.className = "item";
    node5 = document.createElement("tr");
    node5.appendChild(node4);
    node5.className = "row";
    node5.id = (pid.toString().toLowerCase().replace(" ","_") + "-" + holiday.toLowerCase().replace(" ", "_") + "-" + name.toLowerCase().replace(" ", "_")); //id="12-fourth_of_july-american_flag"
    document.getElementsByClassName("tbody")[0].appendChild(node5);
}
function cart(l) {
    alert("Product #" + l + " was added to the theoretical cart.")
}
//<tr class="row">
//    <td class="item">
//        <h2>Product Name</h2>
//        <h3>Price</h3>
//        <h3><i>Holiday</i></h3>
//        <button onclick="cart(id)">Add to Cart</button>
//    </td>
//</tr>
