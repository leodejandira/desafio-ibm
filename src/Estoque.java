import java.sql.Connection;
import java.text.DecimalFormat;
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
						VariaveisEstoque produto = new VariaveisEstoque();
					
						produto.idProduto = resultSet.getInt("id_produto");						
						produto.nomeProduto = resultSet.getString("nome_produto");						
						produto.valorUnitario = resultSet.getDouble("valor_unitario");
						produto.categoriaProduto = resultSet.getString("categoria_produto");
						produto.idMarca = resultSet.getInt("id_marca");	
						produto.generico = resultSet.getInt("generico");				
						
						
						if(produto.generico == 1) {	
							produto.setDesconto(produto.valorUnitario);
							System.out.println("--- PRODUTO GENÉRICO ---");
							System.out.println("ID do produto: " + produto.idProduto);
							System.out.println("Nome do produto: " + produto.nomeProduto);				
							System.out.println("Valor do produto sem desconto: R$ " + produto.valorUnitario);							
							System.out.println("Valor com desconto de 20%: R$ " + new DecimalFormat("#,##0.00").format(produto.valorFinal));							
							System.out.println("Categoria do produto: " + produto.categoriaProduto);
							System.out.println("Código da marca: " + produto.idMarca + "\n");
						} else {
							System.out.println("ID do produto: " + produto.idProduto);
							System.out.println("Nome do produto: " + produto.nomeProduto);
							System.out.println("Valor do produto: R$ " + produto.valorUnitario);
							System.out.println("Categoria do produto: " + produto.categoriaProduto);
							System.out.println("Código da marca: " + produto.idMarca + "\n");
						}				
												
					}			 
				
				} catch(Exception e) {
					System.out.println("Erro:" + e.getMessage());
				}
			}
			
			
			// CREATE 
			public void cadastrarProduto(String nomeProduto, String valorUnitario, String categoriaProduto, String codMarca, String generico) {
				try {
					String query = "insert into produtos values (null, '"+nomeProduto+"', '"+valorUnitario+"', '"+categoriaProduto+"', '"+codMarca+"', '"+generico+"')";
					this.stmt.executeUpdate(query);
				} catch (Exception e) {
					System.out.println("Erro: " + e.getMessage());
				}
			}
			
			

}

