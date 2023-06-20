package Foodgram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Foodgram.bean.Empresa;
import Foodgram.factory.ConexaoFactory;

public class EmpresaDAOImpl implements EmpresaDAO {
	ConexaoFactory conexaoFactory = new ConexaoFactory();
    Connection connection = conexaoFactory.conectar();
    
    @Override
    public void adicionarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresa (id, nome, email, senha, registro, telefone) VALUES (?, ?, ?, ?, ?, ?)";
                
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, empresa.getId());
            pstmt.setString(2, empresa.getNome());
            pstmt.setString(3, empresa.getEmail());
            pstmt.setString(4, empresa.getSenha());
            pstmt.setString(5, empresa.getRegistro());
            pstmt.setString(6, empresa.getTelefone());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empresa buscarEmpresaPorEmail(String email) {
        String sql = "SELECT * FROM empresa WHERE email = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empresa empresa = null;
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setEmail(rs.getString("email"));
                empresa.setSenha(rs.getString("senha"));
                empresa.setRegistro(rs.getString("registro"));
                empresa.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empresa;
    }

    @Override
    public void atualizarEmpresa(Empresa empresa) {
        String sql = "UPDATE empresa SET nome = ?, email = ?, senha = ?, registro = ?, telefone = ? WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getRegistro());
            stmt.setString(5, empresa.getTelefone());
            stmt.setInt(6, empresa.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerEmpresa(Empresa empresa) {
        String sql = "DELETE FROM empresa WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, empresa.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
