package Foodgram.bean;

public class Publicacao {
	//Atributos
	public int Id;
	public String Descricao;
	public int Id_Produto;
	public int Id_Empresa;
	
	public Publicacao() {
	}
	
	public Publicacao(int Id, String Descricao, int Id_Produto, int Id_Empresa) {
		this.Id = Id;
		this.Descricao = Descricao;
		this.Id_Produto = Id_Produto;
		this.Id_Empresa = Id_Empresa;
	}
	
	//Metodos Getters e Setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getId_Produto() {
		return Id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		Id_Produto = id_Produto;
	}

	public int getId_Empresa() {
		return Id_Empresa;
	}

	public void setId_Empresa(int id_Empresa) {
		Id_Empresa = id_Empresa;
	}
	
	@Override
	public String toString() {
	    return "Publicacao {" +
	            "Id=" + Id +
	            ", Descricao='" + Descricao + '\'' +
	            ", Id_Produto=" + Id_Produto +
	            ", Id_Empresa=" + Id_Empresa +
	            '}';
	}

}
