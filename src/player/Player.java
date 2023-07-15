package player;

import java.util.Scanner;

public class Player {

	private String nome;
	private String simbolo;
	private int pontos;

	public Player(String nome, String simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos() {
		this.pontos += 1;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getsimbolo() {
		return simbolo + " ";
	}

	public String msgJogue() {
		System.out.print(nome + ", sua vez de jogar: ");
		return new Scanner(System.in).nextLine();
	}

	public void msgGanhou() {
		System.out.println(nome + " Venceu a partida!");
	}

	public void msgEmpate() {
		System.out.println("A partida empatou!");
	}

	public String toString() {
		return "Nome: " + nome + "\tSimbolo: " + simbolo + "\tPontos: " + pontos;
	}
}
