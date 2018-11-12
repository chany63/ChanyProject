import java.sql.Connection;
import java.sql.DriverManager;

public class Customer {
	public static void main(String[] args) {
		getConnection();
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