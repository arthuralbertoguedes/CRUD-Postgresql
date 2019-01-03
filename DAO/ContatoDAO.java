package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Contato;

public class ContatoDAO {
	
	private Connection con;
	ArrayList<Contato> contatos = new ArrayList<>();
	
	
	public ContatoDAO(Connection con) {
		this.con = con;
	}
     
	
     public void adicionarContato(Contato c) {
    	 String sql = " insert into contato (nome,telefone,endereco) values"
    	 		+ " (?,?,?) ";
    	 try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,c.getNome());
			stmt.setString(2,c.getTelefone());
			stmt.setString(3,c.getEndereco());
			stmt.execute();
			System.out.println("Contato " + c.getNome() + " adicionado com sucesso!");
    	 } catch (SQLException e) {
			e.printStackTrace();
		}
     }
     
     
     public ArrayList<Contato> buscarContato(String nomeContato) {
    	 String sql = " select * from contato where nome LIKE ?";
    	 try {
 			PreparedStatement stmt = con.prepareStatement(sql);
 			stmt.setString(1,nomeContato + "%");
 			ResultSet rs = stmt.executeQuery();
 			while(rs.next()) {
 				Contato novoContato = new Contato(rs.getInt("Id"),rs.getString("nome"),rs.getString("telefone"),rs.getString("endereco"));
 				this.contatos.add(novoContato);
 			}
 			return this.contatos;
 			
     	 } catch (SQLException e) {
 			e.printStackTrace();
 			return null;
 		}
     }

     
     
     public void removerContato(int idContato) {
    	 String sql = "delete from contato where id=?";
    	 try {
 			PreparedStatement stmt = con.prepareStatement(sql);
 			stmt.setInt(1,idContato);
 			stmt.execute();
 			System.out.println("Contato removido com sucesso!");
     	 } catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     
     public void atualizarContato(Contato c, String coluna, String novoValor) {
    	 String sql = "";
    	 if(coluna.equals("nome"))
    		 sql = "update contato set nome=? where nome=?";
    	 else if(coluna.equals("telefone"))
    		 sql = "update contato set telefone=? where nome=?";
    	 else if(coluna.equals("endereco"))
    		 sql = "update contato set endereco=? where nome=?";
		
    	 try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,novoValor);
			stmt.setString(2,c.getNome());
			System.out.println("Contato atualizado com sucesso!");
			stmt.execute();
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     }
}
