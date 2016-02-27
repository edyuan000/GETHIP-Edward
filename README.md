#Holiday Tree and Decoration Rental

---

##Our Team

We communicate through the GroupMe app.

- Hannah May: Team Lead

- Eddie Yuan: API Management

- Ed Torres: API Management

- Mary Claire Rodgers: Web Design

- Thomas Gerot: AJAX Management

---

##Our Project

We seek to create an online service that allows customers to rent out holiday decorations instead of wasting their own space storing the decorations for another year.

###API

The API (Application Programming Interface) root directory of this project's repository contains the Java backend/server-side portion of the project. The directory currently contains an Eclipse Maven project serving the API in a JSON (JavaScript Object Notation) for a JavaScript application to reach from the client-side.

---

###DB

The DB (Database) root directory of this project's repository will contain an exported CSV file (`.csv`) and/or Excel Spreadsheet (`.xls`) depicting the structure of our database. Our database will be hosted on James Getrost's own server, and managed through the phpmyadmin platform, and possibly MySQL Workbench in the future. Currently our database is titled `rental` and contains two tables named `decorations` and `cart`.

####Decorations

The decorations table will contain a full index of all the offered decorations including the following columns:

| Column Name | Data Type | Primary Key | Not Null | Binary | Zero Fill | Auto Increment | Default Value |
|:-----------:|:-----------:|:-----------:|:--------:|:------:|:---------:|:--------------:|:-------------:|
| productid | INT | TRUE | TRUE | FALSE | FALSE | TRUE | NONE |
| name | VARCHAR(50) | FLASE | FALSE | FALSE | FALSE | FALSE | NULL |
| price | DOUBLE | FALSE | TRUE | FALSE | FALSE | FALSE | 0.00 |
| holiday | VARCHAR(20) | FALSE | FALSE | FALSE | FALSE | FALSE | NULL |

**productid**: An auto-generated, auto-incrementing, identification number specific to each product (Ex. `142`)

**name**: The name of the specific product (Ex. `Party Cooler`)

**price**: A dollar price value for the product (Ex. `4.25`)

**holiday**: The holiday associated with the decoration (Ex. `Christmas`)

####Cart

The cart table will contain a listing of all items currently in the cart, including the following columns:

| Column Name | Data Type | Primary Key | Not Null | Binary | Zero Fill | Auto Increment | Default Value |
|:-----------:|:---------:|:-----------:|:--------:|:------:|:---------:|:--------------:|:-------------:|
| productid | INT | FALSE | TRUE | FALSE | FALSE | FALSE | NONE |
| cartid | INT | TRUE | TRUE | FALSE | FALSE | TRUE | NONE |
| dateadded | DATE | FALSE | FALSE | FALSE | FALSE | FALSE | NULL |

**productid**: The productid number [found in the decorations table] identifying the product in the cart (Ex. `72`)

**cartid**: The auto-generated, primary integer used to reference items in the cart (Ex. `12`)

**dateadded**: The date [in MySQL format] when the client added the product to their cart (Ex. `2016-02-19`)

---

###UI
The UI (User Interface) root directory of this project's repository will contain the web files (`.html`, `.css`, and `.js`) that will be served to the client's browser for the use of navigation through the web service. In the future, the website will allow users to filter and browse the list of decorations offered, add them to their cart, and purchase them.

---
