package br.com.lordduck;

import br.com.lordduck.persistencia.entidade.Usuario;
import br.com.lordduck.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		// testeIncluir();
		// testeAlterar();
		testeExcluir();
	}

	public static void testeIncluir() {
		// Criando o usuário
		Usuario usu = new Usuario();
		usu.setNome("Claudio");
		usu.setLogin("Pato");
		usu.setSenha("123");

		// Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.incluir(usu);

		System.out.println("Cadastrado com sucesso.");
	}

	public static void testeAlterar() {
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("Limonge");
		usu.setLogin("LPato");
		usu.setSenha("1234");

		// Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com sucesso.");
	}

	public static void testeExcluir() {
		Usuario usu = new Usuario();
		usu.setId(2);

		// Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Excluído com sucesso.");
	}

}
