package BancoDeDados;

import java.sql.*;

public class Conexao
{
	public static String status = "";
	public static String servidor;
	public static String bancoDoServidor;
	public static String user;
	public static String pass;

	public static Connection conectaAoBanco()
	{
		Connection con = null;
		servidor = "dbmy0049.whservidor.com:3306/";
		bancoDoServidor = "engenharia304";
		user = "engenharia304";
		pass = "tomi0001";

		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // Pega a classe Driver
			
			String url = "jdbc:mysql://" + servidor + bancoDoServidor + "?user=" + user + "&password=" + pass; // Configura a String completa de acesso ao Banco
                        
			con = DriverManager.getConnection(url); // Conecta ao Banco.
			
			status = "Conexao Aberta"; // APENAS PARA DEBUG - Mostra o Status da Conexão
		}
		catch (ClassNotFoundException e) { status = e.getMessage(); }
		catch (SQLException e) { status = e.getMessage(); }
		catch (Exception e) { status = e.getMessage(); }
		
		return con; // Retorna a Conexão.
	}	
}