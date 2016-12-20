package com.leon.fgf.calculator.impl;

import com.leon.fgf.PlayerType;
import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;

public class FlowerValueCalculator implements ValueCalculator {

	private int getFlowerValue(Player player) {
		return player.cards[0].getFlower() * 16 + player.cards[1].getFlower() * 4 + player.cards[2].getFlower();
	}

	// 获取炸弹牌值绝对大小
	public int getBombValue(Player player) {
		// 炸弹需要先对牌按花色大小排序，保证比如黑桃A红桃A方片A会>红桃A梅花A方片A
		sortByFlower(player);
		return (player.cards[0].getNumber() + PlayerType.STRAIGHT_FLUSH_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 将一副牌按花色从大到小排序
	private void sortByFlower(Player player) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3 - i - 1; j++) {
				if (player.cards[j].getFlower() < player.cards[j + 1].getFlower()) {
					Card tempCard = player.cards[j];
					player.cards[j] = player.cards[j + 1];
					player.cards[j + 1] = tempCard;
				}
			}
		}
	}

	// 获取同花顺牌值绝对大小
	public int getStraightFlushValue(Player player) {
		return (player.cards[2].getNumber() + PlayerType.FLUSH_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取同花牌值绝对大小
	public int getFlushValue(Player player) {
		return (player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber()
				+ PlayerType.STRAIGHT_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取顺子牌值绝对大小
	public int getStraightValue(Player player) {
		return (player.cards[2].getNumber() + PlayerType.DOUBLE_MAX_VALUE) * 64 + getFlowerValue(player);
	}

	// 获取对子牌值绝对大小
	// 在判断牌型时，如果是对子，则将对子放在数组前面两位
	public int getDoubleValue(Player player) {
		return (player.cards[1].getNumber() * 16 + player.cards[2].getNumber() + PlayerType.NORMAL_MAX_VALUE) * 64
				+ getFlowerValue(player);
	}

	// 获取普通牌值绝对大小
	public int getNormalValue(Player player) {
		return (player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber()) * 64
				+ getFlowerValue(player);
	}
}
