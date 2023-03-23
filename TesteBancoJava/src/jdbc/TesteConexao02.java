package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteConexao02 {
	private static Connection connection;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String SERVIDOR = "localhost";
	private static final String PORTA = "5432";
	private static final String BANCO = "postgres";
	private static final String URL = "jdbc:postgresql://" + SERVIDOR + ":" + PORTA + "/" + BANCO;
	private static final String USUARIO = "postgres";
	private static final String SENHA = "123";


	public static synchronized Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexao\n" + e);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Nao foi possivel estabalecer conexao com o banco de dados\n" + e);
			}
		}
		JOptionPane.showMessageDialog(null, "Conexao realizada com sucesso!");
		return connection;
	}
	
	
}