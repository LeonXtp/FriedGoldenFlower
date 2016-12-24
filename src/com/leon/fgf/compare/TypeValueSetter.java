package com.leon.fgf.compare;

import com.leon.fgf.calculator.PlayerType;
import com.leon.fgf.calculator.ValueCalculator;
import com.leon.fgf.entity.Player;
import com.leon.fgf.util.PlayerUtil;

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
	public Player regPlayerType(Player player) {
		if (isFlush(player)) {
			if (isStraight(player)) {// 同花顺
				player.setType(PlayerType.STRAIGHT_FLUSH);
				player.setValue(calculator.getStraightFlushValue(player));
			} else {// 同花
				player.setType(PlayerType.FLUSH);
				player.setValue(calculator.getFlushValue(player));
			}
		} else if (isStraight(player)) {// 顺子
			player.setType(PlayerType.STRAIGHT);
			player.setValue(calculator.getStraightValue(player));
		} else if (isDouble(player)) {
			if (isBmob(player)) {// 炸弹
				player.setType(PlayerType.BOMB);
				player.setValue(calculator.getBombValue(player));
			} else {// 对子
				player.setType(PlayerType.DOUBLE);
				// 将对子放到玩家牌的前两张的位置,以便于之后的牌值计算
				PlayerUtil.moveDouble2Front(player);
				player.setValue(calculator.getDoubleValue(player));
			}
		} else {// 普通牌
			player.setType(PlayerType.NORMAL);
			player.setValue(calculator.getNormalValue(player));
			if (isSpecial(player)) {// 对于特殊牌，本算法不提供特殊大小计算，外部调用者自行判断是否有炸弹玩家产生
				player.setSpecial(true);
			}
		}
		return player;
	}

	// 是否同花
	private boolean isFlush(Player player) {
		return player.cards[0].getFlower() == player.cards[1].getFlower()
				&& player.cards[1].getFlower() == player.cards[2].getFlower();
	}

	// 是否顺子,A32也是同花顺，是最小的同花顺(参考自百度百科)
	// 花色参与比较的时候，黑桃A红桃3黑桃2<方片A黑桃3方片2
	private boolean isStraight(Player player) {
		boolean isNomalStraight = player.cards[0].getNumber() == player.cards[1].getNumber() + 1
				&& player.cards[1].getNumber() == player.cards[2].getNumber() + 1;
		boolean isA32 = player.cards[0].getNumber() == 14 && player.cards[1].getNumber() == 3
				&& player.cards[2].getNumber() == 2;
		if (isA32) {
			player.setA32(true);
		}
		return isNomalStraight || isA32;
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
