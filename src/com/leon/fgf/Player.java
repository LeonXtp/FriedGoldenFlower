package com.leon.fgf;

/**
 * 玩家
 * 
 * @author Leon
 *
 */
public class Player {

	public Card[] cards = new Card[3];

	private int type;

	private boolean isSpecial = false;

	private int value;

	public Player() { }

	public Player(Card card0, Card card1, Card card2) {
		this.cards[0] = card0;
		this.cards[1] = card1;
		this.cards[2] = card2;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

}
