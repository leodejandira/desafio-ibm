
public class VariaveisEstoque {	
	int idProduto, idMarca;
	int generico;
	double valorUnitario, valorFinal;
	String nomeProduto, categoriaProduto;	
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getIdMarca() {
		return idMarca;
	}
	
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	public int getGenerico() {
		return generico;
	}
	
	public void setGenerico(int generico) {
		this.generico = generico;
	}
	
	public void setDesconto(double valorUnitario) {				
		Math.round(valorFinal = (valorUnitario * 0.8));
		
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getCategoriaProduto() {
		return categoriaProduto;
	}
	
	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
		
	
}
