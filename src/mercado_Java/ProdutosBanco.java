package mercado_Java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutosBanco {
	public void RetornaProdutos() throws SQLException {
		Connection conexao = Conexao.getConexao();
		List<Produtos> produtos = new ArrayList<Produtos>();
		String sql = "SELECT * FROM produtos";
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		while (resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nomeProd");
			Float preco = resultado.getFloat("preco");
			int quantidade = resultado.getInt("quantidade");
			produtos.add(new Produtos(id, nome, preco, quantidade));
		}
		for (Produtos p : produtos) {
			System.out.println("ID: " + p.getId() + "\nProduto: " + p.getNome() + "\nPreco: " + p.getPreco()
					+ "\nQuantidade: " + p.getQuantidade() + "\n ------------");
		}
		conexao.close();
	}

	public void CadastrarProdutos() throws SQLException {
		Connection conexao = Conexao.getConexao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome do produto: ");
		String nome = teclado.nextLine();
		System.out.println("Digite o preço do produto: ");
		float preco = teclado.nextFloat();
		System.out.println("Digite a quantidade em estoque: ");
		int quantidade = teclado.nextInt();
		String sql = "INSERT INTO produtos (nomeProd, preco, quantidade) VALUES (?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setFloat(2, preco);
		stmt.setInt(3, quantidade);
		stmt.execute();
		System.out.println("---- Produto cadastrado com sucesso ----");
		conexao.close();
	}

	public void RemoverProdutos() throws SQLException {
		Connection conexao = Conexao.getConexao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o ID do produto que deseja remover: ");
		int id = teclado.nextInt();
		String sql = "DELETE FROM produtos WHERE id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("---- Produto excluido com sucesso! ----");
		conexao.close();
	}

	public void EditarProdutos() throws SQLException {
		Connection conexao = Conexao.getConexao();
		ProdutosBanco prod = new ProdutosBanco();
		Scanner teclado = new Scanner(System.in);
		System.out.println("---- Produtos ----");
		prod.RetornaProdutos();
		System.out.println("Digite o ID do produto que deseja editar: ");
		int id = teclado.nextInt();
		boolean sair = false;
		while (!sair) {
			System.out.println("---- Deseja alterar o nome (1), preço (2) ou quantidade (3) do produto?");
			int op = teclado.nextInt();
			teclado.nextLine();
			if (op == 1) {
				System.out.println("===================================");
				System.out.println("Novo nome: ");
				String nome = teclado.nextLine();
				String sql = "UPDATE produtos SET nomeProd = ? WHERE id = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, id);
				stmt.execute();
				System.out.println("---- Nome atualizado com sucesso! ----");
				sair = true;
			} else if (op == 2) {
				System.out.println("===================================");
				System.out.println("Novo preço: ");
				String preco = teclado.nextLine();
				String sql = "UPDATE produtos SET preco = ? WHERE id = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, preco);
				stmt.setInt(2, id);
				stmt.execute();
				System.out.println("---- Preço atualizado com sucesso! ----");
				sair = true;
			} else if(op == 3) {
				System.out.println("===================================");
				System.out.println("Nova quantidade: ");
				String quantidade = teclado.nextLine();
				String sql = "UPDATE produtos SET quantidade = ? WHERE id = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, quantidade);
				stmt.setInt(2, id);
				stmt.execute();
				System.out.println("---- Quantidade atualizada com sucesso! ----");
				sair = true;
			}
		}
	}
}
