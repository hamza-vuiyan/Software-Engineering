
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	private String dburl = "jdbc:mysql://urowmyrks8sa1rih:RsKRqsn19uGmkebas6WR@b3p5m8nhncgiqy1daeus-mysql.services.clever-cloud.com:3306/b3p5m8nhncgiqy1daeus";
	private String dbname = "b3p5m8nhncgiqy1daeus";
	private String dbpassword = "RsKRqsn19uGmkebas6WR";
	private String dbdriver = "com.mysql.cj.jdbc.Driver";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbname, dbpassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void loadDriver(String dbdriver) {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String insert(Member member) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "insert into member values(?,?,?,?)";
		String result="Data Entered Successfully";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			result="Data Not Entered Successfully";
			e.printStackTrace();
		}
		return result;
	}
}
