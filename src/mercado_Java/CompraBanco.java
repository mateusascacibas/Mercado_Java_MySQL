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
	public void RetonarCompra() throws SQLException{
		Connection conexao = Conexao.getConexao();
		String sql = "SELECT nomeCli, nomeProd, qtdComprada FROM clientes, compra, produtos WHERE clientes.id = compra.idCliente AND produtos.id = compra.idProduto";
		Statement stmt = conexao.createStatement();
		List<Compra> compras = new ArrayList<Compra>();
		ResultSet resultado = stmt.executeQuery(sql);
		while(resultado.next()) {
			String nomeCli = resultado.getString("nomeCli");
			String nomeProd = resultado.getString("nomeProd");
			int qtd = resultado.getInt("qtdComprada");
			compras.add(new Compra(nomeCli, nomeProd, qtd));
		}
		
		for(Compra c: compras) {
			System.out.println("Cliente: " + c.getCli() + "\nProduto: " + c.getProd() + "\nQuantidade: " + c.getQtd() + "\n ------------");
		}
		conexao.close();
	}

	public void CadastrarCompra() throws SQLException{
		Connection conexao = Conexao.getConexao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o ID do cliente que realizou a compra: ");
		int idCli = teclado.nextInt();
		System.out.println("Digite o ID do produto comprado: ");
		int idProd = teclado.nextInt();
		System.out.println("Digite a quantidade comprada: ");
		int qtd = teclado.nextInt();
		/*
		 * String sqlPreco = "SELECT preco FROM produtos where id = ?";
		 * PreparedStatement stmtPreco = conexao.prepareStatement(sqlPreco); ResultSet
		 * result = stmtPreco.executeQuery(); double precoCompra = qtd * result.toDou;
		 */
		String sql = "INSERT INTO compra (idProduto, idCliente, qtdComprada, precoCompra) VALUES(?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, idProd);
		stmt.setInt(2, idCli);
		stmt.setInt(3, qtd);
		
		conexao.close();
	}
}
