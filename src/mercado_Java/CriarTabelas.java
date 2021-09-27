package mercado_Java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conexao = Conexao.getConexao();
		String criaClientes = "CREATE TABLE clientes ("
				+ "id int not null auto_increment primary key,"
				+ "nomeCli varchar(255) not null,"
				+ "sexo char(1) not null)";
		
		String criaProdutos = "CREATE TABLE produtos("
				+ "id int not null auto_increment primary key,"
				+ "nomeProd varchar(255) not null,"
				+ "preco decimal(10,0) not null,"
				+ "quantidade int not null)";
		
		String criaCompra = "CREATE TABLE compra("
				+ "id int not null auto_increment primary key,"
				+ "idProduto int not null,"
				+ "idCliente int not null,"
				+ "qtdComprada int not null,"
				+ "precoCompra float,"
				+ "FOREIGN KEY (idProduto) REFERENCES produtos(id),"
				+ "FOREIGN KEY (idCliente) REFERENCES clientes(id))";
		Statement stmt = conexao.createStatement();
		stmt.execute(criaClientes);
		stmt.execute(criaProdutos);
		stmt.execute(criaCompra);
		System.out.println("Tabelas criadas com sucesso");
		conexao.close();
	}

}
