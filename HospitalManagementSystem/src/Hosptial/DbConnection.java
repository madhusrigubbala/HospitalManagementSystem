package Hosptial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
    private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/HospitalManagementSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    @SuppressWarnings("static-access")
	public DbConnection() {
        try {
            Class.forName(DRIVER_PATH);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("static-access")
	public Connection getConnection() {
        return this.connection;
    }

    public static PreparedStatement prepareStatement(String query) throws SQLException {
        try {
			return connection.prepareStatement(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
