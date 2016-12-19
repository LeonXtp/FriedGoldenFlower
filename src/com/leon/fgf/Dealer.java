package com.leon.fgf;

import java.util.List;

/**
 * 庄家，负责洗牌，发牌，比较牌
 * 
 * @author Leon
 *
 */
public class Dealer {

	// 测试结果：
	// 发出1000副牌耗时3毫秒，计算牌大小并排序耗时5毫秒
	// 发出10000副牌耗时10毫秒，计算牌大小并排序耗时19毫秒
	// 发出100000副牌耗时39毫秒，计算牌大小并排序耗时85毫秒
	// 其他需要请自行测试
	private static final int PlayerNumber = 1000;

	public static void main(String args[]) {
		testOnePlayer();
		System.out.println("\n=================================");
		testManyPlayers();
	}

	private static void testOnePlayer() {
		PlayerJuger juger = new PlayerJuger();
		Card card0 = new Card(Card.FLOWER_SPADE, Card.NUM_A);
		printCard(card0);
		Card card1 = new Card(Card.FLOWER_SPADE, Card.NUM_Q);
		printCard(card1);
		Card card2 = new Card(Card.FLOWER_CLUB, Card.NUM_Q);
		printCard(card2);
		Player player = new Player(card0, card1, card2);
		juger.judgePlayer(player);
		printTypeValue(player);
	}

	private static void testManyPlayers() {
		PlayerGenerator generator = new PlayerGenerator();
		PlayerJuger juger = new PlayerJuger();
		System.out.println("start generate..." + System.currentTimeMillis());
		List<Player> players = generator.generatePlayers(PlayerNumber);
		System.out.println("end generate..." + System.currentTimeMillis());
		juger.sort(players);
		System.out.println("finish sort..." + System.currentTimeMillis());

		 printPlayers(players);
	}

	private static void printPlayers(List<Player> players) {
		for (int i = 0; i < PlayerNumber; i++) {
			System.out.print("玩家_" + i + "_的牌：");
			for (int j = 0; j < 3; j++) {
				printCard(players.get(i).cards[j]);
			}
			printTypeValue(players.get(i));
			System.out.println();
		}
	}

	private static void printCard(Card card) {
		int flower = card.getFlower();
		int number = card.getNumber();
		switch (flower) {
		case Card.FLOWER_SPADE:
			System.out.print("黑桃" + getCardStringNumber(number));
			break;
		case Card.FLOWER_HEART:
			System.out.print("红桃" + getCardStringNumber(number));
			break;
		case Card.FLOWER_CLUB:
			System.out.print("梅花" + getCardStringNumber(number));
			break;
		default:
			System.out.print("方片" + getCardStringNumber(number));
			break;
		}
		System.out.print(", ");
	}

	private static String getCardStringNumber(int number) {
		if (number <= 10) {
			return "" + number;
		} else if (number == 11) {
			return "J";
		} else if (number == 12) {
			return "Q";
		} else if (number == 13) {
			return "K";
		} else {
			return "A";
		}

	}

	private static void printTypeValue(Player player) {
		int type = player.getType();
		int value = player.getValue();
		switch (type) {
		case PlayerType.BOMB:
			System.out.print("炸弹," + value);
			break;
		case PlayerType.STRAIGHT_FLUSH:
			System.out.print("同花顺," + value);
			break;
		case PlayerType.FLUSH:
			System.out.print("同花，" + value);
			break;
		case PlayerType.STRAIGHT:
			System.out.print("顺子," + value);
			break;
		case PlayerType.DOUBLE:
			System.out.print("对子," + value);
			break;
		default:
			if (player.isSpecial()) {
				System.out.print("特殊牌," + value);
			} else {
				System.out.print("普通牌," + value);
			}
			break;
		}
	}

}
