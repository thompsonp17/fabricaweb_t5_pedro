package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usercontroller")
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
		
		System.out.println("Ok!");
	}
	
}
