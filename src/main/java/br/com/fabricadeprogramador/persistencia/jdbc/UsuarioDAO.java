package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario user) {
		
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getLogin());
			preparador.setString(3, user.getSenha());
			//executando a query sql
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void alterar(Usuario user) {
		
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getLogin());
			preparador.setString(3, user.getSenha());
			preparador.setInt(4, user.getId());
			//executando a query sql
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario user) {
		
		String sql = "delete from usuario where id=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, user.getId());
			//executando a query sql
			preparador.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String salvar(Usuario user){
		if(user.getId()!=null){
			alterar(user);
			return "Usuário alterado!";
		}else{
			cadastrar(user);
			return "Novo usuário cadastrado!";
		}
	}

	
	/**
	 * Busca de um registro no banco de dados utilizando pelo número do id do usuário.
	 * @param id É um inteiro que representa o número do id do usuário a ser buscado.
	 * @return Retorna uma instância do objeto Usuario, sendo este preenchido se o usuário existir no banco e com propriedades nulas e nome "usuário não existente" se o usuário não for encontrado.
	 */
	
	public Usuario buscaPorId(Integer id) {
		Usuario user = null;

		String sql = "select * from usuario where id=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			//executando a query sql
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()){
				user = new Usuario();
				user.setId(resultado.getInt("id"));
				user.setNome(resultado.getString("nome"));
				user.setLogin(resultado.getString("login"));
				user.setSenha(resultado.getString("senha"));
			}else{
				user = new Usuario();
				user.setNome("usuário não encontrado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public List<Usuario> buscaTodos() {
		Usuario user = null;

		String sql = "select * from usuario";
		
		List<Usuario> listaUsers = new ArrayList<Usuario>();
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				user = new Usuario();
				user.setId(resultado.getInt("id"));
				user.setNome(resultado.getString("nome"));
				user.setLogin(resultado.getString("login"));
				user.setSenha(resultado.getString("senha"));
				listaUsers.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaUsers;
	}
	
	/**
	 * Realiza a autenticação do usuário através de login e senha.
	 * @param userConsult Usuário configurado com determinado login e senha.
	 * @return Usuário completo, se localizado e autenticado, ou NULO, se não encontrado.
	 */
	public Usuario autenticar(Usuario userConsult){
			
		String sql = "Select * from usuario where login=? and senha=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, userConsult.getLogin());
			preparador.setString(2, userConsult.getSenha());
			ResultSet result = preparador.executeQuery();
			if(result.next()){
				userConsult.setId(result.getInt("id"));
				userConsult.setNome(result.getString("nome"));
			}else{
				userConsult.setNome(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userConsult;
		
	}
	
	
}
