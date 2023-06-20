package Foodgram.dao;

import Foodgram.bean.Empresa;

public interface EmpresaDAO {
    Empresa buscarEmpresaPorEmail(String email);
    void adicionarEmpresa(Empresa empresa);
    void atualizarEmpresa(Empresa empresa);
    void removerEmpresa(Empresa empresa);
}
