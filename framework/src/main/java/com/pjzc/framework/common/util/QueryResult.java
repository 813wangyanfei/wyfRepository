package com.pjzc.framework.common.util;

import java.util.List;
/**
 * 分页辅助类存放获取List及返回结果行
 * @author mhsdong
 *
 * @param <T>
 */
public class QueryResult<T> {
	private List<T> resultlist;//获取返回列表集合
	private long totalrecord; //获取返回结果行
	private String resultString;// 获取返回字符串
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	
}
