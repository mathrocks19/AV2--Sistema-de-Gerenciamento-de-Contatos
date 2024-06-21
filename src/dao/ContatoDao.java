package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javabanco.ConnectionFactory;
import model.Contato;

public class ContatoDao implements ContatoDaoInterface {
    private Connection con;

    public ContatoDao() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    // Implementação dos métodos da interface
    public void adiciona(Contato contato) throws SQLException {
        String sql = "INSERT INTO contatos(nome, email, endereco, sexo, celular) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setString(4, contato.getSexo());
            stmt.setString(5, contato.getCelular());
            stmt.execute();
        }
    }

    public List<Contato> listaContatos() throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setSexo(rs.getString("sexo"));
                contato.setCelular(rs.getString("celular"));
                contatos.add(contato);
            }
        }
        return contatos;
    }

    public Contato buscaPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM contatos WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Contato contato = new Contato();
                    contato.setId(rs.getLong("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setEmail(rs.getString("email"));
                    contato.setEndereco(rs.getString("endereco"));
                    contato.setSexo(rs.getString("sexo"));
                    contato.setCelular(rs.getString("celular"));
                    return contato;
                }
            }
        }
        return null;
    }

    public List<Contato> buscaPorNome(String nome) throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos WHERE nome LIKE ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Contato contato = new Contato();
                    contato.setId(rs.getLong("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setEmail(rs.getString("email"));
                    contato.setEndereco(rs.getString("endereco"));
                    contato.setSexo(rs.getString("sexo"));
                    contato.setCelular(rs.getString("celular"));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }

    public void altera(Contato contato) throws SQLException {
        String sql = "UPDATE contatos SET endereco = ? WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, contato.getEndereco());
            stmt.setLong(2, contato.getId());
            stmt.executeUpdate();
        }
    }

    public void remove(Long id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
