import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDeDados {
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar() {
		
		String servidor = "jdbc:mysql://localhost/ibm";	
		String usuario = "root";		
		String senha = "mysql";		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {			
			Class.forName(driver);
			this.connection=DriverManager.getConnection(servidor, usuario, senha);			
			this.statement=this.connection.createStatement();
		} catch(Exception e) {
			System.out.println("erro:" + e.getMessage());
		}
	}
			
		public boolean estaConectado() {
			if(this.connection != null) {
				return true;
			} else {
				return false;
			}
		}
};