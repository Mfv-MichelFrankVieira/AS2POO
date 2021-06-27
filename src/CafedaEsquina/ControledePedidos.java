package CafedaEsquina;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControledePedidos {private ArrayList<Pedidos> solicitacao = new ArrayList<Pedidos>();

	public ControledePedidos() {this.solicitacao = new ArrayList<Pedidos>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public ComernoLocal leComernoLocal (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome do cliente", "Qt de Bebidas", "Qt de Salgados"};
		valores = leValores (nomeVal);

		int qtdeBebidas = this.retornaInteiro(valores[1]);
		int qtdeSalgados = this.retornaInteiro(valores[2]);
		String sobremesaComDesconto = this.toString();
		
		ComernoLocal comernoLocal = new ComernoLocal (valores[0],qtdeBebidas,qtdeSalgados, null,sobremesaComDesconto);
		return comernoLocal;
	}

	public ParaaViagem leParaaViagem (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome do cliente", "Qt de Bebidas", "Qt de Salgados"};
		valores = leValores (nomeVal);

		int qtdeBebidas = this.retornaInteiro(valores[1]);
		int qtdeSalgados = this.retornaInteiro(valores[2]);
		String embalagem = this.toString();
		
		ParaaViagem paraaViagem = new ParaaViagem (valores[0],qtdeBebidas,qtdeSalgados, null,embalagem);
		return paraaViagem;
	}
	public SolIfood leSolIfood (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome do cliente", "Qt de Bebidas", "Qt de Salgados"};
		valores = leValores (nomeVal);

		int qtdeBebidas = this.retornaInteiro(valores[1]);
		int qtdeSalgados = this.retornaInteiro(valores[2]);
		String taxaEntrega = this.toString();
		
		SolIfood SolIfood = new SolIfood (valores[0],qtdeBebidas,qtdeSalgados, null, taxaEntrega);
		return SolIfood;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); 
			return true;
		} catch (NumberFormatException e) { 
			return false;
		}
		
	}
	public int retornaInteiro(String entrada) {
		int numInt;
		
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, ""
					+ "Valor incorreto!\n\nDigite um numero inteiro.");
		}
		return Integer.parseInt(entrada);
	}
	private boolean doubleValido(String s) {
		try {
			Double.parseDouble(s); 
			return true;
		} catch (NumberFormatException e) { 
			return false;
		}
	}
	public double retornadouble(String entrada) { 
		float numFloat;

		
		while (!this.doubleValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, entrada +""
					+ "Valor incorreto!\n\nDigite um numero decimal.");
		}
		return Double.parseDouble(entrada);
	}

	public void salvaSolicitacao(ArrayList<Pedidos> solicitacao){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\PedidosdoCafe.dados"));
			for (int i=0; i < solicitacao.size(); i++)
				outputStream.writeObject(solicitacao.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Pedidos> recuperaSolicitacao(){
		ArrayList<Pedidos> solicitacaoTemp = new ArrayList<Pedidos>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\PedidosdoCafe.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Pedidos) {
					solicitacaoTemp.add((Pedidos) obj);
				}   
			}          
		} catch (EOFException ex) { 
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Não existe pedido para recuperar!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally { 
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return solicitacaoTemp;
		}
	}

	public void menuCafeteria (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Cafeteria\n" +
					"Opções:\n" + 
					"1. Fazer Pedido\n" +
					"2. Exibir Pedido\n" +
					"3. Gravar Pedido\n" +
					"4. Limpar Pedido\n" +
					"5. Recuperar Pedido\n" +
					"0. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Solicitação do Cliente\n" +
						"Opções:\n" + 
						"1. Consumo no Local.\n" +
						"2. Solicitação para Viagem.\n"+
						"3. Solicitação para Ifood.\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: solicitacao.add((Pedidos)leComernoLocal());
				break;
				case 2: solicitacao.add((Pedidos)leParaaViagem());
				break;
				case 3: solicitacao.add((Pedidos)leSolIfood());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Escolha o tipo da Solicitação:\n"
							+ "(1) Consumo no Local.\n"
							+ "(2) Solicitação para Viagem."+
							"3. Solicitação para Ifood.\n");
				}

				break;
			case 2: // Exibir dados
				if (solicitacao.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não existe pedido!");
					break;
				}
				String dados = "";
				for (int i=0; i < solicitacao.size(); i++)	{
					dados += solicitacao.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3:// Grava Dados
				if (solicitacao.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não existe pedido!");
					break;
				}
				salvaSolicitacao(solicitacao);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break; 
			case 4: // Limpar Dados
				if (solicitacao.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não existe pedido!");
					break;
				}
				solicitacao.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 5: // Recupera Dados
				solicitacao = recuperaSolicitacao();
				if (solicitacao.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para Recupera.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 0:
				JOptionPane.showMessageDialog(null,"Fim do expediente");
				break;
			}
		} while (opc1 != 0);
	}


	public static void main (String [] args){

		ControledePedidos pedido = new ControledePedidos ();
		pedido.menuCafeteria();

	}

}
