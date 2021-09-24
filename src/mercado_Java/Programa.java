package mercado_Java;


import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		
		int opc = 0;
		Scanner teclado = new Scanner(System.in);
		ClienteBanco cliBanco = new ClienteBanco();
		ProdutosBanco prodBanco = new ProdutosBanco();
		while(opc != 9) {
			try {
				System.out.println("===================================");
				System.out.println(" Mercado feito em Java por Mateus");
				System.out.println("===================================");
				System.out.println("1 - Clientes");
				System.out.println("2 - Produtos");
				System.out.println("1 - Mostrar nome de clientes");
				System.out.println("2 - Mostrar produtos");
				System.out.println("3 - Cadastrar cliente");
				System.out.println("4 - Cadastrar produto");
				System.out.println("5 - Remover cliente");
				System.out.println("6 - Remover produto");
				System.out.println("7 - Editar dados cliente");
				System.out.println("8 - Editar dados produto");
				System.out.println("===================================");
				System.out.print("Digite a opção que deseja: ");
				opc = teclado.nextInt();
				System.out.println("===================================");
				if(opc == 1) {
					cliBanco.RetornarClientes();
				} else if(opc == 2) {
					prodBanco.RetornaProdutos();
				} else if(opc == 3) {
					cliBanco.CadastrarCliente();
				} else if(opc == 4) {
					prodBanco.CadastrarProdutos();
				} else if(opc == 5) {
					cliBanco.RemoverCliente();
				} else if(opc == 6) {
					prodBanco.RemoverProdutos();
				} else if(opc == 7) {
					cliBanco.EditarCliente();
				} else if (opc == 8) {
					
				}
			} catch (Exception e) {
				System.out.println("Erro");
				System.out.println(e);
				break;
			}
	
		}
		teclado.close();
	}
}
	
	
