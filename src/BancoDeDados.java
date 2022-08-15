import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	Connection conn = null;
    Statement stmt = null;
	private ResultSet resultSet = null;
	
	public void conectar() {		
		String servidor = "jdbc:mysql://localhost/ibm";		
		String usuario = "root";		
		String senha = "mysql";		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {			
			Class.forName(driver);
			conn = DriverManager.getConnection(servidor, usuario, senha);			
			stmt = conn.createStatement();
		} catch(Exception e) {
			System.out.println("erro:" + e.getMessage());
		}
	}	
	
		public boolean estaConectado() {
			if(this.conn != null) {
				return true;
			} else {
				return false;
			}
		}		
		
};