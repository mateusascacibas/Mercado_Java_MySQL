package mercado_Java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	public static Connection getConexao() {
		Properties prop;
		try {
			prop = getProperties();
			String url = prop.getProperty("banco.url");
			String user = prop.getProperty("banco.user");
			String password = prop.getProperty("banco.password");
			return DriverManager.getConnection(url, user, password);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static Properties getProperties() throws IOException{
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(Conexao.class.getResourceAsStream(caminho));
		return prop;
	}
}
