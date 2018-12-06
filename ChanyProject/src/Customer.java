import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer {
	public static void main(String[] args) {
		createTable();
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
	public static String selectCustomers(String name) {
        String sql = "select * from customer where name = ?;";
        PreparedStatement pstmt = null;
        String list = null;
        Connection conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
 
            if (rs.next()) {
            	list=("학생 이름 : "+ rs.getString("name") +
						" 호실: "+ rs.getString("room_num") +
						" 택배 물품: "+ rs.getString("product") +
						" 보관 날짜: "+ rs.getString("deliv_date") +
						" 보관 장소: "+ rs.getString("box_loc"));
            	System.out.println("The data has been fetched");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
	public static void deleteCustomer(String name) {
        String sql = "delete from customer where name = ?;";
        PreparedStatement pstmt = null;
        Connection conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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