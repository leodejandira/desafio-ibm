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
		// Ler todos os clientes
		public void listarClientes() {
			// Criando o processo de tratamento dos comando no banco de dados
			try {
				//Criando uma variável para a sintaxe em sql
				String query = "select * from clientes ";
				this.resultSet = this.stmt.executeQuery(query);
				this.stmt=this.conn.createStatement();
				//Criando um laço de repetição para retornar os registros da nossa tabela
				while(this.resultSet.next()) {
					//iniciando as Variáveis cliente
					VariaveisCliente c = new VariaveisCliente();
					//Setando as informações do MySQL para uma variável cliente
					c.setId(resultSet.getString("id_client"));
					c.setNome(resultSet.getString("nome_cliente"));
					c.setCpf(resultSet.getString("cpf_cliente")); 
					c.setTelefone(resultSet.getString("telefone_cliente"));
					c.setEmail(resultSet.getString("email_cliente")); 
					//Mostrando no console os registros encontrados
					System.out.println("Id: "+c.getId()+" Nome: "+c.getNome());
					System.out.println("CPF:"+c.getCpf()+" Telefone: "+c.getTelefone());
					System.out.println("Email: "+c.getEmail()+"\n\n");
				}
				}catch(Exception e ) {
					System.out.println("Erro"+e.getMessage()+"\n\n");
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
		
		public void deletarclientes(String id, String confirma) {
			try {
				String query="delete from clientes where id_client="+id+";";
				System.out.println(query);
				this.stmt.executeUpdate(query);
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		// UPDATE
		
		public void editarContatos(String id, String nome, String cpf, String telefone, String email) {
			try {
				String consulta = "update clientes set nome_cliente='"+nome+"', cpf_cliente= '"+cpf+"', telefone_cliente='"+telefone+"', email_cliente='"+email+"'  where id_client= "+id+";";
				System.out.println(consulta);
				System.out.println(this.stmt);
				this.stmt.executeUpdate(consulta);
			} catch (Exception e) {
				System.out.println("Error: "+ e.getMessage());
			}
		}
	
}
