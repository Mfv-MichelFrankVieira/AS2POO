package CafedaEsquina;

import java.io.Serializable;

public class ComernoLocal extends Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;

	public String gorjeta() {
		return "10% do valor do pedido";
	}
	
	public ComernoLocal(String nomeCliente, int qtdeBebidas, int qtdeSalgados, String gorjeta) {
		super(nomeCliente, qtdeBebidas, qtdeSalgados);
		this.tipodoPedido = "Comer no local";
		}
}
