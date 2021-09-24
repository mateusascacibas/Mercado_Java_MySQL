package mercado_Java;

public class Produtos {
	private String nome;
	private float preco;
	private int id;
	private int quantidade;

	public Produtos(int id, String nome, float preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.id = id;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
