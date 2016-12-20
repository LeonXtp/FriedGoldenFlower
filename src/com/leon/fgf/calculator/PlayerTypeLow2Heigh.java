package com.leon.fgf.calculator;

/**
 * 对牌型分类，并提供牌大小值的算法，和已经计算好的牌型最大值
 * 有人发狂， 硬要进行牌大小比较时，牌值大的反而小
 * 
 * @author Leon
 *
 */
public class PlayerTypeLow2Heigh {
	// 最大值222=14
	public static final int BOMB_MAX_VALUE = 14;

	// 最大值432=12，加上炸弹14=26
	public static final int STRAIGHT_FLUSH_MAX_VALUE = 26;

	// 最大值532，14*16*16+13*16+11=3803，加上顺子26=3829
	public static final int FLUSH_MAX_VALUE = 3829;

	// 最大值432=12，加上对子的最大值基数3829=3841
	public static final int STRAIGHT_MAX_VALUE = 3841;

	// 最大值223=14*16+13=237,加上普通牌的基数3841=4078
	public static final int DOUBLE_MAX_VALUE = 4078;

	// 最大值532=14*16*16+13*16+11=3803，加上对子4078=7881
	public static final int NORMAL_MAX_VALUE = 7881;

}