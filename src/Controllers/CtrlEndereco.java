package Controllers;

import BancoDeDados.CepWebService;
import Classes.Endereco;

public class CtrlEndereco extends Endereco
{
    public void verificarCEP(String cep)
    {
        try
        {
            CepWebService cws = new CepWebService(cep);
            
            if(cws.getResultado() == 1)
            {
                setLogradouro(cws.getLogradouro());
                setBairro(cws.getBairro());
                setCidade(cws.getCidade());
                setEstado(cws.getEstado());
            }
        }
        catch(Exception e) {  }
    }
}
