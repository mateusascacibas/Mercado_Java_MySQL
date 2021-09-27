package mercado_Java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompraBanco {
	public void RetonarCompra() throws SQLException {
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT nomeCli, nomeProd, qtdComprada, precoCompra FROM clientes, compra, produtos WHERE clientes.id = compra.idCliente AND produtos.id = compra.idProduto";
		Statement stmt = conexao.createStatement();
		List<Compra> compras = new ArrayList<Compra>();
		ResultSet resultado = stmt.executeQuery(sql);
		while (resultado.next()) {
			String nomeCli = resultado.getString("nomeCli");
			String nomeProd = resultado.getString("nomeProd");
			int qtd = resultado.getInt("qtdComprada");
			float preco = resultado.getFloat("precoCompra");
			compras.add(new Compra(nomeCli, nomeProd, qtd, preco));
		}

		for (Compra c : compras) {
			System.out.println("Cliente: " + c.getCli() + "\nProduto: " + c.getProd() + "\nQuantidade: " + c.getQtd() + "\nPreço Total: " + c.getPreco()
					+ "\n ------------");
		}
		conexao.close();
	}

	public void CadastrarCompra() throws SQLException {
		Connection conexao = Conexao.getConexao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o ID do cliente que realizou a compra: ");
		int idCli = teclado.nextInt();
		System.out.println("Digite o ID do produto comprado: ");
		int idProd = teclado.nextInt();
		System.out.println("Digite a quantidade comprada: ");
		int qtd = teclado.nextInt();
		
		String sqlPreco = "SELECT preco FROM produtos where id = 1";
		Statement stmtPreco = conexao.createStatement();
		ResultSet result = stmtPreco.executeQuery(sqlPreco);
		float precoProd = 0;
		float precoCompra = 0;
		while (result.next()) {
			precoProd = result.getFloat("preco");
		}
		precoCompra = qtd * precoProd;
		String sql = "INSERT INTO compra (idProduto, idCliente, qtdComprada, precoCompra) VALUES(?,?,?,?)";
		String atualizaEstoque = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
		PreparedStatement stmtEstoque = conexao.prepareStatement(atualizaEstoque);
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmtEstoque.setInt(1, qtd);
		stmtEstoque.setInt(2, idProd);
		stmt.setInt(1, idProd);
		stmt.setInt(2, idCli);
		stmt.setInt(3, qtd);
		stmt.setFloat(4, precoCompra);
		stmt.execute();
		stmtEstoque.execute();
		System.out.println("---- Compra realizada com sucesso! ----");
		conexao.close();
	}
}
