package formato;

import player.Player;

public class Casa {
	private Player player;
	private String nomeCasa;

	public Casa(Player player, String nomeCasa) {
		this.player = player;
		this.nomeCasa = nomeCasa;
	}

	public Casa() {

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getNomeCasa() {
		return nomeCasa;
	}
}
