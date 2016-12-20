package com.leon.fgf.compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Player;
import com.leon.fgf.util.PlayerUtil;

/**
 * 牌型判断比较器，负责对所有玩家的牌大小进行计算和排序
 * 
 * @author Leon
 *
 */
public class PlayerComparator implements Comparator<Player> {

	private TypeValueSetter recognizer;

	public PlayerComparator(ValueCalculator calculator) {
		this.recognizer = new TypeValueSetter(calculator);
	}

	/**
	 * 对玩家牌型进行牌型识别和牌值计算
	 * @param player 三张牌没有按牌面大小从大到小排好序的Player
	 */
	public void setupUnsortedPlayer(Player player) {
		PlayerUtil.sortPlayer(player);
		recognizer.regPlayerType(player);
	}

	/**
	 * 对玩家牌型进行牌型识别和牌值计算
	 * @param player 三张牌已经按牌面大小从大到小排好序的Player
	 */
	public void setupSortedPlayer(Player player) {
		recognizer.regPlayerType(player);
	}

	/**
	 * 对玩家列表进行牌型判断、值获取及排序
	 * 每副牌都的三张牌已经按照数字从大到小排序
	 * @param playersInput 一组牌
	 */
	public void sortRegularPlayers(List<Player> playersInput) {
		for (Player player : playersInput) {
			recognizer.regPlayerType(player);
		}
		Collections.sort(playersInput, this);
		Collections.reverse(playersInput);
	}
	
	/**
	 * 对玩家列表进行牌型判断、值获取及排序
	 * 每副牌的三张牌没有按照从大到小排序
	 * @param playersInput 一组牌
	 */
	public void sortUnRegularPlayers(List<Player> playersInput) {
		for (Player player : playersInput) {
			PlayerUtil.sortPlayer(player);
			recognizer.regPlayerType(player);
		}
		Collections.sort(playersInput, this);
		Collections.reverse(playersInput);
	}

	@Override
	public int compare(Player player1, Player player2) {
		return Integer.valueOf(player1.getValue()).compareTo(Integer.valueOf(player2.getValue()));
	}
}