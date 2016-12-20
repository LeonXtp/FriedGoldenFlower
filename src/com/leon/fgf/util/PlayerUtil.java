package com.leon.fgf.util;

import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;

public class PlayerUtil {

	// 将一副牌按牌面从大到小排序
	public static void sortPlayerByNumber(Player player) {
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

	// 将一副牌按花色从大到小排序
	public static void sortPlayerByFlower(Player player) {
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

	public static void moveDouble2Front(Player player) {
		if (player.cards[1].getNumber() == player.cards[2].getNumber()) {
			Card tempCard = player.cards[0];
			player.cards[0] = player.cards[2];
			player.cards[2] = tempCard;
		}
	}

	public static void exchangeSortedDoubleFlower(Player player) {
		if (player.cards[0].getFlower() < player.cards[1].getFlower()) {
			Card tempCard = player.cards[0];
			player.cards[0] = player.cards[1];
			player.cards[1] = tempCard;
		}
	}

}
