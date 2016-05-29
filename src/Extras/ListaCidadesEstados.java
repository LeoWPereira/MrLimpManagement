package Extras;

public class ListaCidadesEstados
{
	String[] estados = {"  ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
			"PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
	
	String[] cidades = {};
	
	public ListaCidadesEstados() { }
	
	public String[] getListaEstados() { return estados; }
	
	public String[] getCidadesPorEstado() { return cidades; }
}
