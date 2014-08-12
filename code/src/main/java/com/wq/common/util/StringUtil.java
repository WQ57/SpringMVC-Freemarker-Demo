package com.wq.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串操作工具类.
 * 
 * @author qingwu
 * @date 2012-7-28 下午02:43:17
 */
public class StringUtil {

	/**
	 * 字符串是否存在中文.
	 * 
	 * @param str
	 * @return
	 * @author qingwu
	 * @date 2012-9-21 下午03:24:33
	 */
	public static boolean isExistZH(String str) {
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串第一个字母大写.
	 * 
	 * @param s
	 * @return
	 * @author qingwu
	 * @date 2012-9-27 下午03:10:46
	 */
	public static String upperFirstChar(String s) {
		if (!ObjectUtil.isEmpty(s)) {
			return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
		} else {
			return s;
		}
	}

	/**
	 * 字符串第一个字母小写.
	 * 
	 * @param s
	 * @return
	 * @author qingwu
	 * @date 2012-9-27 下午03:10:58
	 */
	public static String lowerFirstChar(String s) {
		if (!ObjectUtil.isEmpty(s)) {
			return String.valueOf(s.charAt(0)).toLowerCase() + s.substring(1);
		} else {
			return s;
		}
	}

	/**
	 * 获取第一个大写字母.
	 * 
	 * @param s
	 * @return
	 * @author qingwu
	 * @date 2012-10-23 上午09:06:18
	 */
	public static String getUpperFirstChar(String s) {
		if (!ObjectUtil.isEmpty(s)) {
			return String.valueOf(s.charAt(0)).toUpperCase();
		} else {
			return s;
		}
	}

	/**
	 * 四舍五入并去掉科学计数法, 默认小数点2位.
	 * 
	 * @param value
	 *            String, double, Double, BigDecimal
	 * @return
	 * @author qingwu
	 * @date 2012-7-28 下午03:44:05
	 */
	public static String toNuSicen(Object value) {
		return toNuSicen(value, 2);
	}

	/**
	 * 四舍五入并去掉科学计数法.
	 * 
	 * @param value
	 *            String, double, Double, BigDecimal
	 * @param precision
	 *            保留几位小数
	 * @return
	 * @author qingwu
	 * @date 2012-7-28 下午03:47:25
	 */
	public static String toNuSicen(Object value, int precision) {
		Object result = "";
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(precision);
		df.setMaximumFractionDigits(precision);
		df.setGroupingUsed(false);
		if (ObjectUtil.isEmpty(value)) {
			return df.format(0);
		} else if (value instanceof BigDecimal) {
			result = value;
		} else if (value instanceof String) {
			result = new BigDecimal(String.valueOf(value));
		} else if (value instanceof Number) {
			result = Double.parseDouble(value.toString());
		} else {
			throw new IllegalArgumentException(value
					+ "need extends Number or String");
		}
		return df.format(result);
	}

	/**
	 * 获取不区分大小写正则Pattern<br>
	 * .可代表换行符.<br>
	 * 正则表达式的特殊字符,依然代表普通字符
	 * 
	 * @param value
	 * @return
	 * @author qingwu
	 * @date 2012-10-9 下午03:32:33
	 */
	public static Pattern getInsensitivePattern(String value) {
		return Pattern
				.compile(
						ValueUtil
								.getString(value)
								.replaceAll(
										"([\\+\\-\\&\\.\\|\\!\\(\\)\\{\\}\\[\\]\\^\\\"\\~\\*\\?\\:])",
										"\\\\$1"), Pattern.CASE_INSENSITIVE
								+ Pattern.DOTALL);
	}

	/**
	 * 截取字符串的尾部.
	 * 
	 * @param value
	 *            源字符串
	 * @param separator
	 *            分割符
	 * @return
	 * @author qingwu
	 * @date 2013-2-19 下午6:17:23
	 */
	public static String subLast(String value, String separator) {
		return StringUtils.substringAfterLast(value, separator);
	}

	/**
	 * 截取字符串的头部.
	 * 
	 * @param value
	 *            源字符串
	 * @param separator
	 *            分割符
	 * @return
	 * @author qingwu
	 * @date 2013-2-19 下午6:17:23
	 */
	public static String subBefore(String value, String separator) {
		return StringUtils.substringBeforeLast(value, separator);
	}

	/**
	 * 字符串数组是否包含str.
	 * 
	 * @param arry
	 *            字符串数组
	 * @param str
	 *            目标字符
	 * @return [true:包含,false:不包含]
	 * @author qingwu
	 * @date 2013-2-19 下午6:17:23
	 */
	public static boolean contans(String[] arry, String str) {
		for (int i = 0; i < arry.length; i++) {
			if (arry[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * map[String,Object]转为map[String,String].
	 * 
	 * @param sMap
	 *            源map
	 * @return <String,String>类型的参数map
	 * @author qingwu
	 * @date 2013-4-8 下午15:00:00
	 */
	public static Map<String, String> castMap(Map<String, Object> sMap) {
		Map<String, String> map = new HashMap<String, String>();
		Set<String> set = sMap.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object obj = sMap.get(key);
			map.put(key, ValueUtil.getString(obj));
		}
		return map;
	}

	/**
	 * 指定随机长度字符串.
	 * 
	 * @param length
	 * @return
	 */
	public static String randString(int length) {
		if (length < 9) {
			throw new UnCaughtException("length must greater than 10 : "
					+ length);
		}
		String result = "";
		String str = "qwertyuiopasdfghjklzxcvbnm1234567890";
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			result += str.charAt(rand.nextInt(36));
		}
		return result;
	}

	/**
	 * 获得随机字符串.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-1-23 下午4:46:01
	 */
	public static String randString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
