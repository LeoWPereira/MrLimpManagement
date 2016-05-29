package Controllers;

import DAOs.DAOFornecedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CtrlFornecedor
{
    DAOFornecedor dao = new DAOFornecedor("engenharia304", "Fornecedor");
    
    public List carregaJListFornecedor(Statement stm) throws SQLException
    {
        return dao.carregaJListFornecedor(stm);
    }
    
    public void adicionar(Statement stm, String nome, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {
    	dao.adicionar(stm, nome, observacoes, telefone, celular, email, cep, bairro, cidade, logradouro, complemento, estado, numero, cnpj);
    }
	
    public void alterar(Statement stm, String nome_anterior, String nome, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {
    	dao.alterar(stm, nome_anterior, nome, observacoes, telefone, celular, email, cep, bairro, cidade, logradouro, complemento, estado, numero, cnpj);
    }
	
    public ResultSet consultar(Statement stm, String nome) throws SQLException
    {
    	return dao.consultar(stm, nome);
    }
	
    public void excluir(Statement stm, String nome) throws SQLException
    {
    	dao.excluir(stm, nome);
    }
}
