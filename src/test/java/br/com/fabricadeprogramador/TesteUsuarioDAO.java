package br.com.fabricadeprogramador;

import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeSalvar();
		
		List<Usuario> lista = TestaBuscaTodosOsUsuarios();
		System.out.println("*****Lista de Usuarios******");
		for(Usuario user : lista){
			System.out.print("Id: " + user.getId());
			System.out.print(" | Nome: " + user.getNome());
			System.out.print(" | Login: " + user.getLogin());
			System.out.print(" | Senha: " + user.getSenha());
			System.out.println("");
		}
		System.out.println("*****FIM******");
		
	}

	private static Usuario buscaUsuarioPorId() {
		UsuarioDAO userDAO = new UsuarioDAO();
		return userDAO.buscaPorId(new Integer(100));
	}

	private static void testeSalvar() {
		Usuario user = new Usuario();
		user.setId(4);
		user.setNome("Pedro Thompson Furtado");
		user.setLogin(null);
		user.setSenha("xxx123");
		
		UsuarioDAO userDAO = new UsuarioDAO();
		String result = userDAO.salvar(user);
		
		System.out.println(result);
		
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
	
	private static List<Usuario> TestaBuscaTodosOsUsuarios(){
		List<Usuario> listaUsers = new ArrayList<Usuario>(); 
		
		UsuarioDAO userDAO = new UsuarioDAO();
		
		listaUsers = userDAO.buscaTodos();
		
		return listaUsers;
	}

	
}
