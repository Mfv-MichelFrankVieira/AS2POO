package CafedaEsquina;

import java.io.Serializable;

public class SolIfood extends Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String taxaEntrega;
	
	public SolIfood(String nomeCliente, int qtdeBebidas, int qtdeSalgados, String gorjeta, String taxaEntrega) {
		super(nomeCliente, qtdeBebidas, qtdeSalgados);
		this.tipodoPedido = "IFood";
		this.taxaEntrega = "5% do valor do pedido.";
		}
	public String gorjeta() {
		return "SIM";
	}
	public String getTaxaEntrega() {
		return taxaEntrega;
	}
	public void setTaxaEntrega(String taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}
	public String toString() {
		String retorno = super.toString();
		retorno += "Add taxa do boy: " + this.taxaEntrega + "\n";
		return retorno;
	}
}

