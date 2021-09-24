package mercado_Java;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {

		int opc = 0;
		int opcMenu = 0;
		Scanner teclado = new Scanner(System.in);
		ClienteBanco cliBanco = new ClienteBanco();
		ProdutosBanco prodBanco = new ProdutosBanco();
		CompraBanco compraBanco = new CompraBanco();
		while (opc != 4) {
			try {
				System.out.println("===================================");
				System.out.println(" Mercado feito em Java por Mateus");
				System.out.println("===================================");
				System.out.println("1 - Clientes");
				System.out.println("2 - Produtos");
				System.out.println("3 - Compras");
				System.out.println("4 - Sair");
				System.out.print("Digite a opção que deseja: ");

				opc = teclado.nextInt();
				System.out.println("===================================");
				if (opc == 1) {
					while (opcMenu != 5) {
						System.out.println("---- Menu de Clientes ----");
						System.out.println("===================================");
						System.out.println("1 - Mostrar dados de clientes");
						System.out.println("2 - Cadastrar cliente");
						System.out.println("3 - Remover cliente");
						System.out.println("4 - Editar dados cliente");
						System.out.println("5 - Sair");
						System.out.print("Digite a opção que deseja: ");
						opcMenu = teclado.nextInt();
						System.out.println("===================================");
						switch (opcMenu) {
						case 1: {
							cliBanco.RetornarClientes();
							break;
						}
						case 2: {
							cliBanco.CadastrarCliente();
							break;
						}
						case 3: {
							cliBanco.RemoverCliente();
							break;
						}
						case 4: {
							cliBanco.EditarCliente();
							break;
						}
						case 5: {
							break;
						}
						default: {
							System.out.println("Digite uma opção valida.");
							System.out.println("===================================");
						}
						}
					}

				} else if (opc == 2) {
					while (opcMenu != 5) {
						System.out.println("---- Menu de Produtos ----");
						System.out.println("===================================");
						System.out.println("1 - Mostrar dados de produtos");
						System.out.println("2 - Cadastrar produtos");
						System.out.println("3 - Remover ptoduto");
						System.out.println("4 - Editar dados produto");
						System.out.println("5 - Sair");
						System.out.print("Digite a opção que deseja: ");
						opcMenu = teclado.nextInt();
						System.out.println("===================================");
						switch (opcMenu) {
						case 1: {
							prodBanco.RetornaProdutos();
							break;
						}
						case 2: {
							prodBanco.CadastrarProdutos();
							break;
						}
						case 3: {
							prodBanco.RemoverProdutos();
							break;
						}
						case 4: {
							prodBanco.EditarProdutos();
							break;
						}
						case 5:{
							break;
						}
						default: {
							System.out.println("Digite uma opção valida.");
							System.out.println("===================================");
						}
						}
					}
				} else if (opc == 3) {
					while (opcMenu != 3) {
						System.out.println("---- Menu de Compras ----");
						System.out.println("===================================");
						System.out.println("1 - Mostrar histórico de compras");
						System.out.println("2 - Cadastrar compra");
						System.out.println("3 - Sair");
						System.out.print("Digite a opção que deseja: ");
						opcMenu = teclado.nextInt();
						System.out.println("===================================");
						switch (opcMenu) {
						case 1: {
							compraBanco.RetonarCompra();
							break;
						}
						case 2: {
							compraBanco.CadastrarCompra();
							break;
						}
						case 3: {
							prodBanco.RemoverProdutos();
							break;
						}
						case 4: {
							prodBanco.EditarProdutos();
							break;
						}
						case 5:{
							break;
						}
						default: {
							System.out.println("Digite uma opção valida.");
							System.out.println("===================================");
						}
						}
					}
				}else {
					System.out.println("Digite um opção válida.");
				}
			} catch (Exception e) {
				System.out.println("===================================");
				System.out.println("Digite um numero inteiro.");
				teclado.nextLine();
			}

		}
		teclado.close();
	}
}
