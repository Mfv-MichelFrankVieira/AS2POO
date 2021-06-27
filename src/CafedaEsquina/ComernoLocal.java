package CafedaEsquina;

import java.io.Serializable;

public class ComernoLocal extends Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sobremesaComDesconto;
	public String gorjeta() {
		return "10% do valor para gorjetas";
	}
	
	public ComernoLocal(String nomeCliente, int qtdeBebidas, int qtdeSalgados, String gorjeta, String sobremesaComDesconto) {
		super(nomeCliente, qtdeBebidas, qtdeSalgados);
		this.tipodoPedido = "Comer no local";
		this.sobremesaComDesconto = "50% em sobremesas.";
		}

	public String getSobremesaComDesconto() {
		return sobremesaComDesconto;
	}

	public void setSobremesaComDesconto(String sobremesaComDesconto) {
		this.sobremesaComDesconto = sobremesaComDesconto;
	}
	public String toString() {
		String retorno = super.toString();
		retorno += "Desconto de " + this.sobremesaComDesconto + "\n";
		return retorno;
	}
}
