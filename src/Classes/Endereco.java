package Classes;

public class Endereco
{
    private String cep;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String estado;
    private int numero;

    public Endereco() { }
	
    public void setCep(String _cep) {this.cep = _cep; }
	
    public String getCep() {return this.cep; }
	
    public void setBairro(String _bairro) {this.bairro = _bairro; }
	
    public String getBairro() {return this.bairro; }
	
    public void setCidade(String _cidade) {this.cidade = _cidade; }
	
    public String getCidade() {return this.cidade; }
	
    public void setLogradouro(String _logradouro) {this.logradouro = _logradouro; }
	
    public String getLogradouro() {return this.logradouro; }
	
    public void setEstado(String _estado) {this.estado = _estado; }
	
    public String getEstado() {return this.estado; }
	
    public void setNumero(int _numero) {this.numero = _numero; }
	
    public int getNumero() {return this.numero; }
}