package Foodgram.dao;

import Foodgram.bean.Cliente;
import Foodgram.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAOImpl implements ClienteDAO {
	ConexaoFactory conexaoFactory = new ConexaoFactory();
    Connection connection = conexaoFactory.conectar();
    
    @Override
    public void adicionarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (id, nome, email, senha, registro, telefone) VALUES (?, ?, ?, ?, ?, ?)";
                
        try {
        	PreparedStatement pstmt = connection.prepareStatement(sql);
        	pstmt.setInt(1, cliente.getId());
        	pstmt.setString(2, cliente.getNome());
        	pstmt.setString(3, cliente.getEmail());
        	pstmt.setString(4, cliente.getSenha());
        	pstmt.setString(5, cliente.getRegistro());
        	pstmt.setString(6, cliente.getTelefone());
        	pstmt.executeUpdate();
        	pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Cliente buscarClientePorEmail(String email) {
    	String sql = "SELECT * FROM cliente WHERE email = ?";
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	Cliente cliente = null;
    	
    	try {
    		stmt = connection.prepareStatement(sql);
    		stmt.setString(1, email);
    		rs = stmt.executeQuery();
    		
    		if(rs.next()) {
    			cliente = new Cliente();
    			cliente.setId(rs.getInt("id"));
    			cliente.setNome(rs.getString("nome"));
    			cliente.setEmail(rs.getString("email"));
    			cliente.setSenha(rs.getString("senha"));
    			cliente.setRegistro(rs.getString("registro"));
    			cliente.setTelefone(rs.getString("telefone"));
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
    	}
    	
    	return cliente;
    }

	@Override
	public void atualizarCliente(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ?, registro = ?, telefone = ? WHERE id = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getSenha());
			stmt.setString(4, cliente.getRegistro());
			stmt.setString(5, cliente.getTelefone());
			stmt.setInt(6, cliente.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerCliente(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE id = ?";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, cliente.getId());

	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
    
    
}
