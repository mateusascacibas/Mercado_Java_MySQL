package mercado_Java;

public class Compra {
	private String cli;
	private String prod; 
	private int qtd;
	
	public Compra(String cli, String prod, int qtd) {
		this.setCli(cli);
		this.setProd(prod);
		this.setQtd(qtd);
	}

	public String getCli() {
		return cli;
	}

	public void setCli(String cli) {
		this.cli = cli;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}
