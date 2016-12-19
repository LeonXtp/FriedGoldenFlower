package com.leon.fgf;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 牌型判断比较器，负责对所有玩家的牌大小进行计算和排序
 * 
 * @author Leon
 *
 */
public class PlayerJuger implements Comparator<Player> {

	private ValueCalculator calculator = new ValueCalculator();

	public void judgePlayer(Player player) {
		calculator.setupPlayer(player);
	}

	public void sort(List<Player> playersInput) {
		for (Player player : playersInput) {
			calculator.setupPlayer(player);
		}
		Collections.sort(playersInput, this);
		Collections.reverse(playersInput);
	}

	@Override
	public int compare(Player player1, Player player2) {
		return Integer.valueOf(player1.getValue()).compareTo(Integer.valueOf(player2.getValue()));
	}

}