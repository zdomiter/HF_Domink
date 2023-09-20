package feladat05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private Connection con;
	public Database() {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/szinhaz_eloadasok_db","root","Deved1997");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}
	
	public ResultSet query(String sql) {
		ResultSet rs = null;
		Statement stm = null;
		
		try {
			stm = con.createStatement();
			rs= stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
