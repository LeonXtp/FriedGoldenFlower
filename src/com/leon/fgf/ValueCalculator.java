package com.leon.fgf;

/**
 * 判别牌型，并对其大小进行计算
 * @author Leon
 *
 */
public class ValueCalculator {

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
				int temp = 0;
				if (player.cards[1].getNumber() == player.cards[2].getNumber()) {
					temp = player.cards[0].getNumber();
					player.cards[0].setNumber(player.cards[2].getNumber());
					player.cards[2].setNumber(temp);
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

	private boolean isFlush(Player player) {
		return player.cards[0].getFlower() == player.cards[1].getFlower()
				&& player.cards[1].getFlower() == player.cards[2].getFlower();
	}

	private boolean isStraight(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber() + 1
				&& player.cards[1].getNumber() == player.cards[2].getNumber() + 1;
	}

	private boolean isBmob(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber()
				&& player.cards[1].getNumber() == player.cards[2].getNumber();
	}

	private boolean isDouble(Player player) {
		return player.cards[0].getNumber() == player.cards[1].getNumber()
				|| player.cards[1].getNumber() == player.cards[2].getNumber();
	}

	private boolean isSpecial(Player player) {
		return player.cards[0].getNumber() == 5 && player.cards[1].getNumber() == 3 && player.cards[2].getNumber() == 2;
	}

	private int getBombValue(Player player) {
		return player.cards[0].getNumber() + PlayerType.STRAIGHT_FLUSH_MAX_VALUE;
	}

	private int getStraightFlushValue(Player player) {
		return player.cards[2].getNumber() + PlayerType.FLUSH_MAX_VALUE;
	}

	private int getFlushValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber()
				+ PlayerType.STRAIGHT_MAX_VALUE;
	}

	private int getStraightValue(Player player) {
		return player.cards[2].getNumber() + PlayerType.DOUBLE_MAX_VALUE;
	}

	// 在判断牌型时，如果是对子，则将对子放在数组前面两位
	private int getDoubleValue(Player player) {
		return player.cards[1].getNumber() * 16 + player.cards[2].getNumber() + PlayerType.NORMAL_MAX_VALUE;
	}

	private int getNormalValue(Player player) {
		return player.cards[0].getNumber() * 256 + player.cards[1].getNumber() * 16 + player.cards[2].getNumber();
	}

}