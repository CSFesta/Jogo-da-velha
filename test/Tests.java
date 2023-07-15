import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formato.Casa;
import formato.Jogo;
import player.Player;

class Tests {

	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private Player p5;
	private Casa casa = new Casa();
	private Jogo jogo = new Jogo();
	private List<Casa> casas = new ArrayList<>();

	@BeforeEach
	public void setUp1() {
		Player p0 = new Player("player0", "_");
		p1 = new Player("Cauã", "1");
		p2 = new Player("Festa", "2");
		p3 = new Player("Otton", "3");
		p4 = new Player("Anana", "4");
		p5 = new Player("Murlo", "5");

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

	@Test
	public void testVerificaJogadaValida() {
		assertEquals(true, jogo.verificaJogadaValida("A  3"));
	}

	@Test
	public void testVerificaVitoria1() {
		// 0 1 2
		// 3 4 5
		// 6 7 8
		jogo.atualizaCasa("a1", p1);
		jogo.atualizaCasa("b2", p1);
		jogo.atualizaCasa("c3", p1);
		assertEquals(true, jogo.variaveisDeVitoria(5));
	}

	@Test
	public void testVerificaVitoria2() {
		// 0 1 2
		// 3 4 5
		// 6 7 8
		jogo.atualizaCasa("a1", p1);
		jogo.atualizaCasa("a2", p1);
		jogo.atualizaCasa("b3", p1);
		assertEquals(false, jogo.variaveisDeVitoria(5));
	}

	@Test
	public void testVerificaVitoria3() {
		// 0 1 2
		// 3 4 5
		// 6 7 8
		jogo.atualizaCasa("a2", p1);
		jogo.atualizaCasa("b2", p1);
		jogo.atualizaCasa("c2", p1);

		assertEquals(true, jogo.variaveisDeVitoria(5));
	}
	
	@Test
	public void testVerificaVitoria4() {
		// 0 1 2
		// 3 4 5
		// 6 7 8
		jogo.atualizaCasa("b1", p1);
		jogo.atualizaCasa("b2", p1);
		jogo.atualizaCasa("b3", p1);

		assertEquals(true, jogo.variaveisDeVitoria(5));
	}

}
