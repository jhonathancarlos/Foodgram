package Foodgram.bean;

public class Avaliacao {
	//Atributos
	public int Id;
	public String Descricao;
	public float Estrela;
	public int Id_Cliente;
	public int Id_Publicacao;
	
	//Construtor
	public Avaliacao() {
	}
	
	public Avaliacao(int Id, String Descricao, float Estrela, int Id_Cliente, int Id_Publicacao) {
		this.Id = Id;
		this.Descricao = Descricao;
		this.Estrela = Estrela;
		this.Id_Cliente = Id_Cliente;
		this.Id_Publicacao = Id_Publicacao;
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
	public float getEstrela() {
		return Estrela;
	}
	public void setEstrela(float estrela) {
		Estrela = estrela;
	}
	public int getId_Cliente() {
		return Id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}
	public int getId_Publicacao() {
		return Id_Publicacao;
	}
	public void setId_Publicacao(int id_Publicacao) {
		Id_Publicacao = id_Publicacao;
	}
	
	@Override
	public String toString() {
	    return "Avaliacao {" +
	            "Id=" + Id +
	            ", Descricao='" + Descricao + '\'' +
	            ", Estrela=" + Estrela +
	            ", Id_Cliente=" + Id_Cliente +
	            ", Id_Publicacao=" + Id_Publicacao +
	            '}';
	}

}
