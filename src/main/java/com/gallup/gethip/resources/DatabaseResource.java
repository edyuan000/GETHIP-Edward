//Package Declaration
package com.gallup.gethip.resources;
//Import SQL and JSON tools from external libraries
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
public class DatabaseResource {
	//Stored database connection data
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public DatabaseResource() {
		try {
			//URL to fetch the database from (waiting for James)
			String dbUri = "https://www.jgetrost.com:3306";
			System.out.println("Action: Connecting to connect to database");
			//Setting up the JDBC driver that allows java to interact with database
			Class.forName("com.mysql.jdbc.Driver");
			//Connects to database using the username and password James gave us
			con = DriverManager.getConnection(dbUri, "rental", "gethip");
			//No idea what this is
			st = con.createStatement();
			System.out.println("Success: Connected to database: " + dbUri);
		} catch (Exception ex) {
			System.err.println("Failed: Database connection error: " + ex);
		}
	}
	//Other files can execute an SQL query by calling this method
	//The method requires an SQL statement (as a string) as a parameter
	public String getData(String sqlQuery) {
		//Creates an empty JSON array
		JSONArray json = new JSONArray();
		try {
			System.out.println("Action: Querying table");
			//Executes SQL statement through database
			rs = st.executeQuery(sqlQuery);
			System.out.println("Success: SQL query was executed.");
			//A lot of grossly formatted SQL raw data
			ResultSetMetaData rsmd = rs.getMetaData();
			//Counts the number of columns in the MySQL table's output
			int numColumns = rsmd.getColumnCount();
			//This goes through every row returned be the database query
			while (rs.next()) {
				//Creates a JSON object (one for each row item). Looks like this:
				// {
				// 	"productid":12,
				// 	"name":"Plastic Tree",
				// 	"price":4.14,
				// 	"holiday":"Christmas"
				// }
				JSONObject obj = new JSONObject();
				//For each column in that row change the data type to something Java can work with
				for (int i = 1; i < numColumns + 1; i++) {
					String column_name = rsmd.getColumnName(i);
					if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
						obj.put(column_name, rs.getArray(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
						obj.put(column_name, rs.getInt(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
						obj.put(column_name, rs.getBoolean(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
						obj.put(column_name, rs.getBlob(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
						obj.put(column_name, rs.getDouble(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
						obj.put(column_name, rs.getFloat(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
						obj.put(column_name, rs.getInt(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
						obj.put(column_name, rs.getNString(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
						obj.put(column_name, rs.getString(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
						obj.put(column_name, rs.getInt(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
						obj.put(column_name, rs.getInt(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
						obj.put(column_name, rs.getDate(column_name));
					}
					else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
						obj.put(column_name, rs.getTimestamp(column_name));
					}
					else {
						obj.put(column_name, rs.getObject(column_name));
					}
				}
				//Adds the JSON object to the overall JSON array which now looks like this:
				// [
				//    {
				//        "productid":1,
				//        "name":"Plastic Tree",
				//        "price":4.01,
				//        "holiday":"Christmas"
				//    },
				//    {
				//        "productid":1,
				//        "name":"Candy Bucket",
				//        "price":0.95,
				//        "holiday":"Halloween"
				//    },
				//    {
				//        etc...
				//    },
				//    {
				//        etc...
				//    }
				// ]
				json.put(obj);
			}
		} catch (Exception ex) {
			System.err.println("Failed: Error formatting database response: " + ex);
		}
		//When it finishes building the array, it it all on a single line so the rest of this method is basic formatting so it looks pretty
		String[] outputJSON = json.toString().replace("},{", " ,").split(" ");
		System.out.println("Success: Parsed and formatted database response");
		String finalOutput = "";
		for (int i = 0; i < outputJSON.length; i++) {
			finalOutput = finalOutput + outputJSON[i];
		}
		//Normally the rest of the JSON would formatted here, but I would need to see server output first
		System.out.println("Action: Formatting JSON output");
		return finalOutput;
	}
}
