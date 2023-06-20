package Foodgram.dao;

import java.util.List;

import Foodgram.bean.Produto;

public interface ProdutoDAO {
	Produto buscarProdutoPorId(int id);
    void adicionarProduto(Produto produto);
    void atualizarProduto(Produto produto);
    void removerProduto(Produto produto);
	List<Produto> buscarProdutosPorEmpresaId(int Id_Empresa);
}
