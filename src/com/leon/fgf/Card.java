package com.leon.fgf;

/**
 * µ•’≈≈∆
 * 
 * @author Leon
 *
 */
public class Card {

	public static final int FLOWER_SPADE = 3;//∫⁄Ã“
	public static final int FLOWER_HEART = 2;//∫ÏÃ“
	public static final int FLOWER_CLUB = 1;//√∑ª®
	public static final int FLOWER_DIAMOND = 0;//∑Ω∆¨

	public static final int NUM_A = 14;
	public static final int NUM_K = 13;
	public static final int NUM_Q = 12;
	public static final int NUM_J = 11;
	public static final int NUM_10 = 10;
	public static final int NUM_9 = 9;
	public static final int NUM_8 = 8;
	public static final int NUM_7 = 7;
	public static final int NUM_6 = 6;
	public static final int NUM_5 = 5;
	public static final int NUM_4 = 4;
	public static final int NUM_3 = 3;
	public static final int NUM_2 = 2;

	private int number;
	private int flower;
	
	public Card(){ }

	public Card(int flower, int number) {
		this.flower = flower;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFlower() {
		return flower;
	}

	public void setFlower(int flower) {
		this.flower = flower;
	}

}
