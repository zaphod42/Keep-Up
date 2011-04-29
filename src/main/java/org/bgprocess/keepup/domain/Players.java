package org.bgprocess.keepup.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
	public List<Player> players = new ArrayList<Player>();

	public synchronized int add(Player player) {
		players.add(player);
		return players.size() - 1;
	}

	public Player get(int id) {
		return players.get(id);
	}
}
