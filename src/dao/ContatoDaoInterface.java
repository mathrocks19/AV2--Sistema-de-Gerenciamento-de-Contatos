package dao;

import java.sql.SQLException;
import java.util.List;

import model.Contato;

public interface ContatoDaoInterface {

    void adiciona(Contato contato) throws SQLException;
    List<Contato> listaContatos() throws SQLException;
    Contato buscaPorId(Long id) throws SQLException;
    List<Contato> buscaPorNome(String nome) throws SQLException;
    void altera(Contato contato) throws SQLException;
    void remove(Long id) throws SQLException;
}