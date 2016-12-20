package com.leon.fgf.util;

import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;

public class PlayerUtil {

	// 将一副牌按牌面从大到小排序
	public static void sortPlayer(Player player) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3 - i - 1; j++) {
				if (player.cards[j].getNumber() < player.cards[j + 1].getNumber()) {
					Card tempCard = player.cards[j];
					player.cards[j] = player.cards[j + 1];
					player.cards[j + 1] = tempCard;
				}
			}
		}
	}

}
