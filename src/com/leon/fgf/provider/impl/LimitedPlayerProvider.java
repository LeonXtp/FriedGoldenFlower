package com.leon.fgf.provider.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.leon.fgf.entity.Card;
import com.leon.fgf.entity.Player;
import com.leon.fgf.provider.PlayerProvider;

/**
 * 有限制的发牌器，只有一副牌，玩家数量有限
 * 
 * @author Leon
 *
 */
public class LimitedPlayerProvider implements PlayerProvider {

	private List<Card> cards = new ArrayList<>();
	private Random random = new Random();

	public LimitedPlayerProvider() {
		this.initCards();
	}

	// 产生一副新的牌
	private void initCards() {
		cards.clear();
		for (int i = 14; i > 1; i--) {
			for (int j = 3; j >= 0; j--) {
				Card card = new Card(j, i);
				cards.add(card);
			}
		}
	}

	@Override
	public Player getSinglePlayer() {
		if (cards.size() < 3) {// 牌不够发了，请洗牌！
			return null;
		}
		Player player = new Player();
		for (int i = 0; i < 3; i++) {
			// 随机从一副有序的牌中抽取一张牌
			player.cards[i] = getCard();
		}
		sort(player);
		return player;
	}

	@Override
	public List<Player> getPlayers(int number) {
		if (cards.size() == 52 && number > 17) {
			throw new IllegalArgumentException("这么多人玩？牌都不够发!");
		} else if (number * 3 > cards.size()) {
			return null;
		}
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			Player player = getSinglePlayer();
			players.add(player);
		}
		return players;
	}

	@Override
	public void shuffle() {
		this.initCards();
	}

	// 将一副牌按牌面从大到小排序
	private void sort(Player player) {
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

	@Override
	public Card getCard() {
		return cards.size() > 0 ? cards.remove(random.nextInt(cards.size())) : null;
	}
}
