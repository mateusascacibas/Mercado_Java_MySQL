package mercado_Java;

public class Cliente {
	private int id;
	private String sexo;
	private String nome = "";



	public Cliente(int id, String nome, String sexo) {
		this.nome = nome;
		this.id = id;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
