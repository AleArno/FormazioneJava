package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DatabaseConnection {

	private Connection con;
	private static DatabaseConnection instance;

	private DatabaseConnection() {
	}

	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public void start() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/persone", "root", "");
			System.out.println("Db connected");
		} catch (SQLException e) {
			System.err.println("Connection Failed");
			e.printStackTrace();

		}
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void insertDB(Person p) {
		try {
			Statement stmt = con.createStatement();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String sql = "INSERT INTO person (uniqueKey,name,surname,birth,tinsert) VALUES ('" + p.getKey() + "','"
					+ p.getName() + "','" + p.getSurname() + "','" + p.getBirth() + "','" + timestamp + "');";
			stmt.executeUpdate(sql);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
