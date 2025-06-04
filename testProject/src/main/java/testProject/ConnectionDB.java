package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class ConnectionDB {
	@DataProvider(name="login")
	public static Object[][] testDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded");
		List<Object[]> datalist = new ArrayList<>();
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data","root","root");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from login_data")){
			System.out.println("jdbc is connected");
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				datalist.add(new Object[] {username,password});
			}
		}
		return datalist.toArray(new Object[0][0]);
		
	}

}
