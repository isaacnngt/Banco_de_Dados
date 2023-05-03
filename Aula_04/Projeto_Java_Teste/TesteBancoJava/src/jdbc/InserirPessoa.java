package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class InserirPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner scn = new Scanner(System.in);
		
		
		/*//Jeito Errado (INICIO) - Causara SQL Injection
		System.out.println("Informe o nome");
		String nome = scn.next();
		
		String sql = "Insert Into pessoas (nome) Values ('"+nome+"')";
		
		System.out.println(sql);
		
		scn.close();
		//Jeito errado (FIM)*/
		
		
				//Jeito certo (INICIO) - Desse jeito que foi criado ele bloqueará tentativa de comandos SQL
				System.out.println("Informe o nome");
				String nome = scn.nextLine();
				
				//chamada da conexão
				Connection conexao = FarmDeConexao.getConnection();
				
				//Comando Sql de inserção
				String sql = "Insert Into pessoas (nome) Values (?)";
				//String sql = "Insert Into pessoas (nome, codigo) Values (?,?)";
				
				//Preparo da declaracao
				PreparedStatement stmt = conexao.prepareStatement(sql);
				//Parametrizando 
				
				stmt.setString(1, nome);
				//stmt.setInt(2, 100);
				
				//execucao da query
				stmt.execute();
				
				System.out.println("Pessoa inserida com sucesso!");
				
				//fechando scanner
				scn.close();
				//Jeito certo (FIM)
		

	}

}
