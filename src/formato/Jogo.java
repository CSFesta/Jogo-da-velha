package formato;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public class Jogo {
	private List<Casa> casas = new ArrayList<>();
	private String[] linhas = { "a", "b", "c" };
	private Player p0 = new Player("player0", "_");

	public Jogo() { //inicializa todas as casa com o player0 
		casas.add(new Casa(p0, "a1")); 
		casas.add(new Casa(p0, "a2"));
		casas.add(new Casa(p0, "a3"));
		casas.add(new Casa(p0, "b1"));
		casas.add(new Casa(p0, "b2"));
		casas.add(new Casa(p0, "b3"));
		casas.add(new Casa(p0, "c1"));
		casas.add(new Casa(p0, "c2"));
		casas.add(new Casa(p0, "c3"));
	}

	public void printDeInicio() {
		for (int i = 0; i < casas.size(); i++) {
			if ((i + 1) % 3 == 0)
				System.out.println(casas.get(i).getNomeCasa());
			else
				System.out.print(casas.get(i).getNomeCasa() + " ");
		}
		System.out.println();
	}

	public void printaJogo() {
		int cont1 = 1;
		int cont2 = 0;
		System.out.println("1  2  3");
		for (Casa j : casas) {
			if (cont1++ % 3 == 0) {
				System.out.print(j.getPlayer().getsimbolo());
				System.out.println("  " + linhas[cont2++]);
			} else
				System.out.print(j.getPlayer().getsimbolo() + " ");
		}
		System.out.println();
	}

	public void posJogo(Player p1) {
		p1.msgGanhou();
		p1.setPontos();
	}

	public void atualizaCasa(String casaJogada, Player p1) {
		for (int i = 0; i < casas.size(); i++)
			if (casaJogada.equals(casas.get(i).getNomeCasa()) && casas.get(i).getPlayer().getNome().equals("player0"))
				casas.get(i).setPlayer(p1);
	}

	public void resetaCasas() {
		for (Casa i : casas)
			i.setPlayer(p0);
	}

	public void jogoAcontece(Player p1, Player p2) {
		resetaCasas();
		int cont = 0;
		while (variaveisDeVitoria(cont) == false) {
			if (cont == 9) {
				p1.msgEmpate();
				break;
			}
			if (cont % 2 == 0) //verificar de qm é a vez
				realizaJogada(p1.msgJogue(), p1);
			else
				realizaJogada(p2.msgJogue(), p2);
			cont++;
		}
	}

	public void realizaJogada(String casaJogada, Player p1) {
		while (verificaJogadaValida(casaJogada) == false)
			casaJogada = p1.msgJogue();
		atualizaCasa(casaJogada, p1);
		printaJogo();
	}

	public boolean verificaJogadaValida(String casaJogada) {
		casaJogada = casaJogada.replace(" ", "").toLowerCase();
		for (int i = 0; i < casas.size(); i++)
			if (casaJogada.equals(casas.get(i).getNomeCasa()) && casas.get(i).getPlayer().equals(p0))
				return true;
		return false;
	}

	public boolean verificaVitoria(int casa1, int casa2, int casa3) {
		if (!casas.get(casa1).getPlayer().equals(p0)//para n dar vitoria para o p0
				&& casas.get(casa1).getPlayer().equals(casas.get(casa2).getPlayer())
				&& casas.get(casa1).getPlayer().equals(casas.get(casa3).getPlayer())) {
			posJogo(casas.get(casa1).getPlayer());
			return true;
		}
		return false;
	}

	public boolean variaveisDeVitoria(int cont) {
		if (cont >= 5) { //a partir da 5 jogada algm pode ganhar
			if (verificaVitoria(0, 1, 2) == true)
				return true;
			else if (verificaVitoria(3, 4, 5) == true)
				return true;
			else if (verificaVitoria(6, 7, 8) == true)
				return true;
			else if (verificaVitoria(0, 3, 6) == true)
				return true;
			else if (verificaVitoria(1, 4, 7) == true)
				return true;
			else if (verificaVitoria(2, 5, 8) == true)
				return true;
			else if (verificaVitoria(0, 4, 8) == true)
				return true;
			else if (verificaVitoria(2, 4, 6) == true)
				return true;
		}
		return false;

	}

}
