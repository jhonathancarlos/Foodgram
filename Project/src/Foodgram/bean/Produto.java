package Foodgram.bean;

public class Produto {
	//Atributos
	private int Id;
	private String Descricao;
	private float Valor;
	private int Id_Empresa;
	
	//Construtor
	public Produto() {
	}
	
	public Produto(int Id, String Descricao, float Valor, int Id_Empresa) {
		this.Id = Id;
		this.Descricao = Descricao;
		this.Valor = Valor;
		this.Id_Empresa = Id_Empresa;
	}
	
	//Metodo

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

	public float getValor() {
		return Valor;
	}

	public void setValor(float valor) {
		Valor = valor;
	}

	public int getId_Empresa() {
		return Id_Empresa;
	}

	public void setId_Empresa(int id_Empresa) {
		Id_Empresa = id_Empresa;
	}
	
	@Override
	public String toString() {
	    return "Produto {" +
	            "Id=" + Id +
	            ", Descricao='" + Descricao + '\'' +
	            ", Valor=" + Valor +
	            ", Id_Empresa=" + Id_Empresa +
	            '}';
	}

}
