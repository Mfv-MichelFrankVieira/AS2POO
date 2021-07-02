package CafedaEsquina;

import java.io.Serializable;

public class ParaaViagem extends Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String embalagem;
	public String gorjeta() {
		return "Adicionar 10% para o motoBoy.";
	}
	
	
	
	public ParaaViagem(String nomeCliente, int qtdeBebidas, int qtdeSalgados, String gorjeta, String embalagem) {
		super(nomeCliente, qtdeBebidas, qtdeSalgados);
		this.tipodoPedido = "Para a viagem.";
		this.embalagem = "";
	}
	
	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	public String toString() {
		String retorno = super.toString();
		retorno += "Embalar itens! " + this.embalagem + "\n";
		return retorno;
	}
	
}	
