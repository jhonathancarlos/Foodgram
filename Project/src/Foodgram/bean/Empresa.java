package Foodgram.bean;

public class Empresa extends Usuario{
	//Atributos
		/*private Publicacao publicacao;
		private Produto produto;*/
	
	//Construtor
	public Empresa() {
	}
	
	public Empresa(int Id, String Nome, String Email, String Senha, String Registro, String Telefone) {
		super(Id, Nome, Email, Senha, Registro, Telefone);
	}

	

	//Metodos Getters e Setters
	/*public String getDescricaoPublicacao() {
		return publicacao.Descricao;
	}

	public String getProduto() {
		return produto.getDescricao();
	}*/
	
	@Override
	public String toString() {
	    return "Empresa { " +
	        "Id: " + getId() +
	        ", Nome: " + getNome() +
	        ", Email: " + getEmail() +
	        ", Senha: " + getSenha() +
	        ", Registro: " + getRegistro() +
	        ", Telefone: " + getTelefone() +
	        " }";
	}
}
