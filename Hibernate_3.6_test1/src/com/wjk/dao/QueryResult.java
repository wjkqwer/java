package com.wjk.dao;

import java.util.List;

import com.wjk.test.User;

public class QueryResult {
	
	//总记录数
	private int count;
	//一页的数据
	private List<User> list;
	
	public QueryResult(int count, List<User> list) {
		super();
		this.count = count;
		this.list = list;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
}
