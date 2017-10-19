package com.blog.util;

import java.util.List;

public class LayuiPage<T> {

	private List<T> data;
	private int code = 0;
	private String msg = "";
	private int count;
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = -7180359178518841827L;
}
