package com.leon.fgf;

/**
 * 对牌型分类，并提供牌大小值的算法，和已经计算好的牌型最大值
 * 
 * @author Leon
 *
 */
public class PlayerType {
	// 炸弹
	public static final int BOMB = 5;
	// 最大值AAA=14，加上同花顺6867=7881
	public static final int BOMB_MAX_VALUE = 7881;
	// 以上乘64
	public static final int BOMB_FLOWER_BASE_MAX_VALUE = 504384;

	// 同花顺
	public static final int STRAIGHT_FLUSH = 4;
	// 最大值AKQ=12，加上同花7855=7867
	public static final int STRAIGHT_FLUSH_MAX_VALUE = 7867;
	// 以上乘64
	public static final int STRAIGHT_FLOWER_FLUSH_BASE_MAX_VALUE = 503448;

	// 同花
	public static final int FLUSH = 3;
	// 最大值AKJ，14*16*16+13*16+11=3803，加上顺子4052=7855
	public static final int FLUSH_MAX_VALUE = 7855;
	// 以上乘64
	public static final int FLUSH_FLOWER_BASE_MAX_VALUE = 502720;

	// 顺子
	public static final int STRAIGHT = 2;
	// 最大值AKQ=12，加上对子的最大值基数4040=4052
	public static final int STRAIGHT_MAX_VALUE = 4052;
	// 以上乘64
	public static final int STRAIGHT_FLOWER_BASE_MAX_VALUE = 259328;

	// 对子
	public static final int DOUBLE = 1;
	// 最大值AAK=14*16+13=237,加上普通牌的基数3803=4040
	public static final int DOUBLE_MAX_VALUE = 4040;
	// 以上乘64
	public static final int DOUBLE_FLOWER_BASE_MAX_VALUE = 258560;

	// 普通牌，里面包含一种特殊牌532不同花色
	public static final int NORMAL = 0;
	// 最大值AKJ=14*16*16+13*16+11=3803
	public static final int NORMAL_MAX_VALUE = 3803;
	// 以上乘64
	public static final int NORMAL_FLOWER_BASE_MAX_VALUE = 243392;

}