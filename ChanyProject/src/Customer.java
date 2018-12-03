import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	public static void main(String[] args) {
		createTable();
		deleteCustomer("ÀüÈ«Âù");
		}
	
	public static String [] [] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, room_num, product, deliv_date, box_loc FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("room_num"),
						results.getString("product"),
						results.getString("deliv_date"),
						results.getString("box_loc")
						});
			}
			System.out.println("The data has been fetched");
			String [] [] arr = new String[list.size()] [5];
			return list.toArray(arr);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static void deleteCustomer(String name) {
		try {
			Connection con = getConnection();
			PreparedStatement delete = con.prepareStatement(""
					+ "DELETE * FROM customer where name = '"+name+"'");
			delete.executeUpdate();
			System.out.println("The data has been deleted");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createCustomer(String name, String room_num, String product, String deliv_date, String box_loc) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, room_num, product, deliv_date, box_loc) "
					+ "VALUE "
					+"('"+name+"','"+room_num+"','"+product+"','"+deliv_date+"','"+box_loc+"')");
			insert.executeUpdate();
			System.out.println("The data has been saved");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "room_num varChar(255),"
					+ "product varChar(255),"
					+ "deliv_date varChar(255),"
					+ "box_loc varChar(255),"
					+ "PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table successfully created");
		}
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12264858?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
			String user = "sql12264858";
			String pass = "EvhqW1ACr7";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}