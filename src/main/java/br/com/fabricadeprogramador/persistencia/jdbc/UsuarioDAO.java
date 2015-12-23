package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
