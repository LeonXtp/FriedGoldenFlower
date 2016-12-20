package com.leon.fgf.calculator;

/**
 * 对牌型分类，并提供牌大小值的算法，和已经计算好的牌型最大值
 * 
 * @author Leon
 *
 */
public class PlayerTypeLow2Heigh {
	// 炸弹
	public static final int BOMB = 5;
	// 最大值222=14
	public static final int BOMB_MAX_VALUE = 14;

	// 同花顺
	public static final int STRAIGHT_FLUSH = 4;
	// 最大值432=12，加上炸弹14=26
	public static final int STRAIGHT_FLUSH_MAX_VALUE = 26;

	// 同花
	public static final int FLUSH = 3;
	// 最大值AKJ，14*16*16+13*16+11=3803，加上顺子26=3829
	public static final int FLUSH_MAX_VALUE = 3829;

	// 顺子
	public static final int STRAIGHT = 2;
	// 最大值AKQ=12，加上对子的最大值基数3829=3841
	public static final int STRAIGHT_MAX_VALUE = 3841;

	// 对子
	public static final int DOUBLE = 1;
	// 最大值AAK=14*16+13=237,加上普通牌的基数3841=4078
	public static final int DOUBLE_MAX_VALUE = 4078;

	// 普通牌，里面包含一种特殊牌532不同花色
	public static final int NORMAL = 0;
	// 最大值AKJ=14*16*16+13*16+11=3803，加上对子4078=7881
	public static final int NORMAL_MAX_VALUE = 7881;

}