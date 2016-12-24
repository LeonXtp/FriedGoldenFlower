package com.leon.fgf.entity;

/**
 * 玩家，对应一副牌
 * 
 * @author Leon
 *
 */
public class Player {

	public Card[] cards = new Card[3];
	// 牌类型
	private int type;
	// 是否为特殊牌
	private boolean isSpecial = false;
	// A32也是顺子，比花色时，从3开始比较
	private boolean isA32 = false;
	// 牌绝对值大小
	private int value;

	public Player() {
	}

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

	public boolean isA32() {
		return isA32;
	}

	public void setA32(boolean isA32) {
		this.isA32 = isA32;
	}

}
