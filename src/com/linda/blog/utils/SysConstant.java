package com.linda.blog.utils;
public class SysConstant {
	
	/**
	 * 成功
	 */
	public static final Integer STATE_SUCCESS = 0;
	
	/**
	 * 失败
	 */
	public static final Integer STATE_FAILURE = -1;
	
	/**
	 * 可用
	 */
	public static final Integer STATE_AVAILABLE = 1;//可用
	
	/**
	 * 不可用
	 */
	public static final Integer STATE_NOT_AVAILABLE = 0;//不可用
	
	/**
	 * 离职
	 */
	public static final Integer STATE_RESIGNED = 2;//resigned 辞职
	/**
	 * 锁定
	 */
	public static final Integer STATE_IS_LOCKED = 3;//resigned 辞职
	/**
	 * 错误
	 */
	public static final Integer STATE_ERROR =100;
	
	/**
	 * cunzai
	 */
	public static final Integer STATE_FAILURE1 = 10000;
	
	/**
	 * news或activity content中是否包含startString  、endString
	 */
	public static String startString="<video class=\"edui-upload-video";
	public static String endString="type=\"video/mp4\"/></video>";

}
