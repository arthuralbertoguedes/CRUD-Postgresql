package controller;


import java.sql.Connection;
import java.util.ArrayList;

import DAO.Conexao;
import DAO.ContatoDAO;
import model.Contato;

public class ContatoController {
	
	public static void main(String[] args) {
		Conexao con = new Conexao();
		Connection conexao = con.conectar();
		
		ContatoDAO manipularContato = new ContatoDAO(conexao);
		
		manipularContato.removerContato(10);
		
		ArrayList<Contato> contatos = manipularContato.buscarContato("Carlos");
		
		if(contatos!=null)
			for(Contato contato : contatos) {
				System.out.println(contato.getId());
				System.out.println(contato.getNome());
				System.out.println(contato.getTelefone());
				System.out.println(contato.getEndereco());
				System.out.println("\n");
			}
		
		
	}
}
