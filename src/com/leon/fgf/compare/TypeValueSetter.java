package com.leon.fgf.compare;

import com.leon.fgf.PlayerType;
import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;

/**
 * 牌型识别器，负责鉴定牌型，并按照指定的模式计算牌大小
 * 
 * @author Leon
 *
 */
public class TypeValueSetter {

	private ValueCalculator calculator;

	public TypeValueSetter(ValueCalculator calculator) {
		this.calculator = calculator;
	}

	// 判断牌型、计算牌型绝对值大小
	public void regPlayerType(Player player) {
		if (isFlush(player)) {
			if (isStraight(player)) {// 同花顺
				player.setType(PlayerType.STRAIGHT_FLUSH);
				player.setValue(calculator.getStraightFlushValue(player));
			} else {// 同花
				player.setType(PlayerType.FLUSH);
				player.setValue(calculator.getFlushValue(player));
			}
		} else if (isStraight(player)) {
			player.setType(PlayerType.STRAIGHT);
			player.setValue(calculator.getStraightValue(player));
		} else if (isDouble(player)) {// 对子
			if (isBmob(player)) {// 炸弹
				player.setType(PlayerType.BOMB);
				player.setValue(calculator.getBombValue(player));
			} else {
				player.setType(PlayerType.DOUBLE);
				// 将对子放到玩家牌的前两张的位置,以便于之后的牌值计算
				if (player.cards[1].getNumber() == player.cards[2].getNumber()) {
					Card tempCard = player.cards[0];
					player.cards[0] = player.cards[2];
					player.cards[2] = tempCard;
				}
				player.setValue(calculator.getDoubleValue(player));
			}
		} else {// 普通牌
			player.setType(PlayerType.NORMAL);
			player.setValue(calculator.getNormalValue(player));
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
}
