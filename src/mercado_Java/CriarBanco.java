package mercado_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost";
		String user = "root";
		String password = "";
		Connection conexao = DriverManager.getConnection(url, user, password);
		String sql = "CREATE DATABASE mercado_java";
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		System.out.println("Banco criado com sucesso");
		conexao.close();
		
	}

}
