package com.leon.fgf.calculator.impl;

import com.leon.fgf.calculator.PlayerType;
import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Player;

/**
 * 花色不参与牌大小比较的计算器 牌值越大，牌越大
 * 
 * @author Leon
 *
 */
public class NonFlowerValueCalculator implements ValueCalculator {

	// 获取炸弹牌值绝对大小
	public int getBombValue(Player player) {
		return player.cards[0].getNumber() + PlayerType.STRAIGHT_FLUSH_MAX_VALUE;
	}

	// 获取同花顺牌值绝对大小,A32也是同花顺，是最小的同花顺(参考自百度百科)
	public int getStraightFlushValue(Player player) {
		if (player.isA32()) {
			//此时A就等于是1
			return 1 + PlayerType.FLUSH_MAX_VALUE;
		}
		return player.cards[2].getNumber() + PlayerType.FLUSH_MAX_VALUE;
	}

	// 获取同花牌值绝对大小
	public int getFlushValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber()
				+ PlayerType.STRAIGHT_MAX_VALUE;
	}

	// 获取顺子牌值绝对大小
	public int getStraightValue(Player player) {
		if (player.isA32()) {
			//此时A就等于是1
			return 1 + PlayerType.DOUBLE_MAX_VALUE;
		}
		return player.cards[2].getNumber() + PlayerType.DOUBLE_MAX_VALUE;
	}

	// 获取对子牌值绝对大小
	// 在判断牌型时，如果是对子，则将对子放在数组前面两位
	public int getDoubleValue(Player player) {
		return player.cards[1].getNumber() * 16 + player.cards[2].getNumber() + PlayerType.NORMAL_MAX_VALUE;
	}

	// 获取普通牌值绝对大小
	public int getNormalValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber();
	}

}