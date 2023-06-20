package Foodgram.dao;

import Foodgram.bean.Cliente;

public interface ClienteDAO {
	Cliente buscarClientePorEmail(String Email);
    void adicionarCliente(Cliente cliente);
    void atualizarCliente(Cliente cliente);
    void removerCliente(Cliente cliente);
}