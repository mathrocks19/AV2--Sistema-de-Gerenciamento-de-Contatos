package app;

import java.sql.SQLException;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoInsere {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Jailson");
		contato.setEmail("jailsonmendes12@proton.me");
		contato.setEndereco("Casa Redonda Pontiaguda");

		// Validação do sexo
		String sexo = "M";
		if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
			contato.setSexo(sexo);
		} else {
			System.out.println("Sexo inválido. Use 'M' para Masculino ou 'F' para Feminino.");
			return; //sai da insercao
		}

		contato.setCelular("21912345678");

		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}