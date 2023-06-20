package Foodgram.bean;

public abstract class Usuario {
	//Atributos
	private int Id;
	private String Nome;
	private String Email;
	private String Senha;
	private String Registro;
	private String Telefone;

	// Construtor 
	public Usuario(){
	}
    public Usuario(int Id, String Nome, String Email, String Senha, String Registro, String Telefone) {
    	this.Id = Id;
    	this.Nome = Nome;
    	this.Email = Email;
    	this.Senha = Senha;
    	this.Registro = Registro;
    	this.Telefone = Telefone;
    }

  //Metodos Getters e Setters
    public int getId() {
		return Id;
	}

    public void setId(int id) {
		Id = id;
	}
    
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
    
	public String getRegistro() {
		return Registro;
	}

	public void setRegistro(String registro) {
		Registro = registro;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

}
