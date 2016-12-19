package com.leon.fgf.compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leon.fgf.entity.Player;

/**
 * 牌型判断比较器，负责对所有玩家的牌大小进行计算和排序
 * 
 * @author Leon
 *
 */
public class PlayerComparator implements Comparator<Player> {

	private ValueCalculator calculator = new ValueCalculator();

	public void setupPlayer(Player player) {
		calculator.setupPlayer(player);
	}

	/**
	 * 对玩家列表进行牌型判断、值获取及排序
	 * 
	 * @param playersInput
	 */
	public void sortPlayers(List<Player> playersInput) {
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