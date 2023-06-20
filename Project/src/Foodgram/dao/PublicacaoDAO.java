package Foodgram.dao;

import java.util.List;

import Foodgram.bean.Publicacao;

public interface PublicacaoDAO {
	Publicacao buscarPublicacaoPorId(int id);
    void adicionarPublicacao(Publicacao publicacao);
    void atualizarPublicacao(Publicacao publicacao);
    void removerPublicacao(Publicacao publicacao);
	List<Publicacao> buscarPublicacoesPorEmpresaId(int Id_empresa);
}
