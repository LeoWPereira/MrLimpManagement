package Controllers;

import DAOs.DAOCliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CtrlCliente
{
    DAOCliente dao = new DAOCliente("engenharia304", "Cliente");
    
	public List carregaJListClienteFisico(Statement stm) throws SQLException
    {
        return dao.carregaJListClienteFisico(stm);
    }
    
    public List carregaJListClienteJuridico(Statement stm) throws SQLException
    {
        return dao.carregaJListClienteJuridico(stm);
    }
    
    public void adicionar(Statement stm, String nome, String rg, String cpf, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj, int cliente_fisico) throws SQLException
    {
    	dao.adicionar(stm, nome, rg, cpf, observacoes, telefone, celular, email, cep, bairro, cidade, logradouro, complemento, estado, numero, cnpj, cliente_fisico);
    }
	
    public void alterar(Statement stm,String nome_anterior, String nome, String rg, String cpf, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {
    	dao.alterar(stm, nome_anterior, nome, rg, cpf, observacoes, telefone, celular, email, cep, bairro, cidade, logradouro, complemento, estado, numero, cnpj);
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