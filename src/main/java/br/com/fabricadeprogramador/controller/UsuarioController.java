package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usercontroller.do")
public class UsuarioController extends HttpServlet{

	public UsuarioController() {
		System.out.println("Construtor...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init...");
		super.init();
	}

	@Override
	public void destroy() {
		System.out.println("Destroy...");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//PAUSE: video-aula 4: @ 19:37
		
		System.out.println("Sucesso!!!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario user = new Usuario();

		if (id != null)
			user.setId(Integer.parseInt(id));

		user.setLogin(login);
		user.setNome(nome);
		user.setSenha(senha);

		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.salvar(user);

		resp.getWriter().print("Sucesso! Salvou direitinho!");

		System.out.println("Sucesso no doPost!");
	}

}
