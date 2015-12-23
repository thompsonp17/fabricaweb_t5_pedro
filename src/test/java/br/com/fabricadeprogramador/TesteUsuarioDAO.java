package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		testeExcluir();
		
	}

	public static void testeCadastrar(){

		//Criando o usuário
		Usuario user = new Usuario();
		user.setNome("Jãozão");
		user.setLogin("jzao");
		user.setSenha("123");
		
		//Cadastrando usuário no BD
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.cadastrar(user);
		
		System.out.println("Cadastrado com sucesso!!");
		
	}

	public static void testeAlterar(){

		//Criando o usuário
		Usuario user = new Usuario();
		user.setId(3);
		user.setNome("Jãozão da Silva");
		user.setLogin("jzaoasdasd");
		user.setSenha("123hgvv");
		
		//Cadastrando usuário no BD
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.alterar(user);
		
		System.out.println("Alterado com sucesso!!");
		
	}
	
	private static void testeExcluir() {
		//Criando o usuário
		Usuario user = new Usuario();
		user.setId(1);
		//user.setNome("Jãozão da Silva");
		//user.setLogin("jzaoasdasd");
		//user.setSenha("123hgvv");

		//Cadastrando usuário no BD
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.excluir(user);

		System.out.println("Excluido com sucesso!!");

	}
	
}
