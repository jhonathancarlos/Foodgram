package Foodgram.dao;

import Foodgram.bean.Produto;
import Foodgram.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAOImpl implements ProdutoDAO {
    ConexaoFactory conexaoFactory = new ConexaoFactory();
    Connection connection = conexaoFactory.conectar();

    @Override
    public Produto buscarProdutoPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getInt("Id"));
                    produto.setDescricao(rs.getString("Descricao"));
                    produto.setValor(rs.getFloat("Valor"));
                    produto.setId_Empresa(rs.getInt("Id_Empresa"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produto (id, descricao, valor, id_empresa) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getDescricao());
            stmt.setFloat(3, produto.getValor());
            stmt.setInt(4, produto.getId_Empresa());

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
    	}
    }
    
    @Override
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET descricao = ?, valor = ?, id_empresa = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricao());
            stmt.setFloat(2, produto.getValor());
            stmt.setInt(3, produto.getId_Empresa());
            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerProduto(Produto produto) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Produto> buscarProdutosPorEmpresaId(int Id_Empresa) {
		List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM produto WHERE id_empresa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Id_Empresa);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
                produto.setId_Empresa(rs.getInt("id_empresa"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return produtos;
	}
}
