package com.leon.fgf.compare;

import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;

/**
 * 判别牌型，并对其大小进行计算
 * 
 * @author Leon
 *
 */
public class ValueCalculator {

	// 判断牌型、计算牌型绝对值大小
	public void setupPlayer(Player player) {
		if (isFlush(player)) {
			if (isStraight(player)) {// 同花顺
				player.setType(PlayerType.STRAIGHT_FLUSH);
				player.setValue(getStraightFlushValue(player));
			} else {// 同花
				player.setType(PlayerType.FLUSH);
				player.setValue(getFlushValue(player));
			}
		} else if (isStraight(player)) {
			player.setType(PlayerType.STRAIGHT);
			player.setValue(getStraightValue(player));
		} else if (isDouble(player)) {// 对子
			if (isBmob(player)) {// 炸弹
				player.setType(PlayerType.BOMB);
				player.setValue(getBombValue(player));
			} else {
				player.setType(PlayerType.DOUBLE);
				// 将对子放到玩家牌的前两张的位置,以便于之后的牌值计算
				if (player.cards[1].getNumber() == player.cards[2].getNumber()) {
					Card tempCard = player.cards[0];
					player.cards[0] = player.cards[2];
					player.cards[2] = tempCard;
				}
				player.setValue(getDoubleValue(player));
			}
		} else {// 普通牌
			player.setType(PlayerType.NORMAL);
			player.setValue(getNormalValue(player));
			if (isSpecial(player)) {
				player.setSpecial(true);
			}
		}
	}

	// 是否同花
	private boolean isFlush(Player player) {
		return player.cards[0].getFlower() == player.cards[1].getFlower()
				&& player.cards[1].getFlower() == player.cards[2].getFlower();
	}

	// 是否顺子
	private boolean isStraight(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber() + 1
				&& player.cards[1].getNumber() == player.cards[2].getNumber() + 1;
	}

	// 是否炸弹
	private boolean isBmob(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber()
				&& player.cards[1].getNumber() == player.cards[2].getNumber();
	}

	// 是否对子
	private boolean isDouble(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber()
				|| player.cards[1].getNumber() == player.cards[2].getNumber();
	}

	// 是否特殊牌
	private boolean isSpecial(Player player) {
		return player.cards[0].getNumber() == 5 && player.cards[1].getNumber() == 3 && player.cards[2].getNumber() == 2;
	}

	// 获取炸弹牌值绝对大小
	private int getBombValue(Player player) {
		return player.cards[0].getNumber() + PlayerType.STRAIGHT_FLUSH_MAX_VALUE;
	}

	// 获取同花顺牌值绝对大小
	private int getStraightFlushValue(Player player) {
		return player.cards[2].getNumber() + PlayerType.FLUSH_MAX_VALUE;
	}

	// 获取同花牌值绝对大小
	private int getFlushValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber()
				+ PlayerType.STRAIGHT_MAX_VALUE;
	}

	// 获取顺子牌值绝对大小
	private int getStraightValue(Player player) {
		return player.cards[2].getNumber() + PlayerType.DOUBLE_MAX_VALUE;
	}

	// 获取对子牌值绝对大小
	// 在判断牌型时，如果是对子，则将对子放在数组前面两位
	private int getDoubleValue(Player player) {
		return player.cards[1].getNumber() * 16 + player.cards[2].getNumber() + PlayerType.NORMAL_MAX_VALUE;
	}

	// 获取普通牌值绝对大小
	private int getNormalValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber();
	}

}