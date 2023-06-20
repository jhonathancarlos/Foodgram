package Foodgram.dao;

import java.util.List;

import Foodgram.bean.Avaliacao;

public interface AvaliacaoDAO {
	Avaliacao buscarAvaliacaoPorId(int id);
    void adicionarAvaliacao(Avaliacao avaliacao);
    void atualizarAvaliacao(Avaliacao avaliacao);
    void removerAvaliacao(Avaliacao avaliacao);
	List<Avaliacao> buscarAvaliacoesPorClienteId(int Id_Cliente);
}
