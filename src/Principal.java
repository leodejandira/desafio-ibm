public class Principal {

	public static void main(String[] args) {	
			BancoDeDados sintaxeBanco = new BancoDeDados();			
			Clientes cliente = new Clientes();
			Estoque estoque = new Estoque();
			sintaxeBanco.conectar();
			cliente.conectar();
			estoque.conectar();
			
			if(cliente.estaConectado()) {
				//cliente.cadastrarCliente("Maria da Silva", "11144458952", "21994962587", "maria@ibm.com.br");
				//cliente.listarClientes();
				System.out.println("Conexão foi estabelecida!");
			} else {
				System.out.println("Não foi possível estabelecer uma conexão.");
			}
			
			if(estoque.estaConectado()) {
				//estoque.listarProdutos();
				System.out.println("Conexão estabelecida!");
			} else {
				System.out.println("Não foi possível estabelecer uma conexão.");
			}
	
			if(sintaxeBanco.estaConectado()) {
				System.out.println("Conexão com o db foi estabelecida!");
			} else {
				System.out.println("Não foi possível estabelecer uma conexão com o Banco de Dados.");
			}

		}

	
}
