import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Customer {
	public static void main(String[] args) {
		getConnection();
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
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
			+ "customer(id int NOT NULL, AUTO_INCREMENT, "
			+ "name varChar(255), "
			+ "room_num varChar(255), "
			+ "product varChar(255), "
			+ "deliv_date varChar(255), "
			+ "box_loc varChar(255), "
			+ "PRIMARY KEY(id))");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12264858";
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