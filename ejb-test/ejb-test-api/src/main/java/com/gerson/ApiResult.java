package com.gerson;

import java.util.List;

public class ApiResult implements IResult {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<IResultRow> result;
	public ApiResult() {
		
	}
	public ApiResult(List<IResultRow> hellowList) {
		this();
		this.result=hellowList;
	}
	public List<IResultRow> getResult() {
		return result;
	}
	public void setResult(List<IResultRow> result) {
		this.result = result;
	}
	
}
