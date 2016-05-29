package DAOs;

import BancoDeDados.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DAOCliente
{
    Connection con = (Connection) Conexao.conectaAoBanco();
    
    public String bancoDoServidor;
    public String tabelaDeClientes;
    
    public DAOCliente (String _banco, String _tabCliente)
    {
    	bancoDoServidor = _banco;
    	tabelaDeClientes = _tabCliente;
    }
    
    public boolean verifica(Statement stm, String nome) throws SQLException
    {
        ResultSet resultSet = (ResultSet) stm.executeQuery("SELECT c.nome " + "FROM " + bancoDoServidor + "." +tabelaDeClientes + " c " + "WHERE c.nome = '" + nome + "'");
        
        if (resultSet.next())
            return true;
        
        else
            return false;
    }
    
	public List carregaJListClienteFisico(Statement stm) throws SQLException
    {
        ResultSet rs = stm.executeQuery("SELECT c.nome " + "FROM " + bancoDoServidor + "." + tabelaDeClientes + " c " + "WHERE c.cliente_fisico = 1 ORDER BY nome");  
    
        List lista = new ArrayList(); // Preenche arraylist com nomes  
        
        while (rs.next()) { lista.add(rs.getString(1)); }
        
        return lista;
    }
    
    public List carregaJListClienteJuridico(Statement stm) throws SQLException
    {
        ResultSet rs = stm.executeQuery("SELECT c.nome " + "FROM " + bancoDoServidor + "." + tabelaDeClientes + " c " + "WHERE c.cliente_fisico = 0 ORDER BY nome");  
    
        List lista = new ArrayList(); // Preenche arraylist com nomes
        
        while (rs.next()) { lista.add(rs.getString(1)); }
        
        return lista;
    }
    
    public void adicionar(Statement stm, String nome, String rg, String cpf, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj, int cliente_fisico) throws SQLException
    {        
        if (verifica(stm, nome) == false)
            stm.execute("INSERT INTO " + bancoDoServidor + "." + tabelaDeClientes + "(nome,rg,cpf,Observacoes,telefone,celular,email,cep,bairro,cidade,logradouro,complemento,estado,numero,cnpj,cliente_fisico) VALUES"
                    + " ('"+nome+"','"+rg+"', '"+cpf+"', '"+observacoes+"', '"+telefone+"', '"+celular+"', '"+email+"', '"+cep+"', '"+bairro+"', '"+cidade+"', '"+logradouro+"', '"+complemento+"', '"+estado+"', '"+numero+"', '"+cnpj+"', '"+cliente_fisico+"')"); 
    }
	
    public void alterar(Statement stm, String nome_anterior, String nome, String rg, String cpf, String observacoes, String telefone, String celular, String email, String cep, String bairro, String cidade, String logradouro, String complemento, String estado, String numero, String cnpj) throws SQLException
    {      
        stm.execute("UPDATE " + bancoDoServidor + "." + tabelaDeClientes + " SET nome='" + nome + "',rg='" + rg + "',cpf='" + cpf + "',Observacoes='" + observacoes + "',telefone='" + telefone + "',celular='" + celular + "',email='" + email + "',cep='" + cep + "',bairro='" + bairro + "',cidade='" + cidade + "',logradouro='" + logradouro + "',complemento='" + complemento + "',estado='" + estado + "',numero='" + numero + "',cnpj='" + cnpj + "' WHERE nome = '" + nome_anterior + "'"); 
    }
	
    public ResultSet consultar(Statement stm, String nome) throws SQLException
    {
    	ResultSet rs = stm.executeQuery("SELECT c.* FROM " + bancoDoServidor + "." + tabelaDeClientes + " c WHERE c.nome = '" + nome + "'");
        
        return rs;
    }
	
    public void excluir(Statement stm, String nome) throws SQLException
    {
    	stm.execute("DELETE FROM " + bancoDoServidor + "." + tabelaDeClientes + " WHERE nome = '" + nome + "'");
    }
}
