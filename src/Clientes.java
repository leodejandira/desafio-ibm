import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Clientes {
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
		
		// READ
		public void listarClientes() {			
			try {				
				String query = "select * from clientes";
				this.resultSet = this.stmt.executeQuery(query);				
				this.stmt = this.conn.createStatement();	
				
				while(this.resultSet.next()) {
				
				
					String idCliente = resultSet.getString("id_client");
					String nomeCliente = resultSet.getString("nome_cliente");
					String cpfCliente = resultSet.getString("cpf_cliente");
					String telefoneCliente = resultSet.getString("telefone_cliente");					
					String emailCliente = resultSet.getString("email_cliente");				
					System.out.println("ID: " + idCliente);
					System.out.println("Nome completo: " + nomeCliente);
					System.out.println("CPF: " + cpfCliente);
					System.out.println("Telefone: " + telefoneCliente);		
					System.out.println("Email: " + emailCliente);	
					
				}			 
			
			} catch(Exception e) {
				System.out.println("Erro:" + e.getMessage());
			}
		}
		
				
		// CREATE
		public void cadastrarCliente(String nomeCompleto, String cpf, String telefone, String email) {
			try {
				String query = "insert into clientes values (null, '"+nomeCompleto+"', '"+cpf+"', '"+telefone+"', '"+email+"')";
				this.stmt.executeUpdate(query);
			} catch(Exception e) {
				System.out.println("Erro:" + e.getMessage());
			}
		}
		
		// DELETE
		
		// UPDATE
	
}
