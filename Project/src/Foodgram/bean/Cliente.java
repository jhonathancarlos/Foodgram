package Foodgram.bean;

public class Cliente extends Usuario{
	//Atributos
		//private Avaliacao avaliacao;
		
	//Construtor
	public Cliente(){
	}
	public Cliente(int Id, String Nome, String Email, String Senha, String Registro, String Telefone) {
		super(Id, Nome, Email, Senha, Registro, Telefone);
	}

	//Metodos Getters e Setters
	/*public String getDescricaoAvaliacao() {
		return avaliacao.Descricao;
	}
	public Float getEstrelas() {
		return avaliacao.Estrela;
	}*/
	
	@Override
	public String toString() {
	    return "Cliente { " +
	        "Id: " + getId() +
	        ", Nome: " + getNome() +
	        ", Email: " + getEmail() +
	        ", Senha: " + getSenha() +
	        ", Registro: " + getRegistro() +
	        ", Telefone: " + getTelefone() +
	        " }";
	}
}
