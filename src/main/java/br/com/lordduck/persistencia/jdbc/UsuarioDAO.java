package br.com.lordduck.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lordduck.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection conn = ConexaoFactory.getConnection();

	public void incluir(Usuario usu) {

		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome()); // substitui o ? pelo dado
													// do usu�rio
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
			//preparador.close(); //Statement implementa Autocloseable()
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome = ?, login = ?, senha = ? where id=?";
		try (PreparedStatement preparador = conn.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id=?";
		try (PreparedStatement preparador = conn.prepareStatement(sql)) {
			preparador.setInt(1, usu.getId());
			preparador.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
