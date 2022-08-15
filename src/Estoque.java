import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	
public class Estoque {

	
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
			public void listarProdutos() {			
				try {				
					String query = "select * from produtos";
					this.resultSet = this.stmt.executeQuery(query);				
					this.stmt = this.conn.createStatement();	
					
					while(this.resultSet.next()) {				
					
						String idProduto = resultSet.getString("id_produto");
						String nomeProduto = resultSet.getString("nome_produto");
						String valorUnitario = resultSet.getString("valor_unitario");
						String categoriaProduto = resultSet.getString("categoria_produto");
						String codMarca = resultSet.getString("id_marca");				
						System.out.println("ID do produto: " + idProduto);
						System.out.println("Nome do produto: " + nomeProduto);
						System.out.println("Valor do produto: R$ " + valorUnitario);
						System.out.println("Categoria do produto: " + categoriaProduto);
						System.out.println("Código da marca: " + codMarca + "\n");	
						
					}			 
				
				} catch(Exception e) {
					System.out.println("Erro:" + e.getMessage());
				}
			}		
					
}

