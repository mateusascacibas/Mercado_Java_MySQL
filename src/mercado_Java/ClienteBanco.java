package mercado_Java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClienteBanco {
	public void RetornarClientes() throws SQLException {
		Connection conexao = Conexao.getConexao();
		Statement stmt = conexao.createStatement();
		String sql = "SELECT * from clientes";
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet resultado = stmt.executeQuery(sql);
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			String sexo = resultado.getString("sexo");
			clientes.add(new Cliente(id, nome, sexo));
		}
		
		for(Cliente c: clientes) {
			System.out.println("Id: " + c.getId() + " Nome: " + c.getNome() + " Sexo: " + c.getSexo());
		}
		conexao.close();
	}
	
	public void CadastrarCliente() throws SQLException{

		Scanner teclado = new Scanner(System.in);
		Connection conexao = Conexao.getConexao();
		System.out.println("Digite o nome que deseja cadastrar: ");
		String nome = teclado.nextLine();
		System.out.println("Digite o sexo: (m/f) ");
		String sexo = teclado.next();
		String sql = "INSERT INTO clientes (nome,sexo) value (?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, sexo);
		stmt.execute();
		System.out.println("---- Cliente cadastrado com sucesso! ----");
		conexao.close();
		
	}
	
	public void RemoverCliente() throws SQLException{
		Connection conexao = Conexao.getConexao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o ID do cliente que deseja remover: ");
		int id = teclado.nextInt();
		String sql = "DELETE FROM clientes WHERE id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("---- Cliente excluido com sucesso! ----");
		conexao.close();
	}

	public void EditarCliente() throws SQLException{
		Connection conexao = Conexao.getConexao();
		ClienteBanco cli = new ClienteBanco();
		Scanner teclado = new Scanner(System.in);
		System.out.println("---- Clientes ----");
		cli.RetornarClientes();
		System.out.println("Digite o ID do cliente que deseja editar: ");
		int id = teclado.nextInt();
		boolean sair = false;
		while(!sair) {
			System.out.println("---- Deseja alterar o nome (1) ou sexo (2) do cliente?");
			int op = teclado.nextInt();
			teclado.nextLine();
			if(op == 1) {
				System.out.println("===================================");
				System.out.println("Novo nome: ");
				String nome = teclado.nextLine();
				String sql = "UPDATE clientes SET nome = ? WHERE id = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, id);
				stmt.execute();
				System.out.println("---- Nome atualizado com sucesso! ----");
				sair = true;
			} else if(op == 2) {
				System.out.println("===================================");
				System.out.println("Novo sexo: ");
				String sexo = teclado.nextLine();
				String sql = "UPDATE clientes SET sexo = ? WHERE id = ?";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, sexo);
				stmt.setInt(2, id);
				stmt.execute();
				System.out.println("---- Sexo atualizado com sucesso! ----");
				sair = true;
			}
		}
		
		conexao.close();
	}
}
