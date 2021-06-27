package CafedaEsquina;

import java.io.Serializable;

public abstract class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nomeCliente;
	private   int qtdeBebidas;
	private   int qtdeSalgados;
	protected String tipodoPedido;
	
	public Pedidos(String nomeCliente, int qtdeBebidas, int qtdeSalgados) {
		this.nomeCliente = nomeCliente;
		this.qtdeBebidas = qtdeBebidas;
		this.qtdeSalgados = qtdeSalgados;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome do cliente: "     + this.nomeCliente     + "\n";
		retorno += "Quantidade de bebida: "    + this.qtdeBebidas    + " anos\n";
		retorno += "Quantidade de salgados: "     + this.qtdeSalgados     + "\n";
		retorno += "Tipo do pedido: "  + this.tipodoPedido  + "\n";
		retorno += "Taxas adicionais "  + gorjeta()  + "\n";
		return retorno;
	}
	public abstract String gorjeta();
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getQtdeBebidas() {
		return qtdeBebidas;
	}
	public void setQtdeBebidas(int qtdeBebidas) {
		this.qtdeBebidas = qtdeBebidas;
	}
	public int getQtdeSalgados() {
		return qtdeSalgados;
	}
	public void setQtdeSalgados(int qtdeSalgados) {
		this.qtdeSalgados = qtdeSalgados;
	}
}
