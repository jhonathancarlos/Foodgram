package Foodgram.dao;

import Foodgram.bean.Avaliacao;
import Foodgram.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AvaliacaoDAOImpl implements AvaliacaoDAO {
    ConexaoFactory conexaoFactory = new ConexaoFactory();
    Connection connection = conexaoFactory.conectar();

    @Override
    public Avaliacao buscarAvaliacaoPorId(int id) {
        String sql = "SELECT * FROM avaliacao WHERE id = ?";
        Avaliacao avaliacao = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    avaliacao = new Avaliacao();
                    avaliacao.setId(rs.getInt("id"));
                    avaliacao.setDescricao(rs.getString("descricao"));
                    avaliacao.setEstrela(rs.getFloat("estrela"));
                    avaliacao.setId_Cliente(rs.getInt("id_cliente"));
                    avaliacao.setId_Publicacao(rs.getInt("id_publicacao"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avaliacao;
    }

    @Override
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        String sql = "INSERT INTO avaliacao (id, descricao, estrela, id_cliente, id_publicacao) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getId());
            stmt.setString(2, avaliacao.getDescricao());
            stmt.setFloat(3, avaliacao.getEstrela());
            stmt.setInt(4, avaliacao.getId_Cliente());
            stmt.setInt(5, avaliacao.getId_Publicacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarAvaliacao(Avaliacao avaliacao) {
        String sql = "UPDATE avaliacao SET descricao = ?, estrela = ?, id_cliente = ?, id_publicacao = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, avaliacao.getDescricao());
            stmt.setFloat(2, avaliacao.getEstrela());
            stmt.setInt(3, avaliacao.getId_Cliente());
            stmt.setInt(4, avaliacao.getId_Publicacao());
            stmt.setInt(5, avaliacao.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerAvaliacao(Avaliacao avaliacao) {
        String sql = "DELETE FROM avaliacao WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Avaliacao> buscarAvaliacoesPorClienteId(int Id_Cliente) {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        String query = "SELECT * FROM avaliacao WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Id_Cliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setDescricao(rs.getString("descricao"));
                avaliacao.setEstrela(rs.getFloat("estrelas"));
                avaliacao.setId_Cliente(rs.getInt("id_cliente"));
                avaliacao.setId_Publicacao(rs.getInt("id_publicacao"));
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avaliacoes;
    }
}
