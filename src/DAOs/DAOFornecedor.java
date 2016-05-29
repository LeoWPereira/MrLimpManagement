package DAOs;

import BancoDeDados.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DAOFornecedor
{
    Connection con = (Connection) Conexao.conectaAoBanco();
    
    public String bancoDoServidor;
    public String tabelaDeFornecedores;
    
    public DAOFornecedor (String _banco, String _tabForn)
    {
    	bancoDoServidor = _banco;
    	tabelaDeFornecedores = _tabForn;
    }
    
    public boolean verifica(Statement stm, String nome) throws SQLException
    {
        ResultSet resultSet = (ResultSet) stm.executeQuery("SELECT f.nome FROM " + bancoDoServidor + "." + tabelaDeFornecedores + " f WHERE f.nome = '" + nome + "'");
        
        if (resultSet.next())
            return true;
        
        else
            return false;
    }
   
	public List carregaJListFornecedor(Statement stm) throws SQLException
    {
        ResultSet rs = stm.executeQuery("SELECT f.nome FROM " + bancoDoServidor + "." + tabelaDeFornecedores + " f ORDER BY nome");  
    
        List lista = new ArrayList(); // Preenche arraylist com nomes
        
        while (rs.next()) { lista.add(rs.getString(1)); }
        
        return lista;
    }
    
    public void adicionar(Statement stm, String nome, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {        
        if (verifica(stm, nome) == false)
            stm.execute("INSERT INTO " + bancoDoServidor + "." + tabelaDeFornecedores + "(nome,Observacoes,telefone,celular,email,cep,bairro,cidade,logradouro,complemento,estado,numero,cnpj) VALUES"
                    + " ('" + nome + "', '" + observacoes + "', '" + telefone + "', '" + celular + "', '" + email + "', '" + cep + "', '" + bairro + "', '" + cidade + "', '" + logradouro + "', '" + complemento + "', '" + estado + "', '" + numero + "', '" + cnpj + "')"); 
    }
	
    public void alterar(Statement stm, String nome_anterior,String nome, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {      
        stm.execute("UPDATE " + bancoDoServidor + "." + tabelaDeFornecedores + " SET nome='" + nome + "',Observacoes='" + observacoes + "',telefone='" + telefone + "',celular='" + celular + "',email='" + email + "',cep='" + cep + "',bairro='" + bairro + "',cidade='" + cidade + "',logradouro='" + logradouro + "',complemento='" + complemento + "',estado='" + estado + "',numero='" + numero + "',cnpj='" + cnpj + "' where nome = '" + nome_anterior + "'"); 
    }
	
    public ResultSet consultar(Statement stm, String nome) throws SQLException
    {
    	ResultSet rs = stm.executeQuery("SELECT f.* FROM " + bancoDoServidor + "." + tabelaDeFornecedores + " f WHERE f.nome = '" + nome + "'");
        
        return rs;
    }
	
    public void excluir(Statement stm, String nome) throws SQLException
    {
    	stm.execute("DELETE FROM " + bancoDoServidor + "." + tabelaDeFornecedores + " WHERE nome = '" + nome + "'");
    }
}
