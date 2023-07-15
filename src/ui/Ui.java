package ui;

import java.util.Scanner;

import formato.Jogo;
import player.Player;

public class Ui {
	Scanner sc = new Scanner(System.in);
	Jogo jogo = new Jogo();
	Player p1 = new Player("Player 1", "x");
	Player p2 = new Player("Player 2", "o");

	public void menu() {
		System.out.println("1- Começar jogo");
		System.out.println("2- Muda nome p1");
		System.out.println("3- Muda nome p2");
		System.out.println("4- Ver tabuleiro");
		funcoesMenu(sc.nextLine());
	}

	public void funcoesMenu(String escolha) {
		System.out.println();
		switch (escolha) {
		case "1": {
			int qntPartidas = 0;
			String continuar = "";
			do {
				iniciaJogo(qntPartidas);
				continuar = sc.nextLine();
				qntPartidas++;
			} while (continuar.equalsIgnoreCase("continue"));
			break;
		}

		case "2": {
			System.out.print("Nome do Player 1: ");
			p1.setNome(sc.nextLine());
			break;
		}

		case "3": {
			System.out.print("Nome do Player 2: ");
			p2.setNome(sc.nextLine());
			break;
		}

		case "4": {
			jogo.printDeInicio();
			break;

		}
		}
		if (!escolha.equals("1"))
			menu();
	}

	public void iniciaJogo(int qntPartidas) {
		System.out.println("Jogo iniciando...\n");
		if (qntPartidas % 2 == 0) {
			jogo.jogoAcontece(p1, p2);
		} else {
			jogo.jogoAcontece(p2, p1);
		}
		System.out.println("Players: \n" + p1 + "\n" + p2);
		System.out.println("Para continuar, digite (continue)");
	}
}
