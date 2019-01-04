package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	 private String driver = "org.postgresql.Driver";
     private String user = "postgres";
     private String senha = "admin";
     private String url = "jdbc:postgresql://localhost:5432/Agenda";
     private static Connection con = null;
     
     //Funcao conectar ao Banco de dados
 	public Connection conectar() {
 		try {
 			Class.forName(driver);
 			Connection conexao = null;
 			conexao = DriverManager.getConnection(url,user,senha);
 			con=conexao;
 			return con;
 		} catch (Exception e) {
 			e.printStackTrace();
 			System.out.println(e.getMessage());
 			return null;
 		}
      }
      
}
