package Foodgram.dao;

import Foodgram.factory.ConexaoFactory;
import Foodgram.bean.Publicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PublicacaoDAOImpl implements PublicacaoDAO {
    private ConexaoFactory conexaoFactory;

    public PublicacaoDAOImpl() {
        conexaoFactory = new ConexaoFactory();
    }

    @Override
    public Publicacao buscarPublicacaoPorId(int id) {
        String sql = "SELECT * FROM publicacao WHERE id = ?";

        try (Connection connection = conexaoFactory.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Publicacao publicacao = new Publicacao();
                publicacao.setId(rs.getInt("id"));
                publicacao.setDescricao(rs.getString("descricao"));
                publicacao.setId_Produto(rs.getInt("id_produto"));
                publicacao.setId_Empresa(rs.getInt("id_empresa"));

                return publicacao;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void adicionarPublicacao(Publicacao publicacao) {
        String sql = "INSERT INTO publicacao (descricao, id_produto, id_empresa) VALUES (?, ?, ?)";

        try (Connection connection = conexaoFactory.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, publicacao.getDescricao());
            ps.setInt(2, publicacao.getId_Produto());
            ps.setInt(3, publicacao.getId_Empresa());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarPublicacao(Publicacao publicacao) {
        String sql = "UPDATE publicacao SET descricao = ?, id_produto = ?, id_empresa = ? WHERE id = ?";

        try (Connection conexao = conexaoFactory.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, publicacao.getDescricao());
            ps.setInt(2, publicacao.getId_Produto());
            ps.setInt(3, publicacao.getId_Empresa());
            ps.setInt(4, publicacao.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerPublicacao(Publicacao publicacao) {
        String sql = "DELETE FROM publicacao WHERE id = ?";

        try (Connection conexao = conexaoFactory.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, publicacao.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Publicacao> buscarPublicacoesPorEmpresaId(int Id_Empresa) {
        List<Publicacao> publicacoes = new ArrayList<>();
        String sql = "SELECT * FROM publicacao WHERE id_empresa = ?";
 
		try (Connection connection = conexaoFactory.conectar();
			PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, Id_Empresa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Publicacao publicacao = new Publicacao();
                publicacao.setId(rs.getInt("id"));
                publicacao.setDescricao(rs.getString("descricao"));
                publicacao.setId_Produto(rs.getInt("id_produto"));
                publicacao.setId_Empresa(rs.getInt("id_empresa"));
                publicacoes.add(publicacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publicacoes;
    }
}
