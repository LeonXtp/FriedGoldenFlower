package com.leon.fgf.calculator.impl;

import com.leon.fgf.calculator.PlayerTypeLow2Heigh;
import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Player;

/**
 * 牌值越大，牌越小的计算器，并且花色参与牌大小比较
 * 
 * @author Leon
 *
 */
public class FlowerLow2HeighCalculator implements ValueCalculator {

	private int getFlowerValue(Player player) {
		return (4 - player.cards[0].getFlower()) * 16 + (4 - player.cards[1].getFlower()) * 4 + 4
				- player.cards[2].getFlower();
	}

	// 获取炸弹牌值绝对大小
	public int getBombValue(Player player) {
		return (14 - player.cards[0].getNumber()) * 64 + getFlowerValue(player);
	}

	// 获取同花顺牌值绝对大小
	public int getStraightFlushValue(Player player) {
		return (14 - player.cards[2].getNumber() + PlayerTypeLow2Heigh.BOMB_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取同花牌值绝对大小
	public int getFlushValue(Player player) {
		return ((14 - player.cards[0].getNumber()) * 256 + (14 - player.cards[1].getNumber()) * 16
				+ (14 - player.cards[2].getNumber()) + PlayerTypeLow2Heigh.STRAIGHT_FLUSH_MAX_VALUE) * 64
				+ getFlowerValue(player);
	}

	// 获取顺子牌值绝对大小
	public int getStraightValue(Player player) {
		return (14 - player.cards[2].getNumber() + PlayerTypeLow2Heigh.FLUSH_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取对子牌值绝对大小
	// 在判断牌型时，如果是对子，则将对子放在数组前面两位
	public int getDoubleValue(Player player) {
		return ((14 - player.cards[1].getNumber()) * 16 + (14 - player.cards[2].getNumber())
				+ PlayerTypeLow2Heigh.STRAIGHT_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取普通牌值绝对大小
	public int getNormalValue(Player player) {
		return ((14 - player.cards[0].getNumber()) * 256 + (14 - player.cards[1].getNumber()) * 16
				+ (14 - player.cards[2].getNumber()) + PlayerTypeLow2Heigh.DOUBLE_MAX_VALUE) * 64
				+ getFlowerValue(player);
	}

}
