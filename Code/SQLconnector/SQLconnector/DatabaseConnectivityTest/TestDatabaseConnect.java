package DatabaseConnectivityTest;
import java.sql.*;
public class TestDatabaseConnect {
	public static void main(String[] args) {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/student_records";
			String username = "root";
			String password = null;
			
			Class.forName(driver).newInstance();
			Connection con = DriverManager.getConnection(
					url, username, password);
			System.out.println("Connected to the database...");
		}
		
		catch (Exception e){
			System.out.println(e);
		}
	}

}
