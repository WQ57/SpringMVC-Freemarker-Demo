package com.wq.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 测试DTO.
 * 
 * @author qingwu
 * @date 2014-3-21 上午9:53:59
 */
public class TestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7835040757972828392L;

	/**
	 * 字符串类型.
	 */
	private String str;

	/**
	 * 时间类型.
	 */
	private Timestamp date;

	/**
	 * 整形数字类型.
	 */
	private Long num;

	/**
	 * 浮点型数字类型.
	 */
	private Double d;

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str
	 *            the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * @return the num
	 */
	public Long getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(Long num) {
		this.num = num;
	}

	/**
	 * @return the d
	 */
	public Double getD() {
		return d;
	}

	/**
	 * @param d
	 *            the d to set
	 */
	public void setD(Double d) {
		this.d = d;
	}

}
